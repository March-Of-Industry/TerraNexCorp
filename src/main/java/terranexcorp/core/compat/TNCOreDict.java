package terranexcorp.core.compat;

import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import terranexcorp.core.TNCItems;

public class TNCOreDict
{
    public static void addOreDict()
    {
        OreDictionary.registerOre("itemKnife",new ItemStack(TNCItems.itemKnife_Bedrock,1,32767));
    }
}
