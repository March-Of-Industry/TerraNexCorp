package terranexcorp.items;

import com.bioxx.tfc.Core.Metal.MetalRegistry;
import com.bioxx.tfc.Items.ItemMetalSheet;
import com.bioxx.tfc.Items.ItemTerra;
import com.bioxx.tfc.TileEntities.TEMetalSheet;
import com.bioxx.tfc.api.Enums.EnumSize;
import com.bioxx.tfc.api.Enums.EnumWeight;
import com.bioxx.tfc.api.Metal;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import terranexcorp.core.TNCBlocks;
import terranexcorp.core.TNCDetails;
import terranexcorp.core.TNCTab;

public class ItemTNCMetalSheet extends ItemMetalSheet
{

    private String metal;
    public int metalID;

    public ItemTNCMetalSheet (String metal,int mID)
    {
        super(mID);
        setMaxDamage(0);
        this.setCreativeTab(TNCTab.TNC_TAB);
        setFolder("sheets/");
        this.setWeight(EnumWeight.MEDIUM);
        this.setSize(EnumSize.MEDIUM);
        this.setMetal(metal,200);
        metalID = mID;
    }

    @Override
    public ItemTerra setMetal(String m, int amt) {
        metal = m;
        metalAmount = (short) amt;
        return this;
    }

    @Override
    public void registerIcons(IIconRegister registerer)
    {
        if(this.metaNames == null)
        {
            if(this.iconString != null)
                this.itemIcon = registerer.registerIcon(TNCDetails.ModID + ":" + this.textureFolder + this.getIconString());
            else
                this.itemIcon = registerer.registerIcon(TNCDetails.ModID + ":" + this.textureFolder + this.getUnlocalizedName().replace("item.", ""));
        }
        else
        {
            metaIcons = new IIcon[metaNames.length];
            for(int i = 0; i < metaNames.length; i++)
            {
                metaIcons[i] = registerer.registerIcon(TNCDetails.ModID + ":" + this.textureFolder + metaNames[i]);
            }

            //This will prevent NullPointerException errors with other mods like NEI
            this.itemIcon = metaIcons[0];
        }
    }

    @Override
    public boolean onItemUse(ItemStack itemstack, EntityPlayer entityplayer, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ)
    {
        boolean isSuccessful = false;
        if(!world.isRemote)
        {
            // Sheets that have temperature or have been worked cannot be placed.
            if(itemstack.hasTagCompound())
                return false;

            TEMetalSheet te = null;
            int[] sides = sidesMap[side];

            // Adding to a sheet block with the same type of sheet
            if (world.getBlock(x, y, z) == TNCBlocks.metalSheetTNC && isValid(world, x, y, z))
            {
                te = (TEMetalSheet)world.getTileEntity(x, y, z);
                switch(side)
                {
                    case 0:
                        if(!te.bottomExists())
                        {
                            te.toggleBottom(true);
                            isSuccessful = true;
                        }
                        break; // Break must always be called so it doesn't loop through all the sides
                    case 1:
                        if(!te.topExists())
                        {
                            te.toggleTop(true);
                            isSuccessful = true;
                        }
                        break;
                    case 2:
                        if(!te.northExists())
                        {
                            te.toggleNorth(true);
                            isSuccessful = true;
                        }
                        break;
                    case 3:
                        if(!te.southExists())
                        {
                            te.toggleSouth(true);
                            isSuccessful = true;
                        }
                        break;
                    case 4:
                        if(!te.eastExists())
                        {
                            te.toggleEast(true);
                            isSuccessful = true;
                        }
                        break;
                    case 5:
                        if(!te.westExists())
                        {
                            te.toggleWest(true);
                            isSuccessful = true;
                        }
                        break;
                }

                // Update block so it properly renders the newly placed side.
                if (isSuccessful)
                    world.markBlockForUpdate(x, y, z);
            }
            // Creating a new sheet block. Cannot click on a sheet block to make a new adjacent one.
            else if (world.getBlock(x, y, z) != TNCBlocks.metalSheetTNC && isValid(world, sides[0] + x, sides[1] + y, sides[2] + z))
            {
                world.setBlock(sides[0] + x, sides[1] + y, sides[2] + z, TNCBlocks.metalSheetTNC);
                te = (TEMetalSheet) world.getTileEntity(sides[0] + x, sides[1] + y, sides[2] + z); //isValid prevents ClassCastException
                te.metalID = this.metalID;
                te.sheetStack = itemstack.copy();
                te.sheetStack.stackSize = 1; // stackSize is always 1 until the block is broken, and then updated based on the sides.
                te.toggleBySide(flipSide(side), true);
                isSuccessful = true;
            }
            else
            {
                isSuccessful = false;
            }

            if(isSuccessful)
            {
                itemstack.stackSize--;
            }

        }
        return isSuccessful;
    }
    public boolean isValid(World world, int i, int j, int k)
    {
        Block block = world.getBlock(i, j, k);
        if (block.isAir(world, i, j, k))
            return true;
        if (block == TNCBlocks.metalSheetTNC && world.getTileEntity(i, j, k) instanceof TEMetalSheet)
        {
            TEMetalSheet te = (TEMetalSheet)world.getTileEntity(i, j, k);
            if(te.metalID == this.metalID)
                return true;
        }
        return false;
    }

    @Override
    public Metal getMetalType(ItemStack is)
    {
        if (metal == null)
        {
            return MetalRegistry.instance.getMetalFromItem(this);
        }
        else
        {
            return MetalRegistry.instance.getMetalFromString(metal);
        }
    }



}