package terranexcorp.items;

import com.bioxx.tfc.Items.ItemOre;
import com.bioxx.tfc.api.Metal;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import terranexcorp.core.TNCConfig;
import terranexcorp.core.TNCDetails;
import terranexcorp.core.TNCGlobals;
import terranexcorp.core.TNCTab;

public class ItemAdvancedCrushedOre extends ItemOre
{
	public ItemAdvancedCrushedOre()
	{
		super();
		setHasSubtypes(true);
		metaNames = new String[] {"Chromite","Ilmenite","Rutile","Pyrolusite","Bauxite"
								   };
		setCreativeTab(TNCTab.TNC_TAB);
	}

	@Override
	public void registerIcons(IIconRegister registerer)
	{
		metaIcons = new IIcon[metaNames.length];
		for(int i = 0; i < metaNames.length; i++)
			metaIcons[i] = registerer.registerIcon(TNCDetails.ModID + ":ores/crushed/"  + metaNames[i] + "_Crushed_Ore");
	}

	@Override
	public Metal getMetalType(ItemStack is)
	{
			switch (is.getItemDamage())
			{
				case 0:
					return TNCGlobals.FERROCHROME;
				case 1:
					return TNCGlobals.TITANIUM;
				case 2:
					return TNCGlobals.TITANIUM;
				case 3:
					return TNCGlobals.FERROMANGANESE;
				default:
					return null;
			}
	}

	@Override
	public short getMetalReturnAmount(ItemStack is)
	{
		switch (is.getItemDamage())
		{
			case 0:
			case 1:
			case 2:
			case 3: return (short) TNCConfig.crushedOreUnits;
			default: return 0;
		}
	}

	@Override
	public boolean isSmeltable(ItemStack is)
	{
		return true;
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
