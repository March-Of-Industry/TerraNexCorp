package terranexcorp;

import java.io.File;
import java.util.Map;

import blusunrize.immersiveengineering.api.energy.DieselHandler;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import org.lwjgl.Sys;
import terranexcorp.core.TNCCommonProxy;
import terranexcorp.core.TNCDetails;
import terranexcorp.core.TNCItems;
import terranexcorp.core.TNCBlocks;
import terranexcorp.core.TNCConfig;
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
		proxy.hideNEIItems();

	}

	@EventHandler
	public void postInitialize(FMLPostInitializationEvent event)
	{
		TNCminetweaker.postInit();
		TNCConfig.reloadOres();
	}
}
