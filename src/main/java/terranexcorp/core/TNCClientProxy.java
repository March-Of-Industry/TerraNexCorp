package terranexcorp.core;

import java.io.File;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import net.minecraftforge.client.MinecraftForgeClient;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TNCClientProxy extends TNCCommonProxy
{





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
		Minecraft.getMinecraft();
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
