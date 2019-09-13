package terranexcorp.minetweaker;

import terranexcorp.minetweaker.IE.IEFuels;


import cpw.mods.fml.common.Loader;
import minetweaker.MineTweakerAPI;


public class TNCminetweaker
{
    public static void postInit()
    {
        if (Loader.isModLoaded("MineTweaker3"))
        {
            if(Loader.isModLoaded("ImmersiveEngineering"))
            {
                MineTweakerAPI.registerClass(IEFuels.class);
            }
        }
    }

}
