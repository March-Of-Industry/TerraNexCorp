package terranexcorp.items;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import terranexcorp.core.TNCDetails;
import terranexcorp.core.TNCTab;

import com.bioxx.tfc.Core.TFCTabs;
import com.bioxx.tfc.Core.TFC_Core;
import com.bioxx.tfc.Core.Metal.Alloy;
import com.bioxx.tfc.Core.Metal.AlloyManager;
import com.bioxx.tfc.Core.Metal.MetalRegistry;
import com.bioxx.tfc.Items.ItemTerra;
import com.bioxx.tfc.api.HeatRegistry;
import com.bioxx.tfc.api.Metal;
import com.bioxx.tfc.api.TFC_ItemHeat;
import com.bioxx.tfc.api.Enums.EnumSize;
import com.bioxx.tfc.api.Enums.EnumWeight;
import com.bioxx.tfc.api.Interfaces.ISmeltable;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemTNCMetalItem extends ItemTerra implements ISmeltable {

    private EnumSize size = EnumSize.SMALL;
    private String metal;
    private short metalAmount;
    private boolean smeltable = true;

    public ItemTNCMetalItem() {
        super();
        setCreativeTab(TNCTab.TNC_TAB);
        metalAmount = 100;
    }

    public ItemTNCMetalItem(boolean canSmelt) {
        this();
        setCreativeTab(TNCTab.TNC_TAB);
        smeltable = canSmelt;
    }

    public ItemTNCMetalItem(String m, int amt, String folder) {
        this();
        this.setFolder(folder + "/");
        this.setMetal(m, amt);
        setCreativeTab(TNCTab.TNC_TAB);
        if (amt > 100) {
            size = EnumSize.LARGE;
        }
    }

    public ItemTNCMetalItem setMetal(String m, int amt) {
        metal = m;
        metalAmount = (short) amt;
        setCreativeTab(TNCTab.TNC_TAB);
        return this;
    }

    @Override
    public void registerIcons(IIconRegister registerer) {
        this.itemIcon = registerer.registerIcon(TNCDetails.ModID + ":" + this.getUnlocalizedName().replace("item.", ""));
    }

    @Override
    @SideOnly(Side.CLIENT)
    public boolean requiresMultipleRenderPasses() {
        return true;
    }

    @Override
    public EnumSize getSize(ItemStack is) {
        return size;
    }

    @Override
    public EnumWeight getWeight(ItemStack is) {
        return EnumWeight.MEDIUM;
    }

    @Override
    public ItemTNCMetalItem setSize(EnumSize s) {
        size = s;
        return this;
    }

    public void addCreativeItems(List<ItemStack> list) {
        list.add(new ItemStack(this));
    }

    @Override
    public Metal getMetalType(ItemStack is) {
        if (metal == null) {
            return MetalRegistry.instance.getMetalFromItem(this);
        } else {
            return MetalRegistry.instance.getMetalFromString(metal);
        }
    }

    @Override
    public short getMetalReturnAmount(ItemStack is) {
        return metalAmount;
    }

    public void setSmeltable(boolean smeltable) {
        this.smeltable = smeltable;
    }

    @Override
    public boolean isSmeltable(ItemStack is) {
        return smeltable;
    }

    @Override
    public EnumTier getSmeltTier(ItemStack is) {
        if (metal == null)
            return EnumTier.TierI;
        AlloyManager manager = AlloyManager.INSTANCE;
        for (Alloy alloy : manager.alloys) {
            if (alloy.outputType.name.equals(metal))
                return ISmeltable.EnumTier.valueOf(alloy.getFurnaceTier().name());
        }
        return EnumTier.TierI;
    }

    @Override
    public void addItemInformation(ItemStack is, EntityPlayer player, List<String> arraylist) {
        boolean showAllInfo = false;
        if (TFC_ItemHeat.hasTemp(is)) {
            String s = "";
            if (HeatRegistry.getInstance().isTemperatureDanger(is)) {
                s += EnumChatFormatting.WHITE + TFC_Core.translate("gui.ingot.danger") + (showAllInfo ? " | " : "");
            }

            if (HeatRegistry.getInstance().isTemperatureWeldable(is) && showAllInfo) {
                s += EnumChatFormatting.WHITE + TFC_Core.translate("gui.ingot.weldable") + " | ";
            }

            if (HeatRegistry.getInstance().isTemperatureWorkable(is) && showAllInfo) {
                s += EnumChatFormatting.WHITE + TFC_Core.translate("gui.ingot.workable");
            }

            if (!"".equals(s))
                arraylist.add(s);
        }
    }
}