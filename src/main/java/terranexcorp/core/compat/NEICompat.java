package terranexcorp.core.compat;

import codechicken.nei.api.API;
import net.minecraft.item.ItemStack;
import terranexcorp.core.TNCBlocks;
import terranexcorp.core.TNCConfig;

public class NEICompat
{
    public static void hideNEIItems()
    {
        if (TNCConfig.enableNEIHiding)
        {
            API.hideItem(new ItemStack(TNCBlocks.blockOre));
            API.hideItem(new ItemStack(TNCBlocks.metalSheetTNC));
        }
    }
}
