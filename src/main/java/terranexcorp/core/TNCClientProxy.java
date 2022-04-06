package terranexcorp.core;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;

import cpw.mods.fml.common.FMLCommonHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.util.Util;
import net.minecraft.world.World;
import cpw.mods.fml.common.Loader;
import org.lwjgl.opengl.Display;
import terranexcorp.core.compat.NEICompat;
import terranexcorp.eventhandlers.RainOverride;

import javax.imageio.ImageIO;

public class TNCClientProxy extends TNCCommonProxy
{
	@Override
	public void preinit()
	{
		Display.setTitle(TNCConfig.windowText);
		setWindowIcon();
	}

	@Override
	public void init()
	{
		super.init();
		if(TNCConfig.enableRainFix)
		{
			FMLCommonHandler.instance().bus().register(new RainOverride(Minecraft.getMinecraft()));
		}
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
	public void hideNEIItems()
	{
		if (Loader.isModLoaded(TNCDetails.MODID_NEI)) {
			NEICompat.hideNEIItems();
		}
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

	public void setWindowIcon() {
		if (Util.getOSType() != Util.EnumOS.OSX) {
			try (InputStream inputStream16x = Minecraft.class.getResourceAsStream("/assets/tnc/icons/icon-16x.png");
				 InputStream inputStream32x = Minecraft.class.getResourceAsStream("/assets/tnc/icons/icon-32x.png")) {
				ByteBuffer[] icons = new ByteBuffer[]{readImageToBuffer(inputStream16x), readImageToBuffer(inputStream32x)};
				Display.setIcon(icons);
			} catch (Exception e) {
				System.out.println("Couldn't set Windows Icon" + e);
			}
		}
	}

	public ByteBuffer readImageToBuffer(InputStream inputStream) throws IOException
	{
		BufferedImage bufferedimage = ImageIO.read(inputStream);
		int[] aint = bufferedimage.getRGB(0, 0, bufferedimage.getWidth(), bufferedimage.getHeight(), null, 0, bufferedimage.getWidth());
		ByteBuffer bytebuffer = ByteBuffer.allocate(4 * aint.length);
		Arrays.stream(aint).map(i -> i << 8 | (i >> 24 & 255)).forEach(bytebuffer::putInt);
		bytebuffer.flip();
		return bytebuffer;
	}

}
