package terranexcorp.core.compat;

import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import terranexcorp.core.TNCItems;

public class TNCOreDict
{
    public static void addOreDict()
    {
        OreDictionary.registerOre("itemKnife",new ItemStack(TNCItems.itemKnife_Bedrock,1,32767));
        OreDictionary.registerOre("itemHammer",new ItemStack(TNCItems.itemHammer_Bedrock,1,32767));
        OreDictionary.registerOre("itemSword",new ItemStack(TNCItems.itemSword_Bedrock,1,32767));
        OreDictionary.registerOre("itemMace",new ItemStack(TNCItems.itemMace_Bedrock,1,32767));
        OreDictionary.registerOre("plateStainlessSteel",new ItemStack(TNCItems.stainlessSteelSheet,1,32767));
        OreDictionary.registerOre("plateFerrochrome",new ItemStack(TNCItems.ferroChromeSheet,1,32767));
        OreDictionary.registerOre("plateTitanium",new ItemStack(TNCItems.titaniumSheet,1,32767));
        OreDictionary.registerOre("plateFerromanganese",new ItemStack(TNCItems.ferroManganeseSheet,1,32767));
        OreDictionary.registerOre("plateManganese",new ItemStack(TNCItems.manganeseSheet,1,32767));
        OreDictionary.registerOre("ingotStainlessSteel",new ItemStack(TNCItems.stainlessSteelIngot,1,32767));
        OreDictionary.registerOre("ingotFerrochrome",new ItemStack(TNCItems.ferroChromeIngot,1,32767));
        OreDictionary.registerOre("ingotTitanium",new ItemStack(TNCItems.titaniumIngot,1,32767));
        OreDictionary.registerOre("ingotFerromanganese",new ItemStack(TNCItems.ferroManganeseIngot,1,32767));
        OreDictionary.registerOre("ingotManganese",new ItemStack(TNCItems.manganeseIngot,1,32767));
        OreDictionary.registerOre("ingotDoubleStainlessSteel",new ItemStack(TNCItems.stainlessSteelDoubleIngot,1,32767));
        OreDictionary.registerOre("ingotDoubleFerrochrome",new ItemStack(TNCItems.ferroChromeDoubleIngot,1,32767));
        OreDictionary.registerOre("ingotDoubleTitanium",new ItemStack(TNCItems.titaniumDoubleIngot,1,32767));
        OreDictionary.registerOre("ingotDoubleFerromanganese",new ItemStack(TNCItems.ferroManganeseDoubleIngot,1,32767));
        OreDictionary.registerOre("ingotDoubleManganese",new ItemStack(TNCItems.manganeseDoubleIngot,1,32767));
    }
}
