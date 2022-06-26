package terranexcorp.items;

import com.bioxx.tfc.Items.ItemOre;
import com.bioxx.tfc.api.Constant.Global;
import com.bioxx.tfc.api.Metal;
import com.bioxx.tfc.api.TFCOptions;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import terranexcorp.core.TNCConfig;
import terranexcorp.core.TNCDetails;
import terranexcorp.core.TNCGlobals;
import terranexcorp.core.TNCTab;

public class ItemCrushedOre extends ItemOre
{
	public ItemCrushedOre()
	{
		super();
		setHasSubtypes(true);
		metaNames = new String[] {"Native_Copper", "Native_Gold", "Native_Platinum", "Hematite", "Native_Silver", "Cassiterite", "Galena", "Bismuthinite", "Garnierite", "Malachite", "Magnetite", "Limonite", "Sphalerite", "Tetrahedrite", "Pitchblende", "Cinnabar", "Lapis_Lazuli"
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
				case 9:
				case 13:
					return Global.COPPER;
				case 7:
					return Global.BISMUTH;
				case 1:
					return Global.GOLD;
				case 3:
				case 10:
				case 11:
					return Global.WROUGHTIRON;
				case 6:
					return Global.LEAD;
				case 8:
					return Global.NICKEL;
				case 2:
					return Global.PLATINUM;
				case 4:
					return Global.SILVER;
				case 5:
					return Global.TIN;
				case 12:
					return Global.ZINC;
				case 14://Pitchblend
				case 15://Cinnabar
				case 16://Lapis Lazuli
				default:
					return null;
			}
	}

	@Override
	public short getMetalReturnAmount(ItemStack is)
	{
		switch (is.getItemDamage())
		{
			case 14:
			case 15:
			case 16:
				return 0;
			default: return (short) TNCConfig.crushedOreUnits;
		}
	}

	@Override
	public boolean isSmeltable(ItemStack is)
	{
		return TNCConfig.enableSimpleRefinement;
		//if advanced stuff in future is needed
		/*
		if (TNCConfig.enableSimpleRefinement)
		{
			return true;
		}
		else
		{
			//put a switch case here if some metals should not be changed by config in the future
			return false;
		}*/
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
