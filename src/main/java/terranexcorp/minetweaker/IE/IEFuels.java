package terranexcorp.minetweaker.IE;


import minetweaker.IUndoableAction;
import minetweaker.MineTweakerAPI;
import minetweaker.api.liquid.ILiquidStack;
import minetweaker.api.minecraft.MineTweakerMC;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;
import java.util.HashMap;

import blusunrize.immersiveengineering.api.energy.DieselHandler;

@ZenClass("mods.TNCtweaks.IEFuels")
public class IEFuels
{
    //Ex. Biodiesel/125, Fuel/375, Diesel/175
    @ZenMethod
    public static void addFuel(ILiquidStack fuel, int time)
    {
        MineTweakerAPI.apply(new addIEFuels(fuel, time));
    }

    @ZenMethod
    public static void removeFuel(ILiquidStack fuel)
    {
        MineTweakerAPI.apply(new removeIEFuels(fuel));
    }

    private static class addIEFuels implements IUndoableAction
    {
        private final ILiquidStack fuel;
        private final int time;

        public addIEFuels(ILiquidStack fuel, int time)
        {
            this.fuel = fuel;
            this.time = time;
        }

        @Override
        public void apply()
        {
            Fluid fuelFluid = FluidRegistry.getFluid(fuel.getName());
            DieselHandler.registerFuel(fuelFluid, time);
        }

        @Override
        public String describe()
        {
            return "Registering Diesel Generator Fuel "+fuel.getDisplayName();
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

            fuelHandler.remove(fuel.getName());
        }

        @Override
        public String describeUndo()
        {
            return "Removing Diesel Generator Fuel "+fuel.getDisplayName();
        }

        @Override
        public Object getOverrideKey()
        {
            return null;
        }
    }

    private static class removeIEFuels implements IUndoableAction
    {
        private final ILiquidStack fuel;
        private final int time;
        public removeIEFuels(ILiquidStack fuel)
        {
            this.fuel = fuel;
            this.time = DieselHandler.getBurnTime(FluidRegistry.getFluid(fuel.getName()));
        }

        @Override
        public void apply()
        {
            HashMap<String, Integer> fuelHandler = DieselHandler.getFuelValues();
            Fluid fuelFluid = FluidRegistry.getFluid(fuel.getName());
            fuelHandler.remove(fuelFluid);
        }

        @Override
        public String describe()
        {
            return "Removing Diesel Generator Fuel "+fuel.getDisplayName();
        }

        @Override
        public boolean canUndo()
        {
            return true;
        }

        @Override
        public void undo()
        {
            Fluid fuelFluid = FluidRegistry.getFluid(fuel.getName());
            DieselHandler.registerFuel(fuelFluid,time);
        }

        @Override
        public String describeUndo()
        {
            return "Registering Diesel Generator Fuel " + fuel.getDisplayName();
        }

        @Override
        public Object getOverrideKey()
        {
            return null;
        }
    }

}