package terranexcorp.items;

import net.minecraft.client.renderer.texture.IIconRegister;
import terranexcorp.core.TNCDetails;
import terranexcorp.core.TNCTab;
import com.bioxx.tfc.Items.ItemIngot;
import com.bioxx.tfc.api.Enums.EnumSize;

public class ItemTNCIngot extends ItemIngot {

    public ItemTNCIngot(String m, int amt) {
        super();
        this.setMetal(m, amt);
        setCreativeTab(TNCTab.TNC_TAB);
        if (amt > 100) {
            this.setSize(EnumSize.LARGE);
        }
    }

    @Override
    public void registerIcons(IIconRegister registerer) {
        this.itemIcon = registerer.registerIcon(TNCDetails.ModID + ":ingots/" + this.getUnlocalizedName().replace("item.", ""));
    }

}