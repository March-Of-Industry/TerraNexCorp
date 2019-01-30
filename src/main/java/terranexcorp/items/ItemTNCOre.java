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
		setHasSubtypes(true);
		metaNames = new String[] {"Chromite","Ilmenite","Rutile",

								   "Rich_Chromite","Rich_Ilmenite","Rich_Rutile",

								   "Poor_Chromite","Poor_Ilmenite", "Poor_Rutile"

								   };
		setCreativeTab(TNCTab.TNC_TAB);
	}

	@Override
	public void registerIcons(IIconRegister registerer)
	{
		metaIcons = new IIcon[metaNames.length];
		for(int i = 0; i < metaNames.length; i++)
			metaIcons[i] = registerer.registerIcon(TNCDetails.ModID + ":ores/"  + metaNames[i] + "_Ore");
	}

	@Override
	public Metal getMetalType(ItemStack is)
	{
		switch(is.getItemDamage())
		{
			case 0: return TNCGlobals.FERROCHROME;
			case 1:	return TNCGlobals.TITANIUM;
			case 2: return TNCGlobals.TITANIUM;
			case 3: return TNCGlobals.FERROCHROME;
			case 4: return TNCGlobals.TITANIUM;
			case 5: return TNCGlobals.TITANIUM;
			case 6: return TNCGlobals.FERROCHROME;
			case 7: return TNCGlobals.TITANIUM;
			case 8: return TNCGlobals.TITANIUM;
			default: return null;
		}
	}

	@Override
	public short getMetalReturnAmount(ItemStack is)
	{
		switch (is.getItemDamage())
		{
			case 0:
			case 1:
			case 2: return (short) TFCOptions.normalOreUnits;
			case 3:
			case 4:
			case 5: return (short) TFCOptions.richOreUnits;
			case 6:
			case 7:
			case 8: return (short) TFCOptions.poorOreUnits;
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
			case 4: return EnumTier.TierIV;
			case 5: return EnumTier.TierIV;
			case 6: return EnumTier.TierIV;
			case 7: return EnumTier.TierIV;
			case 8: return EnumTier.TierIV;
			default: return EnumTier.TierX;
		}
	}
}
