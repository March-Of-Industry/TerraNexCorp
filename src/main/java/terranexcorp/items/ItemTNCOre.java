package terranexcorp.items;
import terranexcorp.core.TNCDetails;
import terranexcorp.core.TNCGlobals;
import com.bioxx.tfc.Items.ItemOre;
import com.bioxx.tfc.api.Metal;
import com.bioxx.tfc.api.TFCOptions;
import terranexcorp.core.TNCTab;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class ItemTNCOre extends ItemOre
{
	public ItemTNCOre()
	{
		super();
		metaNames = new String[] {"Chromite", "Rich Chromite", "Poor Chromite"};
		setCreativeTab(TNCTab.TNC_TAB);
	}

	@Override
	public void registerIcons(IIconRegister registerer)
	{
		metaIcons = new IIcon[metaNames.length];
		for(int i = 0; i < metaNames.length; i++)
			metaIcons[i] = registerer.registerIcon(TNCDetails.ModID + ":ores/"  + metaNames[i] + " Ore");
	}

	@Override
	public Metal getMetalType(ItemStack is)
	{
		switch(is.getItemDamage())
		{
			case 0: case 1: case 2: return TNCGlobals.FERROCHROME;
			default: return null;
		}
	}

	@Override
	public short getMetalReturnAmount(ItemStack is)
	{
		switch (is.getItemDamage())
		{
			case 0: return (short) TFCOptions.normalOreUnits;
			case 1: return (short) TFCOptions.richOreUnits;
			case 2: return (short) TFCOptions.poorOreUnits;
			default: return 0;
		}
	}

	@Override
	public boolean isSmeltable(ItemStack is)
	{
		switch (is.getItemDamage())
		{
			case 0: case 1: case 2: return true;
			default: return false;
		}
	}

	@Override
	public EnumTier getSmeltTier(ItemStack is)
	{
		switch (is.getItemDamage())
		{
			case 0: case 1: case 2: return EnumTier.TierI;
			default: return EnumTier.TierX;
		}
	}
}
