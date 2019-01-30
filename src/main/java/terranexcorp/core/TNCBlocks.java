package terranexcorp.core;

import terranexcorp.blocks.BlockTNCOre;
import terranexcorp.blocks.BlockTNCMetalSheet;
import terranexcorp.items.ItemBlocks.ItemModOreBlock;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class TNCBlocks
{

	public static Block blockOre;
	public static Block metalSheetTNC;


	public static void init()
	{
		setupBlocks();
		registerBlocks();
	}

	public static void setupBlocks()
	{
		blockOre = new BlockTNCOre(Material.rock){}.setHardness(10F).setResistance(10F).setBlockName("Ore");
		metalSheetTNC = new BlockTNCMetalSheet().setBlockName("Metal_Sheet");
	}


	public static void registerBlocks()
	{
		GameRegistry.registerBlock(blockOre,ItemModOreBlock.class ,"Ore");
		GameRegistry.registerBlock(metalSheetTNC, "metalSheet");
	}
}
