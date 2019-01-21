package terranexcorp.items;

import net.minecraft.client.renderer.texture.IIconRegister;
import terranexcorp.core.TNCDetails;
import terranexcorp.core.TNCTab;
import com.bioxx.tfc.Items.ItemMeltedMetal;

public class ItemTNCMeltedMetal extends ItemMeltedMetal {

    public ItemTNCMeltedMetal()
    {
        super();
        setCreativeTab(TNCTab.TNC_TAB);
    }

    @Override
    public void registerIcons(IIconRegister registerer) {
        this.itemIcon = registerer.registerIcon(TNCDetails.ModID + ":ingots/" + this.getUnlocalizedName().replace("item.", ""));
    }

}