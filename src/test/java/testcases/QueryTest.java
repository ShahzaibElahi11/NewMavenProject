package testcases;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import utils.BaseTest;

import static constants.ConnectorConfigurationConstants.*;
import static constants.QueryControllerConstants.*;
import static io.restassured.RestAssured.given;

@RunWith(SerenityRunner.class)
public class QueryTest extends BaseTest {

    @Test
    @Title("Get Connectors List of Discovered Devices")
    public void getConnectorsForDeviceQuery() {
        given().
                spec(requestSpec).
                when().
                get(QUERY_CONNECTOR + FIELD_ENTITY_PARAM + DEVICES).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get Connectors List of Discovered Users")
    public void getConnectorsForUserQuery() {
        given().
                spec(requestSpec).
                when().
                get(QUERY_CONNECTOR + FIELD_ENTITY_PARAM + USERS).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get Device Fields For Query")
    public void getFieldsForDeviceQuery() {
        given().
                spec(requestSpec).
                when().
                get(QUERY_FIELDS + FIELD_ENTITY_PARAM + DEVICES).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get User Fields For Query")
    public void getFieldsForUserQuery() {
        given().
                spec(requestSpec).
                when().
                get(QUERY_FIELDS + FIELD_ENTITY_PARAM + USERS).
                then().
                spec(responseSpec);
    }

    /**
     * Device Columns
     */

    @Test
    @Title("Get Device Common Columns")
    public void getDeviceCommonColumns() {
        given().
                spec(requestSpec).
                when().
                get(COLUMNS + FIELD_ENTITY_PARAM + DEVICES + COMMON_COLUMNS).
                then().
                spec(responseSpec);
    }


    @Test
    @Title("Get AWS Specific Device Columns")
    public void getAwsDeviceColumns() {
        given().
                spec(requestSpec).
                when().
                get(COLUMNS + FIELD_ENTITY_PARAM + DEVICES + CONNECTOR_SPECIFIC_COLUMNS + AWS).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get Azure Specific Device Columns")
    public void getAzureDeviceColumns() {
        given().
                spec(requestSpec).
                when().
                get(COLUMNS + FIELD_ENTITY_PARAM + DEVICES + CONNECTOR_SPECIFIC_COLUMNS + AZURE).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get AD Specific Device Columns")
    public void getAdDeviceColumns() {
        given().
                spec(requestSpec).
                when().
                get(COLUMNS + FIELD_ENTITY_PARAM + DEVICES + CONNECTOR_SPECIFIC_COLUMNS + AD).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get VMWare_ESXI Specific Device Columns")
    public void getVmwareEsxiDeviceColumns() {
        given().
                spec(requestSpec).
                when().
                get(COLUMNS + FIELD_ENTITY_PARAM + DEVICES + CONNECTOR_SPECIFIC_COLUMNS + VMWARE).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get Shodan Specific Device Columns")
    public void getShodanDeviceColumns() {
        given().
                spec(requestSpec).
                when().
                get(COLUMNS + FIELD_ENTITY_PARAM + DEVICES + CONNECTOR_SPECIFIC_COLUMNS + SHODAN).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get Rapid7 Specific Device Columns")
    public void getRapid7DeviceColumns() {
        given().
                spec(requestSpec).
                when().
                get(COLUMNS + FIELD_ENTITY_PARAM + DEVICES + CONNECTOR_SPECIFIC_COLUMNS + RAPID7).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get CrowdStrike Specific Device Columns")
    public void getCrowdStrikeDeviceColumns() {
        given().
                spec(requestSpec).
                when().
                get(COLUMNS + FIELD_ENTITY_PARAM + DEVICES + CONNECTOR_SPECIFIC_COLUMNS + CROWD_STRIKE).
                then().
                spec(responseSpec);
    }

    /**
     * User Columns
     *
     */

    @Test
    @Title("Get User Common Columns")
    public void getUserCommonColumns() {
        given().
                spec(requestSpec).
                when().
                get(COLUMNS + FIELD_ENTITY_PARAM + USERS + COMMON_COLUMNS).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get AWS Specific User Columns")
    public void getAwsUserColumns() {
        given().
                spec(requestSpec).
                when().
                get(COLUMNS + FIELD_ENTITY_PARAM + USERS + CONNECTOR_SPECIFIC_COLUMNS + AWS).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get Azure Specific User Columns")
    public void getAzureUserColumns() {
        given().
                spec(requestSpec).
                when().
                get(COLUMNS + FIELD_ENTITY_PARAM + USERS + CONNECTOR_SPECIFIC_COLUMNS + AZURE).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get AD Specific User Columns")
    public void getAdUserColumns() {
        given().
                spec(requestSpec).
                when().
                get(COLUMNS + FIELD_ENTITY_PARAM + USERS + CONNECTOR_SPECIFIC_COLUMNS + AD).
                then().
                spec(responseSpec);
    }

    /**
     @Test
     @Title("Get Rapid7 Specific User Columns")
     public void getRapid7UserColumns() {
     given().
     spec(requestSpec).
     when().
     get(COLUMNS + FIELD_ENTITY_PARAM + USERS + CONNECTOR_SPECIFIC_COLUMNS + RAPID7).
     then().
     spec(responseSpec);
     }
     */
    @Test
    @Title("Get CrowdStrike Specific User Columns")
    public void getCrowdStrikeUserColumns() {
        given().
                spec(requestSpec).
                when().
                get(COLUMNS + FIELD_ENTITY_PARAM + USERS + CONNECTOR_SPECIFIC_COLUMNS + CROWD_STRIKE).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get All Operation in Query Wizard")
    public void getAllOperations() {
        given().
                spec(requestSpec).
                when().
                get(QUERY_OPERATION).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get Int Type Operation in Query Wizard")
    public void getIntTypeOperations() {
        given().
                spec(requestSpec).
                when().
                get(QUERY_OPERATION + INT).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get Integer Type Operation in Query Wizard")
    public void getIntegerTypeOperations() {
        given().
                spec(requestSpec).
                when().
                get(QUERY_OPERATION + INTEGER).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get Long Type Operation in Query Wizard")
    public void getLongTypeOperations() {
        given().
                spec(requestSpec).
                when().
                get(QUERY_OPERATION + LONG).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get Double Type Operation in Query Wizard")
    public void getDoubleTypeOperations() {
        given().
                spec(requestSpec).
                when().
                get(QUERY_OPERATION + DOUBLE).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get String Type Operation in Query Wizard")
    public void getStringTypeOperations() {
        given().
                spec(requestSpec).
                when().
                get(QUERY_OPERATION + STRING).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get Date Type Operation in Query Wizard")
    public void getDateTypeOperations() {
        given().
                spec(requestSpec).
                when().
                get(QUERY_OPERATION + DATE).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get Boolean Type Operation in Query Wizard")
    public void getBooleanTypeOperations() {
        given().
                spec(requestSpec).
                when().
                get(QUERY_OPERATION + BOOL).
                then().
                spec(responseSpec);
    }
}
