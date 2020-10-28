package constants;

public class DashboardControllerConstants {

    /**
     * Dashboard Constant
     */
    public static final String DASHBOARD_ENDPOINT = "/query/adapters/count/devices/";
    public static final String CONNECTOR_PARAM = "?adapter=adapter_";
    public static final String OS_DISTRIBUTION = "/query/dist/?field=common.operatingSystem.type";
    public static final String USER_COUNT = "/query/count/users/";
    public static final String CONNECTORS_COUNT_FOR_USER = "/query/adapters/count/users/";

    public static final String ASSETS_TYPE_DISTRIBUTION = "/query/dist/?field=type&match=adapters.adapter_";
    public static final String CLOUD_VS_NON_CLOUD = "/query/pie/?field=adapterProperties&match=CLOUD%20PROVIDER";

    //will implement current date logic
    public static final String ASSETS_BY_MONTH_DATE = "/query/assets/devices/discovery?startDate=Jul-01-2020&endDate=Sep-16-2020";
    public static final String USER_BY_MONTH_DATE = "/query/assets/users/discovery?startDate=Jul-01-2020&endDate=Sep-16-2020";

    public static final String TOTAL_WINDOWS_ASSETS = "/query/donut/totalAssets?field=common.operatingSystem.type&match=WINDOWS&type=VIRTUAL_MACHINE";
    public static final String TOTAL_LINUX_ASSETS = "/query/donut/totalAssets?field=common.operatingSystem.type&match=LINUX&type=VIRTUAL_MACHINE";
    public static final String TOTAL_CLOUD_ASSETS = "/query/donut/totalAssets?field=adapterProperties&match=CLOUD%20PROVIDER";

    public static final String TOTAL_MISSING_EDR_ASSETS = "/query/donut/missingEdr";
    public static final String TOTAL_ASSETS_DISTRIBUTION = "/query/chart/dist?field=common.source&topCount=100";

    public static final String TOTAL_CLOUD_DEVICE_TYPE_ASSETS = "/query/chart/dist?field=type&topCount=100";
    public static final String USER_DISTRIBUTION = "/query/chart/user/dist?topCount=6&field=common.source";

    public static final String CPU_HEALTH = "/query/healthCheck?check=CPU";
    public static final String MEMORY_HEALTH = "/query/healthCheck?check=MEMORY";
    public static final String DISCOVERY_HEALTH = "/query/healthCheck?check=DISCOVERY";
    public static final String SCAN_BY_VA = "/query/donut/scannedByVa";


}
