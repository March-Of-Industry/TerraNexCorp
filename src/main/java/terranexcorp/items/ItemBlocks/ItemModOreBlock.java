package terranexcorp.items.ItemBlocks;

import net.minecraft.block.Block;
import terranexcorp.core.TNCGlobals;

import com.bioxx.tfc.Items.ItemBlocks.ItemTerraBlock;

public class ItemModOreBlock extends ItemTerraBlock {

    public ItemModOreBlock(Block b) {
        super(b);
        metaNames = TNCGlobals.ORE_METAL;
    }

}