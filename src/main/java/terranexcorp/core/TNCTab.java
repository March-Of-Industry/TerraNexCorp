package terranexcorp.core;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;





public class TNCTab {
    public static final CreativeTabs TNC_TAB = new CreativeTabs(TNCDetails.ModName)
    {
        @Override
        public Item getTabIconItem()
        {
            return TNCItems.smallOreChunk;
        }
    };
}