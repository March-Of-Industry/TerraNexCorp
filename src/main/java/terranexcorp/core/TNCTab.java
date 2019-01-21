package terranexcorp.core;


import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import com.bioxx.tfc.Core.TFC_Core;
import terranexcorp.core.TNCItems;


import terranexcorp.core.TNCDetails;


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