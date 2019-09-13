package terranexcorp.minetweaker.IE;

import blusunrize.immersiveengineering.api.ApiUtils;
import blusunrize.immersiveengineering.common.util.Utils;
import cpw.mods.fml.common.registry.GameData;
import minetweaker.IUndoableAction;
import minetweaker.MineTweakerAPI;
import minetweaker.api.liquid.ILiquidStack;
import minetweaker.api.minecraft.MineTweakerMC;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.oredict.OreDictionary;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import blusunrize.immersiveengineering.api.energy.DieselHandler;

@ZenClass("mods.TNCtweaks.IEFuels")
public class IEFuels
{
    //Ex. Biodiesel/125, Fuel/375, Diesel/175
    @ZenMethod
    public static void addFuel(ILiquidStack fluidstack, int time)
    {
        Fluid fluid = MineTweakerMC.getLiquidStack(fluidstack).getFluid();

        MineTweakerAPI.apply(new addIEFuels(fluid, time));
    }

    @ZenMethod
    public static void removeFuel(ILiquidStack fluidstack)
    {
        Fluid fluid = MineTweakerMC.getLiquidStack(fluidstack).getFluid();

        MineTweakerAPI.apply(new removeIEFuels(fluid));
    }

    private static class addIEFuels implements IUndoableAction
    {
        Fluid fluid;
        int burnTime;

        public addIEFuels(Fluid fuel, int time)
        {
            this.fluid = fuel;
            this.burnTime = time;
        }

        @Override
        public void apply()
        {
            DieselHandler.registerFuel(fluid, burnTime);
        }

        @Override
        public String describe()
        {
            return "Adding fuel '" + fluid.getLocalizedName(new FluidStack(fluid, 1000)) + "' to IE fuels.'";
        }

        @Override
        public boolean canUndo()
        {
            return true;
        }

        @Override
        public void undo()
        {
            HashMap<String, Integer> fuelHandler = DieselHandler.getFuelValues();

            fuelHandler.remove(fluid.getName(), burnTime);
        }

        @Override
        public String describeUndo()
        {
            return "Removing fuel '" + fluid.getLocalizedName(new FluidStack(fluid, 1000)) + "' from IE fuels.'";
        }

        @Override
        public Object getOverrideKey()
        {
            return null;
        }
    }

    private static class removeIEFuels implements IUndoableAction
    {
        Fluid fluid;
        int burnTime;

        public removeIEFuels(Fluid fuel)
        {
            this.fluid = fuel;
            burnTime = DieselHandler.getBurnTime(fluid);
        }

        @Override
        public void apply()
        {
            HashMap<String, Integer> fuelHandler = DieselHandler.getFuelValues();

            if(burnTime != 0)
                fuelHandler.remove(fluid.getName(), burnTime);
        }

        @Override
        public String describe()
        {
            return "Removing fuel '" + fluid.getLocalizedName(new FluidStack(fluid, 1000)) + "' from IE fuels.";
        }

        @Override
        public boolean canUndo()
        {
            return true;
        }

        @Override
        public void undo()
        {
            if(burnTime != 0)
                DieselHandler.registerFuel(fluid, burnTime);
        }

        @Override
        public String describeUndo()
        {
            return "Adding fuel '" + fluid.getLocalizedName(new FluidStack(fluid, 1000)) + "' to IE fuels.";
        }

        @Override
        public Object getOverrideKey()
        {
            return null;
        }
    }

    static String[][] formatToTable_ItemIntHashmap(Map<String, Integer> map, String valueType)
    {
        Map.Entry<String,Integer>[] sortedMapArray = map.entrySet().toArray(new Map.Entry[0]);
        ArrayList<String[]> list = new ArrayList();
        try{
            for(int i=0; i<sortedMapArray.length; i++)
            {
                String item = null;
                if(ApiUtils.isExistingOreName(sortedMapArray[i].getKey()))
                {
                    ItemStack is = OreDictionary.getOres(sortedMapArray[i].getKey()).get(0);
                    if(is!=null)
                        item = is.getDisplayName();
                }
                else if(sortedMapArray[i].getKey().contains("::"))
                {
                    String[] split = sortedMapArray[i].getKey().split("::");
                    Item it = GameData.getItemRegistry().getObject(split[0]);
                    int meta = 0;
                    try{meta = Integer.parseInt(split[1]);}catch(Exception e){}
                    if(it!=null)
                        item = new ItemStack(it, 1, meta).getDisplayName();
                }
                else
                    item = sortedMapArray[i].getKey();

                if(item!=null)
                {
                    int bt = sortedMapArray[i].getValue();
                    String am = bt+" "+valueType;
                    list.add(new String[]{item,am});
                }
            }
        }catch(Exception e)	{}
        String[][] table = list.toArray(new String[0][]);
        return table;
    }
}