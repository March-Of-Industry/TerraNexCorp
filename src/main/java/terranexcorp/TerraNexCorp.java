package terranexcorp;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;

import cpw.mods.fml.common.Loader;
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
		Display.setTitle(TNCConfig.windowText);
		setWindowIcon();
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
