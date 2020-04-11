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
    public static Item ferroChromeDoubleIngot;
    public static Item ferroChromeUnshaped;
    public static Item ferroChromeSheet;

    public static Item stainlessSteelIngot;
    public static Item stainlessSteelDoubleIngot;
    public static Item stainlessSteelUnshaped;
    public static Item stainlessSteelSheet;

    public static Item titaniumIngot;
    public static Item titaniumDoubleIngot;
    public static Item titaniumUnshaped;
    public static Item titaniumSheet;

    public static Item ferroManganeseIngot;
    public static Item ferroManganeseDoubleIngot;
    public static Item ferroManganeseUnshaped;
    public static Item ferroManganeseSheet;

    public static Item manganeseIngot;
    public static Item manganeseDoubleIngot;
    public static Item manganeseUnshaped;
    public static Item manganeseSheet;


    public static Item oreChunk;
    public static Item crushedOreChunk;
    public static Item advancedCrushedOreChunk;
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
		ferroChromeDoubleIngot = new ItemTNCIngot("Ferrochrome",200).setUnlocalizedName("Ferrochrome_Double_Ingot");
		ferroChromeUnshaped = new ItemTNCMeltedMetal().setUnlocalizedName("Ferrochrome_Unshaped");

        stainlessSteelIngot = new ItemTNCIngot("Stainless_Steel",100).setUnlocalizedName("Stainless_Steel_Ingot");
        stainlessSteelDoubleIngot = new ItemTNCIngot("Stainless_Steel",200).setUnlocalizedName("Stainless_Steel_Double_Ingot");
        stainlessSteelUnshaped = new ItemTNCMeltedMetal().setUnlocalizedName("Stainless_Steel_Unshaped");

        titaniumIngot = new ItemTNCIngot("Titanium",100).setUnlocalizedName("Titanium_Ingot");
        titaniumDoubleIngot = new ItemTNCIngot("Titanium",200).setUnlocalizedName("Titanium_Double_Ingot");
        titaniumUnshaped = new ItemTNCMeltedMetal().setUnlocalizedName("Titanium_Unshaped");

        ferroManganeseIngot = new ItemTNCIngot("Ferromanganese",100).setUnlocalizedName("Ferromanganese_Ingot");
        ferroManganeseDoubleIngot = new ItemTNCIngot("Ferromanganese",200).setUnlocalizedName("Ferromanganese_Double_Ingot");
        ferroManganeseUnshaped = new ItemTNCMeltedMetal().setUnlocalizedName("Ferromanganese_Unshaped");

        manganeseIngot = new ItemTNCIngot("Manganese",100).setUnlocalizedName("Manganese_Ingot");
        manganeseDoubleIngot = new ItemTNCIngot("Manganese",200).setUnlocalizedName("Manganese_Double_Ingot");
        manganeseUnshaped = new ItemTNCMeltedMetal().setUnlocalizedName("Manganese_Unshaped");


        //sheets
        ferroChromeSheet= new ItemTNCMetalSheet("Ferrochrome",0).setUnlocalizedName("Ferrochrome_Sheet");
        stainlessSteelSheet= new ItemTNCMetalSheet("Stainless_Steel",1).setUnlocalizedName("Stainless_Steel_Sheet");
        titaniumSheet= new ItemTNCMetalSheet("Titanium",2).setUnlocalizedName("Titanium_Sheet");
        ferroManganeseSheet= new ItemTNCMetalSheet("Ferromanganese",3).setUnlocalizedName("Ferromanganese_Sheet");
        manganeseSheet= new ItemTNCMetalSheet("Manganese",4).setUnlocalizedName("Manganese_Sheet");
		//ores
		oreChunk = new ItemTNCOre().setFolder("ores/").setUnlocalizedName("Ore");
		smallOreChunk = new ItemTNCOreSmall().setUnlocalizedName("Small_Ore");
        crushedOreChunk = new ItemCrushedOre().setFolder("ores/crushed/").setUnlocalizedName("Crushed_Ore");
        advancedCrushedOreChunk = new ItemAdvancedCrushedOre().setFolder("ores/crushed/").setUnlocalizedName("Advanced_Crushed_Ore");
	}

    public static void registerItems()
    {
        GameRegistry.registerItem(itemHandle_HSLA, itemHandle_HSLA.getUnlocalizedName());
        GameRegistry.registerItem(itemSword_Bedrock, itemSword_Bedrock.getUnlocalizedName());
        GameRegistry.registerItem(itemMace_Bedrock, itemMace_Bedrock.getUnlocalizedName());
        GameRegistry.registerItem(itemKnife_Bedrock, itemKnife_Bedrock.getUnlocalizedName());
        GameRegistry.registerItem(itemHammer_Bedrock, itemHammer_Bedrock.getUnlocalizedName());

        GameRegistry.registerItem(ferroChromeIngot,ferroChromeIngot.getUnlocalizedName());
        GameRegistry.registerItem(ferroChromeDoubleIngot,ferroChromeDoubleIngot.getUnlocalizedName());
        GameRegistry.registerItem(ferroChromeUnshaped,ferroChromeUnshaped.getUnlocalizedName());
        GameRegistry.registerItem(ferroChromeSheet,ferroChromeSheet.getUnlocalizedName());

        GameRegistry.registerItem(stainlessSteelIngot,stainlessSteelIngot.getUnlocalizedName());
        GameRegistry.registerItem(stainlessSteelDoubleIngot,stainlessSteelDoubleIngot.getUnlocalizedName());
        GameRegistry.registerItem(stainlessSteelUnshaped,stainlessSteelUnshaped.getUnlocalizedName());
        GameRegistry.registerItem(stainlessSteelSheet,stainlessSteelSheet.getUnlocalizedName());

        GameRegistry.registerItem(titaniumIngot,titaniumIngot.getUnlocalizedName());
        GameRegistry.registerItem(titaniumDoubleIngot,titaniumDoubleIngot.getUnlocalizedName());
        GameRegistry.registerItem(titaniumUnshaped,titaniumUnshaped.getUnlocalizedName());
        GameRegistry.registerItem(titaniumSheet,titaniumSheet.getUnlocalizedName());

        GameRegistry.registerItem(ferroManganeseIngot,ferroManganeseIngot.getUnlocalizedName());
        GameRegistry.registerItem(ferroManganeseDoubleIngot,ferroManganeseDoubleIngot.getUnlocalizedName());
        GameRegistry.registerItem(ferroManganeseUnshaped,ferroManganeseUnshaped.getUnlocalizedName());
        GameRegistry.registerItem(ferroManganeseSheet,ferroManganeseSheet.getUnlocalizedName());

        GameRegistry.registerItem(manganeseIngot,manganeseIngot.getUnlocalizedName());
        GameRegistry.registerItem(manganeseDoubleIngot,manganeseDoubleIngot.getUnlocalizedName());
        GameRegistry.registerItem(manganeseUnshaped,manganeseUnshaped.getUnlocalizedName());
        GameRegistry.registerItem(manganeseSheet,manganeseSheet.getUnlocalizedName());



        GameRegistry.registerItem(oreChunk, oreChunk.getUnlocalizedName());
        GameRegistry.registerItem(smallOreChunk, smallOreChunk.getUnlocalizedName());
        GameRegistry.registerItem(crushedOreChunk, crushedOreChunk.getUnlocalizedName());
        GameRegistry.registerItem(advancedCrushedOreChunk, advancedCrushedOreChunk.getUnlocalizedName());
    }

    public static void registerMetal()
    {
        TNCGlobals.FERROCHROME = new Metal("Ferrochrome", ferroChromeUnshaped, ferroChromeIngot);
        MetalRegistry.instance.addMetal(TNCGlobals.FERROCHROME, Alloy.EnumTier.TierI);
        TNCGlobals.STAINLESS_STEEL = new Metal("Stainless_Steel", stainlessSteelUnshaped, stainlessSteelIngot);
        MetalRegistry.instance.addMetal(TNCGlobals.STAINLESS_STEEL, Alloy.EnumTier.TierII);
        TNCGlobals.TITANIUM = new Metal("Titanium", titaniumUnshaped, titaniumIngot);
        MetalRegistry.instance.addMetal(TNCGlobals.TITANIUM, Alloy.EnumTier.TierI);
        TNCGlobals.FERROMANGANESE = new Metal("Ferromanganese", ferroManganeseUnshaped, ferroManganeseIngot);
        MetalRegistry.instance.addMetal(TNCGlobals.FERROMANGANESE, Alloy.EnumTier.TierI);
        TNCGlobals.MANGANESE = new Metal("Manganese", manganeseUnshaped, manganeseIngot);
        MetalRegistry.instance.addMetal(TNCGlobals.MANGANESE, Alloy.EnumTier.TierI);
    }
}
