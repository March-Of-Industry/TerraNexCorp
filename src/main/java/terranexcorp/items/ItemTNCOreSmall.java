package terranexcorp.items;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import terranexcorp.core.TNCDetails;
import terranexcorp.core.TNCTab;

import com.bioxx.tfc.api.TFCOptions;
import com.bioxx.tfc.api.Enums.EnumSize;
import com.bioxx.tfc.api.Enums.EnumWeight;

public class ItemTNCOreSmall extends ItemTNCOre
{

    public ItemTNCOreSmall()
    {
        super();
        setHasSubtypes(true);
        this.setWeight(EnumWeight.HEAVY);
        this.setSize(EnumSize.TINY);
        metaNames = new String[]{"Chromite","Ilmenite","Rutile","Pyrolusite"};

    }


    @Override
    public void getSubItems(Item item, CreativeTabs tabs, List list)
    {
        for(int i = 0; i < metaNames.length; ++i)
        {
            list.add(new ItemStack(this, 1, i));
        }
    }

    @Override
    public void registerIcons(IIconRegister registerer)
    {
        metaIcons = new IIcon[(metaNames.length)];
        for(int i = 0; i < (metaNames.length); i++)
        {
            metaIcons[i] = registerer.registerIcon(TNCDetails.ModID + ":ores/"+ metaNames[i] + "_Small_Ore");
        }
    }

    @Override
    public short getMetalReturnAmount(ItemStack is)
    {
        return (short) TFCOptions.smallOreUnits;

    }

    @Override
    public EnumTier getSmeltTier(ItemStack is)
    {
        switch (is.getItemDamage())
        {
            case 0: return EnumTier.TierIV;
            case 1:	return EnumTier.TierIV;
            case 2: return EnumTier.TierIV;
            case 3: return EnumTier.TierIV;
            default: return EnumTier.TierX;
        }
    }
}