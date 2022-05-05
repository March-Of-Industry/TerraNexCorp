package terranexcorp.core;

public class TNCDetails
{
	public static final String ModID = "TFCERF";
	public static final String ModName = "Terrafirmacraft-EventRainFix";
    public static final String ModVersion = "1";

	public static final String SERVER_PROXY_CLASS = "terranexcorp.core.TNCCommonProxy";
	public static final String CLIENT_PROXY_CLASS = "terranexcorp.core.TNCClientProxy";

	public static final String AssetPath = "/assets/" + ModID + "/";


	public static final String ModDependencies =
			"required-after:Forge@[10.13.4.1558,);"
					+ "required-after:terrafirmacraft@[0.79.26,);";

}
