package terranexcorp.items.tools;

import com.bioxx.tfc.api.Enums.EnumSize;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;

import com.bioxx.tfc.Items.Tools.ItemKnife;
import com.bioxx.tfc.api.Enums.EnumDamageType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import terranexcorp.core.TNCDetails;
import terranexcorp.core.TNCItems;
import terranexcorp.core.TNCTab;
public class ItemNewKnife extends ItemKnife
{
	public ItemNewKnife(ToolMaterial par2EnumToolMaterial, float damage) {
		super(par2EnumToolMaterial, damage);
		setCreativeTab(TNCTab.TNC_TAB);
	}

	@Override
	public boolean onBlockDestroyed(ItemStack knife, World world, Block block, int x, int y, int z, EntityLivingBase entity)
	{
		if(getUnlocalizedName(knife).contains("item.Knife_Bedrock"))
		{
			knife.setItemDamage(0);
		}
		return super.onBlockDestroyed(knife,world,block,x,y,z,entity);
	}

	@Override
	public void registerIcons(IIconRegister registerer)
	{
		String name = this.getUnlocalizedName().replace("item.", "");
		this.itemIcon = registerer.registerIcon(TNCDetails.ModID +":tools/" + name);
	}
}
