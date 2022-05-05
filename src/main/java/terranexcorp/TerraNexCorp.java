package terranexcorp;

import java.io.File;


import terranexcorp.core.TNCCommonProxy;
import terranexcorp.core.TNCDetails;


import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

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
		proxy.preinit();
	}

	@EventHandler
	public void initialize(FMLInitializationEvent event)
	{
		proxy.init();
	}

	@EventHandler
	public void postInitialize(FMLPostInitializationEvent event)
	{
	}



}
