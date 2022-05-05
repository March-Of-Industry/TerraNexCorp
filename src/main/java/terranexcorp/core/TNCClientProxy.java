package terranexcorp.core;

import java.io.File;


import cpw.mods.fml.common.FMLCommonHandler;
import net.minecraft.client.Minecraft;

import net.minecraft.world.World;

import terranexcorp.eventhandlers.RainOverride;


public class TNCClientProxy extends TNCCommonProxy
{

	@Override
	public void init()
	{
		super.init();
			FMLCommonHandler.instance().bus().register(new RainOverride(Minecraft.getMinecraft()));
	}

	@Override
	public String getCurrentLanguage()
	{
		return Minecraft.getMinecraft().getLanguageManager().getCurrentLanguage().getLanguageCode();
	}

	@Override
	public World getCurrentWorld()
	{
		return Minecraft.getMinecraft().theWorld;
	}



	@Override
	public boolean getGraphicsLevel()
	{
		return Minecraft.isFancyGraphicsEnabled();
	}

	@Override
	public File getMinecraftDirectory()
	{
		return Minecraft.getMinecraft().mcDataDir;
	}
	

	@Override
	public boolean isRemote()
	{
		return true;
	}

}
