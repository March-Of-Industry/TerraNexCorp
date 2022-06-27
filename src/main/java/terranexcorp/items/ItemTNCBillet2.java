package terranexcorp.items;

import com.bioxx.tfc.api.Constant.Global;
import com.bioxx.tfc.api.Enums.EnumSize;
import com.bioxx.tfc.api.Metal;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import terranexcorp.core.TNCDetails;
import terranexcorp.core.TNCGlobals;
import terranexcorp.core.TNCTab;


public class ItemTNCBillet2 extends ItemTNCMetalItem
{
    private EnumSize size = EnumSize.TINY;
    private String metal;
    private short metalAmount;
    private boolean smeltable = true;

    public ItemTNCBillet2(int amt)
    {
        super();
        metalAmount= (short) amt;
        setHasSubtypes(true);
        metaNames = new String[] {"B"};
        setCreativeTab(TNCTab.TNC_TAB);
    }

    @Override
    public void registerIcons(IIconRegister registerer)
    {
        metaIcons = new IIcon[metaNames.length];
        for(int i = 0; i < metaNames.length; i++)
            metaIcons[i] = registerer.registerIcon(TNCDetails.ModID + ":billets/small/"  + metaNames[i] + "_Ore");
    }

    @Override
    public Metal getMetalType(ItemStack is)
    {
        switch (is.getItemDamage())
        {
            case 0:
                return TNCGlobals.FERROCHROME;
            default:
                return null;
        }
    }
}
