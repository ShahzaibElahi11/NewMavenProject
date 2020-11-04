package constants;

import utils.BaseTest;

public class QueryWizardControllerConstants extends BaseTest {

    /**
     * Query Wizard Constants
     */
    public static final String QUERY_ENDPOINT = "/query/devices/?query=";
    public static final String EQUAL_OPERATOR = "(type%20==%20\"VIRTUAL_MACHINE\")";
    public static final String NOT_EQUAL_OPERATOR = "(not%20type===%20\"VIRTUAL_MACHINE=%20\")";
    public static final String EXIST_OPERATOR_TRUE = "(adapters.adapter_azure==exists(true))";
    public static final String EXIST_OPERATOR_FALSE = "(adapters.adapter_azure==exists(false))";
    public static final String START_WITH_OPERATOR = "(common.ipAddress==starts(\"172.\"))";
    public static final String END_WITH_OPERATOR = "(common.ipAddress==ends(\".7\"))";
    public static final String IN_OPERATOR = "(common.hostName%20==%20in(\"QA-Instance2-up,%20Inventa-Zone1-nsg\"))";
    public static final String CONTAIN_OPERATOR = "(common.ipAddress==contains(\"16.0\"))";
    public static final String AND_OPERATOR = "(type==\"VIRTUAL_MACHINE\")and(common.hostName==\"App1Web2\")";
    public static final String OR_OPERATOR = "(not%20type==\"VIRTUAL_MACHINE\")or(common.hostName==\"App1Web2\")";
    public static final String DETAIL_QUERY = "(adapters.adapter_ad.dNSHostName==\"DESKTOP-7DN8B20.inventa.local\")";
    public static final String STATEMENT_QUERY = "(((adapters.adapter_azure.location%20==%20starts(\"east\"))and" +
            "(adapters.adapter_azure.Type%20==%20\"Storage%20Account\"))and((adapters.adapter_azure.name%20==%20\"inventargdiag\")))";

    public static final String SAVED_QUERY = "/saved-query/";
    public static final String SAVED_QUERY_PAGINATION = "page=0&size=10";

    public static final String ALL_DEVICE_FIELDS = "/query/fields/all/?fieldEntity=devices&field=adapters.adapter_";
    public static final String ALL_DEVICE_COMMON_FIELDS = "/query/fields/all/?fieldEntity=devices&field=common";

    public static final String TYPE_DEVICE_FIELDS = "/query/fields/type/?fieldEntity=devices&field=adapters.adapter_";

    public static final String OBJECT_DEVICE_FIELDS = "/query/fields/object/?fieldEntity=devices&field=adapters.adapter_";
    public static final String OBJECT_DEVICE_COMMON_FIELDS = "/query/fields/object/?fieldEntity=devices&field=common";


    public static final String ALL_USER_FIELDS = "/query/fields/all/?fieldEntity=users&field=adapters.adapter_";
    public static final String ALL_USER_COMMON_FIELDS = "/query/fields/all/?fieldEntity=users&field=common";

    public static final String OBJECT_USER_FIELDS = "/query/fields/object/?fieldEntity=users&field=adapters.adapter_";
    public static final String OBJECT_USER_COMMON_FIELDS = "/query/fields/object/?fieldEntity=users&field=common";



    public static final String SAVED_DEVICE_QUERY_NAME = BASE_ENDPOINT + ":" + INVENTA_PORT + "/saved-query/?type=DEVICE&page=0&size=1&sort=dateCreated,desc";
    public static final String SAVED_USER_QUERY_NAME = BASE_ENDPOINT + ":" + INVENTA_PORT + "/saved-query/?type=USER&page=0&size=1";

    public QueryWizardControllerConstants() { }
}
