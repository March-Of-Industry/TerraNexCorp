package terranexcorp.worldgen;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import terranexcorp.blocks.BlockTNCOre;

import com.bioxx.tfc.TileEntities.TEWorldItem;
import com.bioxx.tfc.WorldGen.TFCBiome;
import com.bioxx.tfc.api.TFCBlocks;

import cpw.mods.fml.common.IWorldGenerator;
import terranexcorp.core.TNCBlocks;

public class WorldGenSampleRocks implements IWorldGenerator {

    public WorldGenSampleRocks() {
    }

    private boolean generateRocks(World world, Random random, int i, int j, int k) {
        if ((world.isAirBlock(i, j + 1, k) || world.getBlock(i, j + 1, k) == Blocks.snow || world.getBlock(i, j + 1, k) == TFCBlocks.tallGrass)
                && (world.getBlock(i, j, k).getMaterial() == Material.grass || world.getBlock(i, j, k).getMaterial() == Material.rock)
                && world.getBlock(i, j, k).isOpaqueCube()) {
            if (world.rand.nextInt(3) == 0) {
                ItemStack is = getCoreSample(world, i, j, k);
                if (is != null) {
                    if (world.setBlock(i, j + 1, k, TFCBlocks.worldItem, 0, 2)) {
                        TEWorldItem te = (TEWorldItem) world.getTileEntity(i, j + 1, k);
                        te.storage[0] = is;
                    }
                }
            }
        }
        return true;
    }

    private ItemStack getCoreSample(World world, int xCoord, int yCoord, int zCoord) {
        ArrayList<Item> coreSample = new ArrayList<Item>();
        ArrayList<ItemStack> coreSampleStacks = new ArrayList<ItemStack>();
        for (int x = -15; x < 16; x++) {
            for (int z = -15; z < 16; z++) {
                for (int y = yCoord; y > yCoord - 35; y--) {
                    if (world.blockExists(xCoord + x, y, zCoord + z) && world.getBlock(xCoord + x, y, zCoord + z) == TNCBlocks.blockOre) {
                        int m = world.getBlockMetadata(xCoord + x, y, zCoord + z);
                        if (!coreSample.contains(BlockTNCOre.getDroppedItemMod(m))) {
                            coreSample.add(BlockTNCOre.getDroppedItemMod(m));
                            coreSampleStacks.add(new ItemStack(BlockTNCOre.getDroppedItemMod(m), 1, m));
                        }
                    }
                }
            }
        }
        if (!coreSampleStacks.isEmpty())
            return coreSampleStacks.get(world.rand.nextInt(coreSampleStacks.size()));
        return null;
    }

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
        chunkX *= 16;
        chunkZ *= 16;

        if (world.getBiomeGenForCoords(chunkX, chunkZ) instanceof TFCBiome) // Fixes ClassCastException
        {
            TFCBiome biome = (TFCBiome) world.getBiomeGenForCoords(chunkX, chunkZ);
            if (biome == TFCBiome.OCEAN || biome == TFCBiome.DEEP_OCEAN)
                return;
        }

        // ore
        for (int var2 = 0; var2 < 8; var2++) {
            int var7 = chunkX + random.nextInt(16) + 8;
            int var3 = chunkZ + random.nextInt(16) + 8;
            generateRocks(world, random, var7, world.getTopSolidOrLiquidBlock(var7, var3) - 1, var3);
        }
    }

}