package terranexcorp.core;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

public class TNCItems
{
	public static Item itemHandle_HSLA;


	public static Item itemSword_Bedrock;
	//public static Item itemSword_Bedrock_Head;


	public static Item itemMace_Bedrock;
	//public static Item itemMace_Bedrock_Head;

    public static Item itemKnife_Bedrock;
    public static Item itemHammer_Bedrock;

	public static Item ferroChromeIngot;
	public static Item ferroChromeUnshaped;

	public static Item oreChunk;
	public static Item smallOreChunk;


	public static void registerItems()
	{
        GameRegistry.registerItem(itemHandle_HSLA, itemHandle_HSLA.getUnlocalizedName());

		GameRegistry.registerItem(itemSword_Bedrock, itemSword_Bedrock.getUnlocalizedName());
		//GameRegistry.registerItem(itemSword_Bedrock_Head, itemSword_Bedrock_Head.getUnlocalizedName());
		GameRegistry.registerItem(itemMace_Bedrock, itemMace_Bedrock.getUnlocalizedName());
		//GameRegistry.registerItem(itemMace_Bedrock_Head, itemMace_Bedrock_Head.getUnlocalizedName());
        GameRegistry.registerItem(itemKnife_Bedrock, itemKnife_Bedrock.getUnlocalizedName());
        GameRegistry.registerItem(itemHammer_Bedrock, itemHammer_Bedrock.getUnlocalizedName());
		GameRegistry.registerItem(oreChunk, oreChunk.getUnlocalizedName());
		GameRegistry.registerItem(smallOreChunk, smallOreChunk.getUnlocalizedName());
	}
}
