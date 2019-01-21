package terranexcorp.items.tools;

import net.minecraft.client.renderer.texture.IIconRegister;

import com.bioxx.tfc.Items.Tools.ItemCustomSword;
import com.bioxx.tfc.api.Enums.EnumDamageType;
import net.minecraft.item.Item.ToolMaterial;
import terranexcorp.core.TNCDetails;
import terranexcorp.core.TNCTab;
public class ItemNewSword extends ItemCustomSword
{
	public ItemNewSword(ToolMaterial par2EnumToolMaterial, float damage, EnumDamageType dt) {
		super(par2EnumToolMaterial, damage,dt);
        setCreativeTab(TNCTab.TNC_TAB);
	}


	@Override
	public void registerIcons(IIconRegister registerer)
	{
		String name = this.getUnlocalizedName().replace("item.", "");
		this.itemIcon = registerer.registerIcon(TNCDetails.ModID +":tools/" + name);
	}
}
