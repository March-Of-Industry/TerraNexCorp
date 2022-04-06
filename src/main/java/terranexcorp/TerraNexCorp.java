package terranexcorp;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.relauncher.Side;
import net.minecraft.client.Minecraft;
import net.minecraft.util.Util;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import org.lwjgl.opengl.Display;
import terranexcorp.core.TNCCommonProxy;
import terranexcorp.core.TNCDetails;
import terranexcorp.core.TNCItems;
import terranexcorp.core.TNCBlocks;
import terranexcorp.core.TNCConfig;
import terranexcorp.core.compat.TNCOreDict;
import terranexcorp.eventhandlers.RainOverride;
import terranexcorp.items.ItemHeat;
import terranexcorp.minetweaker.TNCminetweaker;
import terranexcorp.worldgen.WorldGenSampleRocks;


import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

import javax.imageio.ImageIO;

@Mod(modid = TNCDetails.ModID, name = TNCDetails.ModName, version = TNCDetails.ModVersion, dependencies = TNCDetails.ModDependencies)
public class TerraNexCorp
{
	@Instance(TNCDetails.ModID)
	public static TerraNexCorp instance;

	@SidedProxy(clientSide = TNCDetails.CLIENT_PROXY_CLASS, serverSide = TNCDetails.SERVER_PROXY_CLASS)
	public static TNCCommonProxy proxy;
	
	public File getMinecraftDirectory()
	{
		return proxy.getMinecraftDirectory();
	}

	@EventHandler
	public void preInitialize(FMLPreInitializationEvent event)
	{
		instance = this;
		TNCConfig.init(event.getSuggestedConfigurationFile());
		proxy.preinit();
		FMLCommonHandler.instance().bus().register(new TNCConfig());
		TNCItems.init();
		TNCBlocks.init();
		ItemHeat.setupItemHeat();
		GameRegistry.registerWorldGenerator(new WorldGenSampleRocks(), 5);
		Fluid fluidWater = FluidRegistry.getFluid("water");
	}

	@EventHandler
	public void initialize(FMLInitializationEvent event)
	{
		proxy.init();
		proxy.hideNEIItems();
		TNCOreDict.addOreDict();
		if (Loader.isModLoaded(TNCDetails.MODID_TFCTECH)) {
			TNCOreDict.tfcTechOre();
		}
		if (Loader.isModLoaded(TNCDetails.MODID_CUSTOM)){
			TNCOreDict.customItemsFrogs();
		}
	}

	@EventHandler
	public void postInitialize(FMLPostInitializationEvent event)
	{
		TNCminetweaker.postInit();
		TNCConfig.reloadOres();
	}



}
