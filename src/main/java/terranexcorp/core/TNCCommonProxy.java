package terranexcorp.core;

import java.io.File;

import net.minecraftforge.common.MinecraftForge;
import terranexcorp.core.TNCDetails;


import cpw.mods.fml.common.FMLCommonHandler;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.World;
import net.minecraftforge.common.config.Configuration;


public class TNCCommonProxy
{
	public void preinit(){}

	public void init(){}

    private static Configuration oresConfig;

	public String getCurrentLanguage()
	{
		return null;
	}

	public World getCurrentWorld()
	{
		return MinecraftServer.getServer().getEntityWorld();
	}

	public void hideNEIItems() {}

	public boolean getGraphicsLevel()
	{
		return false;
	}
	
	public File getMinecraftDirectory()
	{
		return FMLCommonHandler.instance().getMinecraftServerInstance().getFile("");
	}

	public boolean isRemote()
	{
		return false;
	}



}
