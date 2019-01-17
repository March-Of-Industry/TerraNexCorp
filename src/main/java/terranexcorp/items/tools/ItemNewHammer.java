package terranexcorp.items.tools;

import net.minecraft.client.renderer.texture.IIconRegister;

import com.bioxx.tfc.Items.Tools.ItemHammer;
import com.bioxx.tfc.api.Enums.EnumDamageType;
import net.minecraft.item.Item.ToolMaterial;

public class ItemNewHammer extends ItemHammer
{
	public ItemNewHammer(ToolMaterial par2EnumToolMaterial, float damage) {
		super(par2EnumToolMaterial, damage);
	}


	@Override
	public void registerIcons(IIconRegister registerer)
	{
		String name = this.getUnlocalizedName().replace("item.", "");
		this.itemIcon = registerer.registerIcon("tnc:tools/" + name);
	}
}
