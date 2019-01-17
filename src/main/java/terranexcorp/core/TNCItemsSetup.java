package terranexcorp.core;

import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.common.util.EnumHelper;
import terranexcorp.core.TNCItems;
import terranexcorp.items.tools.ItemCustomToolHead;
import terranexcorp.items.tools.ItemNewSword;
import terranexcorp.items.tools.ItemNewHammer;
import terranexcorp.items.tools.ItemNewKnife;
import terranexcorp.items.ItemTNCOre;
import terranexcorp.core.TNCDetails;
import terranexcorp.core.TNCGlobals;
import terranexcorp.items.ItemTNCOre;
import terranexcorp.items.ItemTNCOreSmall;
import net.minecraft.creativetab.CreativeTabs;


import com.bioxx.tfc.CommonProxy;
import com.bioxx.tfc.TerraFirmaCraft;
import com.bioxx.tfc.api.Metal;

import com.bioxx.tfc.api.Enums.EnumDamageType;

public class TNCItemsSetup extends TNCItems
{
	public static void ItemSetup()
	{
		//Materials
		ToolMaterial BedrockToolMaterial;
		TNCGlobals.FERROCHROME = new Metal("Ferrochrome", ferroChromeUnshaped, ferroChromeIngot);
		int BedrockUses = -1;
		float BedrockEff = 18;
		int DepleatableBedrockUses = 2000000000;


		BedrockToolMaterial = EnumHelper.addToolMaterial("Bedrock", 3, BedrockUses, BedrockEff, 240, 22);

		itemHandle_HSLA = new ItemNewSword(BedrockToolMaterial,1,EnumDamageType.PIERCING).setUnlocalizedName("Handle_HSLA").setMaxDamage(BedrockUses).setCreativeTab(CreativeTabs.tabCombat);

		itemSword_Bedrock = new ItemNewSword(BedrockToolMaterial,TNCConfig.bedSwordDamage,EnumDamageType.SLASHING).setUnlocalizedName("Sword_Bedrock").setMaxDamage(BedrockUses).setCreativeTab(CreativeTabs.tabCombat);


		itemMace_Bedrock = new ItemNewSword(BedrockToolMaterial,TNCConfig.bedMaceDamage,EnumDamageType.CRUSHING).setUnlocalizedName("Mace_Bedrock").setMaxDamage(BedrockUses).setCreativeTab(CreativeTabs.tabCombat);

		itemKnife_Bedrock = new ItemNewKnife(BedrockToolMaterial,TNCConfig.bedKnifeDamage).setUnlocalizedName("Knife_Bedrock").setMaxDamage(DepleatableBedrockUses).setCreativeTab(CreativeTabs.tabCombat);
		itemHammer_Bedrock = new ItemNewHammer(BedrockToolMaterial,TNCConfig.bedHammerDamage).setUnlocalizedName("Hammer_Bedrock").setMaxDamage(BedrockUses).setCreativeTab(CreativeTabs.tabCombat);

		oreChunk = new ItemTNCOre().setFolder("ores/").setUnlocalizedName("Ore");
		smallOreChunk = new ItemTNCOreSmall().setUnlocalizedName("Small Ore");


		registerItems();
	}
}
