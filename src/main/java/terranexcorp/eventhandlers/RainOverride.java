package terranexcorp.eventhandlers;

import java.util.Random;

import akka.actor.FSM;
import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.particle.EntityRainFX;
import net.minecraft.client.particle.EntitySmokeFX;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MathHelper;


import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;

import com.bioxx.tfc.Core.WeatherManager;


@SideOnly(Side.CLIENT)
public class RainOverride
{
    private Random randRain;
    private int rainUpdateCount;
    private Minecraft minecraft;

    public RainOverride(Minecraft mc)
    {
        this.minecraft= mc;
        rainUpdateCount = 0;
        randRain = new Random();
    }

    @SubscribeEvent
    public void onTick(TickEvent.RenderTickEvent event)
    {
        if(minecraft.theWorld != null && minecraft.theWorld.isRaining())
        {
            doRainClient(randRain,rainUpdateCount++,minecraft.thePlayer);
        }
    }

    private static int rainSoundCounter;

    public static void doRainClient(Random random, int rendererUpdateCount, EntityLivingBase player)
    {
        float f = Minecraft.getMinecraft().theWorld.getRainStrength(1.0F);

        if (!Minecraft.getMinecraft().gameSettings.fancyGraphics)
        {
            f /= 2.0F;
        }

        if (f != 0.0F)
        {
            random.setSeed(rendererUpdateCount * 312987231L);
            WorldClient worldclient = Minecraft.getMinecraft().theWorld;
            int i = MathHelper.floor_double(player.posX);
            int j = MathHelper.floor_double(player.posY);
            int k = MathHelper.floor_double(player.posZ);
            byte b0 = 10;
            double d0 = 0.0D;
            double d1 = 0.0D;
            double d2 = 0.0D;
            int l = 0;
            int i1 = (int)(100.0F * f * f);

            if (Minecraft.getMinecraft().gameSettings.particleSetting == 1)
            {
                i1 >>= 1;
            }
            else if (Minecraft.getMinecraft().gameSettings.particleSetting == 2)
            {
                i1 = 0;
            }

            for (int j1 = 0; j1 < i1; ++j1)
            {
                int x = i + random.nextInt(b0) - random.nextInt(b0);
                int z = k + random.nextInt(b0) - random.nextInt(b0);
                int y = worldclient.getPrecipitationHeight(x, z);
                Block b = worldclient.getBlock(x, y - 1, z);
                if(!WeatherManager.canSnow(Minecraft.getMinecraft().theWorld, x, y, z))
                {
                    if (y <= j + b0 && y >= j - b0)
                    {
                        float f1 = random.nextFloat();
                        float f2 = random.nextFloat();

                        if (!b.isAir(worldclient, x, y - 1, z))
                        {
                            if (b.getMaterial() == Material.lava)
                            {
                                Minecraft.getMinecraft().effectRenderer.addEffect(new EntitySmokeFX(worldclient, x + f1, y + 0.1F - b.getBlockBoundsMinY(), z + f2, 0.0D, 0.0D, 0.0D));
                            }
                            else
                            {
                                ++l;

                                if (random.nextInt(l) == 0)
                                {
                                    d0 = x + f1;
                                    d1 = y + 0.1F - b.getBlockBoundsMinY();
                                    d2 = z + f2;
                                }

                                Minecraft.getMinecraft().effectRenderer.addEffect(new EntityRainFX(worldclient, x + f1, y + 0.1F - b.getBlockBoundsMinY(), z + f2));
                            }
                        }
                    }
                }
            }

            if (l > 0 && random.nextInt(3) < rainSoundCounter++)
            {
                rainSoundCounter = 0;

                if (d1 > player.posY + 1.0D && worldclient.getPrecipitationHeight(MathHelper.floor_double(player.posX), MathHelper.floor_double(player.posZ)) > MathHelper.floor_double(player.posY))
                {
                    Minecraft.getMinecraft().theWorld.playSound(d0, d1, d2, "ambient.weather.rain", 0.1F, 0.5F, false);
                }
                else
                {
                    Minecraft.getMinecraft().theWorld.playSound(d0, d1, d2, "ambient.weather.rain", 0.2F, 1.0F, false);
                }
            }
        }
    }

}
