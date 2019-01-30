package terranexcorp.items.ItemBlocks;

import net.minecraft.block.Block;
import terranexcorp.core.TNCGlobals;

import com.bioxx.tfc.Items.ItemBlocks.ItemTerraBlock;

public class ItemModOreBlock extends ItemTerraBlock {

    public ItemModOreBlock(Block b) {
        super(b);
        metaNames = new String[TNCGlobals.MOD_ORE_METAL.length];
        System.arraycopy(TNCGlobals.MOD_ORE_METAL, 0, metaNames, 0, TNCGlobals.MOD_ORE_METAL.length);
    }

}