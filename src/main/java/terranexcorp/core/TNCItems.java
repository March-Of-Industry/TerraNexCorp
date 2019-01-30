package terranexcorp.core;

import com.bioxx.tfc.Items.ItemMetalSheet;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.common.util.EnumHelper;
import terranexcorp.core.TNCItems;
import terranexcorp.items.*;
import terranexcorp.items.tools.ItemNewSword;
import terranexcorp.items.tools.ItemNewHammer;
import terranexcorp.items.tools.ItemNewKnife;
import terranexcorp.core.TNCDetails;
import terranexcorp.core.TNCGlobals;
import terranexcorp.items.ItemTNCOre;
import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

import com.bioxx.tfc.CommonProxy;
import com.bioxx.tfc.TerraFirmaCraft;
import com.bioxx.tfc.api.Metal;
import com.bioxx.tfc.Core.Metal.Alloy;
import com.bioxx.tfc.Core.Metal.AlloyManager;
import com.bioxx.tfc.Core.Metal.MetalRegistry;

import com.bioxx.tfc.api.Enums.EnumDamageType;

public class TNCItems
{
    public static Item itemHandle_HSLA;


    public static Item itemSword_Bedrock;
    public static Item itemMace_Bedrock;
    public static Item itemKnife_Bedrock;
    public static Item itemHammer_Bedrock;

    public static Item ferroChromeIngot;
    public static Item ferroChromeUnshaped;
    public static Item ferroChromeSheet;

    public static Item stainlessSteelIngot;
    public static Item stainlessSteelUnshaped;
    public static Item stainlessSteelSheet;

    public static Item titaniumIngot;
    public static Item titaniumUnshaped;
    public static Item titaniumSheet;

    public static Item oreChunk;
    public static Item smallOreChunk;

    //Materials
    public static ToolMaterial BedrockToolMaterial;
    public static int BedrockUses = -1;
    public static float BedrockEff = 18;
    public static int DepleatableBedrockUses = 2000000000;





    public static void init()
    {
        ItemSetup();
        registerItems();
        registerMetal();
    }



	public static void ItemSetup()
	{
	    //Materials
		BedrockToolMaterial = EnumHelper.addToolMaterial("Bedrock", 3, BedrockUses, BedrockEff, 240, 22);
		//Components
		itemHandle_HSLA = new ItemNewSword(BedrockToolMaterial,1,EnumDamageType.PIERCING).setUnlocalizedName("Handle_HSLA").setMaxDamage(BedrockUses);

		//Tools
		itemSword_Bedrock = new ItemNewSword(BedrockToolMaterial,TNCConfig.bedSwordDamage,EnumDamageType.SLASHING).setUnlocalizedName("Sword_Bedrock").setMaxDamage(BedrockUses);
		itemMace_Bedrock = new ItemNewSword(BedrockToolMaterial,TNCConfig.bedMaceDamage,EnumDamageType.CRUSHING).setUnlocalizedName("Mace_Bedrock").setMaxDamage(BedrockUses);
		itemKnife_Bedrock = new ItemNewKnife(BedrockToolMaterial,TNCConfig.bedKnifeDamage).setUnlocalizedName("Knife_Bedrock").setMaxDamage(DepleatableBedrockUses);
		itemHammer_Bedrock = new ItemNewHammer(BedrockToolMaterial,TNCConfig.bedHammerDamage).setUnlocalizedName("Hammer_Bedrock").setMaxDamage(BedrockUses);

		//ingots
		ferroChromeIngot = new ItemTNCIngot("Ferrochrome",100).setUnlocalizedName("Ferrochrome_Ingot");
		ferroChromeUnshaped = new ItemTNCMeltedMetal().setUnlocalizedName("Ferrochrome_Unshaped");

        stainlessSteelIngot = new ItemTNCIngot("Stainless Steel",100).setUnlocalizedName("Stainless_Steel_Ingot");
        stainlessSteelUnshaped = new ItemTNCMeltedMetal().setUnlocalizedName("Stainless_Steel_Unshaped");

        titaniumIngot = new ItemTNCIngot("Titanium",100).setUnlocalizedName("Titanium_Ingot");
        titaniumUnshaped = new ItemTNCMeltedMetal().setUnlocalizedName("Titanium_Unshaped");
        //sheets
        ferroChromeSheet= new ItemTNCMetalSheet("Ferrochrome",0).setUnlocalizedName("Ferrochrome_Sheet");
        stainlessSteelSheet= new ItemTNCMetalSheet("Stainless Steel",1).setUnlocalizedName("Stainless_Steel_Sheet");
        titaniumSheet= new ItemTNCMetalSheet("Titanium",2).setUnlocalizedName("Titanium_Sheet");
		//ores
		oreChunk = new ItemTNCOre().setFolder("ores/").setUnlocalizedName("Ore");
		smallOreChunk = new ItemTNCOreSmall().setUnlocalizedName("Small_Ore");
	}

    public static void registerItems()
    {
        GameRegistry.registerItem(itemHandle_HSLA, itemHandle_HSLA.getUnlocalizedName());
        GameRegistry.registerItem(itemSword_Bedrock, itemSword_Bedrock.getUnlocalizedName());
        GameRegistry.registerItem(itemMace_Bedrock, itemMace_Bedrock.getUnlocalizedName());
        GameRegistry.registerItem(itemKnife_Bedrock, itemKnife_Bedrock.getUnlocalizedName());
        GameRegistry.registerItem(itemHammer_Bedrock, itemHammer_Bedrock.getUnlocalizedName());

        GameRegistry.registerItem(ferroChromeIngot,ferroChromeIngot.getUnlocalizedName());
        GameRegistry.registerItem(ferroChromeUnshaped,ferroChromeUnshaped.getUnlocalizedName());
        GameRegistry.registerItem(ferroChromeSheet,ferroChromeSheet.getUnlocalizedName());

        GameRegistry.registerItem(stainlessSteelIngot,stainlessSteelIngot.getUnlocalizedName());
        GameRegistry.registerItem(stainlessSteelUnshaped,stainlessSteelUnshaped.getUnlocalizedName());
        GameRegistry.registerItem(stainlessSteelSheet,stainlessSteelSheet.getUnlocalizedName());

        GameRegistry.registerItem(titaniumIngot,titaniumIngot.getUnlocalizedName());
        GameRegistry.registerItem(titaniumUnshaped,titaniumUnshaped.getUnlocalizedName());
        GameRegistry.registerItem(titaniumSheet,titaniumSheet.getUnlocalizedName());

        GameRegistry.registerItem(oreChunk, oreChunk.getUnlocalizedName());
        GameRegistry.registerItem(smallOreChunk, smallOreChunk.getUnlocalizedName());
    }

    public static void registerMetal()
    {
        TNCGlobals.FERROCHROME = new Metal("Ferrochrome", ferroChromeUnshaped, ferroChromeIngot);
        MetalRegistry.instance.addMetal(TNCGlobals.FERROCHROME, Alloy.EnumTier.TierI);
        TNCGlobals.STAINLESS_STEEL = new Metal("Stainless Steel", stainlessSteelUnshaped, stainlessSteelIngot);
        MetalRegistry.instance.addMetal(TNCGlobals.STAINLESS_STEEL, Alloy.EnumTier.TierII);
        TNCGlobals.TITANIUM = new Metal("Titanium", titaniumUnshaped, titaniumIngot);
        MetalRegistry.instance.addMetal(TNCGlobals.TITANIUM, Alloy.EnumTier.TierI);
    }
}
