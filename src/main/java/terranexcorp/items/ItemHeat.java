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

        HeatRaw stainlessSteelRaw = new HeatRaw(0.5,1420);

        HeatRaw titaniumRaw = new HeatRaw(0.65,1668);
        //Chrome
        manager.addIndex(new HeatIndex(new ItemStack(TNCItems.ferroChromeIngot, 1), ferroChromeRaw, new ItemStack(TNCItems.ferroChromeUnshaped, 1)));
        manager.addIndex(new HeatIndex(new ItemStack(TNCItems.ferroChromeUnshaped, 1), ferroChromeRaw, new ItemStack(TNCItems.ferroChromeUnshaped, 1)));
        manager.addIndex(new HeatIndex(new ItemStack(TNCItems.ferroChromeSheet, 1), ferroChromeRaw, new ItemStack(TNCItems.ferroChromeUnshaped, 2)));
        manager.addIndex(new HeatIndex(new ItemStack(TNCItems.oreChunk, 1, 0), ferroChromeProcessingRaw, new ItemStack(TNCItems.ferroChromeUnshaped, 1)));
        manager.addIndex(new HeatIndex(new ItemStack(TNCItems.oreChunk, 1, 3), ferroChromeProcessingRaw, new ItemStack(TNCItems.ferroChromeUnshaped, 1)));
        manager.addIndex(new HeatIndex(new ItemStack(TNCItems.oreChunk, 1, 6), ferroChromeProcessingRaw, new ItemStack(TNCItems.ferroChromeUnshaped, 1)));
        manager.addIndex(new HeatIndex(new ItemStack(TNCItems.smallOreChunk, 1, 0), ferroChromeProcessingRaw, new ItemStack(TNCItems.ferroChromeUnshaped, 1)));
        //stainless steel
        manager.addIndex(new HeatIndex(new ItemStack(TNCItems.stainlessSteelIngot, 1, 0), stainlessSteelRaw, new ItemStack(TNCItems.stainlessSteelUnshaped, 1)));
        manager.addIndex(new HeatIndex(new ItemStack(TNCItems.stainlessSteelUnshaped, 1, 0), stainlessSteelRaw, new ItemStack(TNCItems.stainlessSteelUnshaped, 1)));
        manager.addIndex(new HeatIndex(new ItemStack(TNCItems.stainlessSteelSheet, 1, 0), stainlessSteelRaw, new ItemStack(TNCItems.stainlessSteelUnshaped, 2)));

        //titanium
        manager.addIndex(new HeatIndex(new ItemStack(TNCItems.titaniumIngot, 1), titaniumRaw, new ItemStack(TNCItems.titaniumUnshaped, 1)));
        manager.addIndex(new HeatIndex(new ItemStack(TNCItems.titaniumUnshaped, 1), titaniumRaw, new ItemStack(TNCItems.titaniumUnshaped, 1)));
        manager.addIndex(new HeatIndex(new ItemStack(TNCItems.titaniumSheet, 1), titaniumRaw, new ItemStack(TNCItems.titaniumUnshaped, 2)));
    }

}