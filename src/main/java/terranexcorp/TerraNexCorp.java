package terranexcorp;

import java.io.File;

import net.minecraftforge.common.MinecraftForge;
import com.bioxx.tfc.TerraFirmaCraft;

import terranexcorp.core.TNCClientProxy;
import terranexcorp.core.TNCCommonProxy;
import terranexcorp.core.TNCDetails;
import terranexcorp.core.TNCItems;
import terranexcorp.core.TNCBlocks;
import terranexcorp.core.TNCConfig;
import terranexcorp.items.ItemHeat;
import terranexcorp.worldgen.WorldGenChromiteRocks;


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
		GameRegistry.registerWorldGenerator(new WorldGenChromiteRocks(), 5);
	}

	@EventHandler
	public void initialize(FMLInitializationEvent event)
	{
	}

	@EventHandler
	public void postInitialize(FMLPostInitializationEvent event)
	{
		TNCConfig.reloadOres();
	}
}
