package terranexcorp.items;

import net.minecraft.item.ItemStack;
import terranexcorp.core.TNCItems;

import com.bioxx.tfc.api.HeatIndex;
import com.bioxx.tfc.api.HeatRaw;
import com.bioxx.tfc.api.HeatRegistry;
import com.bioxx.tfc.api.TFCItems;

public class ItemHeat {

    public static void setupItemHeat()
    {

        HeatRegistry manager = HeatRegistry.getInstance();

        HeatRaw ferroChromeProcessingRaw = new HeatRaw(0.50, 2800);
        HeatRaw ferroChromeRaw = new HeatRaw(0.50, 1600);

        //Chrome
        manager.addIndex(new HeatIndex(new ItemStack(TNCItems.ferroChromeIngot, 1), ferroChromeRaw, new ItemStack(TNCItems.ferroChromeUnshaped, 1)));
        manager.addIndex(new HeatIndex(new ItemStack(TNCItems.ferroChromeUnshaped, 1), ferroChromeRaw, new ItemStack(TNCItems.ferroChromeUnshaped, 1)));
        manager.addIndex(new HeatIndex(new ItemStack(TNCItems.oreChunk, 1, 0), ferroChromeProcessingRaw, new ItemStack(TNCItems.ferroChromeUnshaped, 1)));
        manager.addIndex(new HeatIndex(new ItemStack(TNCItems.oreChunk, 1, 1), ferroChromeProcessingRaw, new ItemStack(TNCItems.ferroChromeUnshaped, 1)));
        manager.addIndex(new HeatIndex(new ItemStack(TNCItems.oreChunk, 1, 2), ferroChromeProcessingRaw, new ItemStack(TNCItems.ferroChromeUnshaped, 1)));
        manager.addIndex(new HeatIndex(new ItemStack(TNCItems.smallOreChunk, 1, 0), ferroChromeProcessingRaw, new ItemStack(TNCItems.ferroChromeUnshaped, 1)));
    }

}