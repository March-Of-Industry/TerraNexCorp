package terranexcorp.core;



import terranexcorp.blocks.BlockChromite;
import terranexcorp.blocks.BlockTNCMetalSheet;
import terranexcorp.items.ItemBlocks.ItemModOreBlock;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class TNCBlocks
{

	public static Block blockChromite;
	public static Block metalSheetTNC;


	public static void init()
	{
		setupBlocks();
		registerBlocks();
	}




	public static void setupBlocks()
	{
		blockChromite = new BlockChromite(Material.rock).setHardness(10F).setResistance(10F).setBlockName("Chromite Ore");
		metalSheetTNC = new BlockTNCMetalSheet().setBlockName("Metal Sheet");
	}


	public static void registerBlocks()
	{
		GameRegistry.registerBlock(blockChromite, ItemModOreBlock.class, "OreChromite");
		GameRegistry.registerBlock(metalSheetTNC, "metalSheet");
	}
}
