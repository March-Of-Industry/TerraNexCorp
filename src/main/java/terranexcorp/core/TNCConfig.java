package terranexcorp.core;
import java.io.File;
import static com.bioxx.tfc.WorldGen.Generators.WorldGenOre.oreList;


import terranexcorp.core.TNCDetails;

import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.common.config.Configuration;

import com.bioxx.tfc.Core.Config.TFC_ConfigFiles;
import com.bioxx.tfc.WorldGen.Generators.OreSpawnData;
import com.bioxx.tfc.api.Constant.Global;
import com.google.common.collect.ObjectArrays;



public class TNCConfig
{
	public static Configuration config;
    public static String windowText = "March of Industry";
    public static int bedSwordDamage = 1200;
    public static int bedMaceDamage = 1200;
    public static int bedKnifeDamage = 700;
    public static int bedHammerDamage = 900;
	public static boolean enableNEIHiding = true;
	public static boolean enableRainFix = true;
	public static boolean enableSimpleRefinement = false;
	public static int crushedOreUnits = 35;
	private static Configuration oresConfig;

	private static final String[] ALLOWED_TYPES = new String[] { "default", "veins" };
	private static final String[] ALLOWED_SIZES = new String[] { "small", "medium", "large" };
	private static final String[] ALLOWED_BASE_ROCKS = ObjectArrays.concat(Global.STONE_ALL, new String[] { "igneous intrusive", "igneous extrusive", "sedimentary", "metamorphic" }, String.class);


	public static void init(File configFile)
	{
		if(config == null)
		{
			config = new Configuration(configFile);
			loadConfig();
		}
	}

	@SubscribeEvent
	public void onConfigChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event)
	{
		if(event.modID.equalsIgnoreCase(TNCDetails.ModID))
			loadConfig();
	}

    private static void loadConfig()
    {
        bedSwordDamage = config.getInt("Bedrock Sword Damage","Damage changing", 1200, 1, 5000, "Used to Change Bedrock Sword Damage ");
        bedMaceDamage = config.getInt("Bedrock Mace Damage","Damage changing", 1200, 1, 5000, "Used to Change Bedrock Mace Damage ");
        bedKnifeDamage = config.getInt("Bedrock Knife Damage","Damage changing", 700, 1, 5000, "Used to Change Bedrock Knife Damage ");
        bedHammerDamage = config.getInt("Bedrock Hammer Damage","Damage changing", 900, 1, 5000, "Used to Change Bedrock Hammer Damage ");
        enableNEIHiding = config.getBoolean("NEI Hiding","General",true,"Hide Internal Stuff from NEI");
        enableRainFix = config.getBoolean("Use Event to add rain particles","General",true,"Use event to add the splash particles and sound back to game if using patched tfc+dragonAPI with NORAINFX enabled");
        enableSimpleRefinement = config.getBoolean("Crucible Processing","General",false,"Allow processing of (Rutile,Illmenite,Chromite,Pyrolusite,Bauxite) in Crucible");
		crushedOreUnits = config.getInt("Crushed Ore Units","Unit Amounts", 35, 1, 3000, "Used to Change the Metal Units in Crushed Ore ");
        if(config.hasChanged())
            config.save();
    }


	public static void reloadOres() {
		oreList.put("Chromite", getOreData("Chromite", "default", "medium", TNCDetails.ModID + ":Ore", 0, 180, new String[] {"gabbro", "basalt"}, 5, 128, 60, 80));
		oreList.put("Ilumite", getOreData("Ilumite", "default", "medium", TNCDetails.ModID + ":Ore", 1, 160, new String[] {"igneous intrusive","gneiss","schist"}, 5, 128, 80, 60));
		oreList.put("Rutile", getOreData("Rutile", "default", "medium", TNCDetails.ModID + ":Ore", 2, 160, new String[] {"gabbro", "granite","basalt"}, 5, 128, 80, 60));
		oreList.put("Pyrolusite", getOreData("Pyrolusite", "default", "medium", TNCDetails.ModID + ":Ore", 3, 120, new String[] { "igneous intrusive", "igneous extrusive", "sedimentary", "metamorphic"}, 5, 128, 80, 60));

		// getCategoryNames returns an ImmutableSet
		for (String s : oresConfig.getCategoryNames()) {
			// If this is a new entry, otherwise it has already been added by the previous bit of code.
			if (!oreList.containsKey(s))
				oreList.put(s, getOreData(s, "default", "small", "Ore", 0, 100, new String[] { "granite", "basalt", "sedimentary" }, 5, 128, 50, 50));
		}

		if (oresConfig.hasChanged())
			oresConfig.save();
	}

	private static OreSpawnData getOreData(String category, String type, String size, String blockName, int meta, int rarity, String[] rocks, int min, int max,
										   int v, int h) {
		oresConfig = TFC_ConfigFiles.getOresConfig();
		return new OreSpawnData(
				oresConfig.get(category, "type", type).setValidValues(ALLOWED_TYPES).getString(),
				oresConfig.get(category, "size", size).setValidValues(ALLOWED_SIZES).getString(),
				oresConfig.get(category, "oreName", blockName).getString(),
				oresConfig.get(category, "oreMeta",	meta).getInt(),
				oresConfig.get(category, "rarity", rarity).getInt(),
				oresConfig.get(category, "baseRocks", rocks).setValidValues(ALLOWED_BASE_ROCKS).getStringList(),
				oresConfig.get(category, "Minimum Height", min).getInt(),
				oresConfig.get(category, "Maximum Height", max).getInt(),
				oresConfig.get(category, "Vertical Density", v).getInt(),
				oresConfig.get(category, "Horizontal Density", h).getInt()
		);
	}



}
