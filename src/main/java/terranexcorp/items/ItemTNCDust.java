package terranexcorp.items;

import terranexcorp.core.TNCTab;

public class ItemTNCDust extends ItemTNCMetalItem {

    public ItemTNCDust(String m, int amt) {
        super(m, amt, "dust");
        setCreativeTab(TNCTab.TNC_TAB);
    }

}