package terranexcorp.core;

public class TNCDetails
{
	public static final String ModID = "tnc";
	public static final String ModName = "Terra-Nex-Corp";
    public static final String ModVersion = "0.0.7";

	public static final String ModChannel = "Terra-Nex-Corp";
	public static final String SERVER_PROXY_CLASS = "terranexcorp.core.TNCCommonProxy";
	public static final String CLIENT_PROXY_CLASS = "terranexcorp.core.TNCClientProxy";

	public static final String AssetPath = "/assets/" + ModID + "/";

	public static final String MODID_TFC = "terrafirmacraft";
	public static final String MODNAME_TFC = "TerraFirmaCraft";

	public static final String ModDependencies =
			"required-after:Forge@[10.13.4.1558,);"
					+ "required-after:terrafirmacraft@[0.79.26,);";

}
