package terranexcorp.core;

import com.bioxx.tfc.api.Constant.Global;
import com.google.common.collect.ObjectArrays;

import terranexcorp.blocks.BlockChromite;
import terranexcorp.items.ItemBlocks.ItemModOreBlock;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class TNCBlocks
{

	public static Block blockChromite;

	public static void init()
	{
		setupBlocks();
		registerBlocks();
	}




	public static void setupBlocks()
	{
		blockChromite = new BlockChromite(Material.rock).setHardness(10F).setResistance(10F).setBlockName("Chromite Ore");

	}


	public static void registerBlocks()
	{
		GameRegistry.registerBlock(blockChromite, ItemModOreBlock.class, "OreChromite");
	}
}
