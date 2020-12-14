package testcases;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import models.savedquery.SavedQuery;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Title;
import org.junit.Assume;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import utils.BaseTest;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static constants.ConnectorConfigurationConstants.*;
import static constants.QueryWizardControllerConstants.*;
import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_OK;

@RunWith(SerenityRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class QueryWizardTest extends BaseTest {

    public static boolean isPreviousTestPass;


    public static String getNameFromSaveQueryWizardURL(String url) throws IOException {
        ObjectMapper mapper = new ObjectMapper(); // just need one
        String json = readJsonFromUrl(url).toString();
        Map<String, Object> map = mapper.readValue(json, Map.class);
        return ((Map) ((List) ((Map) map.get("data")).get("content")).get(0)).get("name") + "";
    }


    @Test
    @Title("Get Query Wizard Equal Operator")
    public void getEqualOperator() {
        given().
                spec(requestSpec).
                when().
                get(QUERY_ENDPOINT + EQUAL_OPERATOR).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get Query Wizard Not Equal Operator")
    public void getNotEqualOperator() {
        given().
                spec(requestSpec).
                when().
                get(QUERY_ENDPOINT + NOT_EQUAL_OPERATOR).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get Query Wizard Exists Operator with True Condition")
    public void getExistsOperatorTrue() {
        given().
                spec(requestSpec).
                when().
                get(QUERY_ENDPOINT + EXIST_OPERATOR_TRUE).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get Query Wizard Exists Operator with False Condition")
    public void getExistsOperatorFalse() {
        given().
                spec(requestSpec).
                when().
                get(QUERY_ENDPOINT + EXIST_OPERATOR_FALSE).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get Query Wizard Starts With Operator")
    public void getStartWithOperator() {
        given().
                spec(requestSpec).
                when().
                get(QUERY_ENDPOINT + START_WITH_OPERATOR).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get Query Wizard End With Operator")
    public void getEndWithOperator() {
        given().
                spec(requestSpec).
                when().
                get(QUERY_ENDPOINT + END_WITH_OPERATOR).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get Query Wizard IN Operator")
    public void getInOperator() {
        given().
                spec(requestSpec).
                when().
                get(QUERY_ENDPOINT + IN_OPERATOR).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get Query Wizard Contain Operator")
    public void getContainOperator() {
        given().
                spec(requestSpec).
                when().
                get(QUERY_ENDPOINT + CONTAIN_OPERATOR).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get Query Wizard AND Operator")
    public void getANDOperator() {
        given().
                spec(requestSpec).
                when().
                get(QUERY_ENDPOINT + AND_OPERATOR).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get Query Wizard OR Operator")
    public void getOROperator() {
        given().
                spec(requestSpec).
                when().
                get(QUERY_ENDPOINT + OR_OPERATOR).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get Query Wizard Connector Details Query")
    public void getConnectorDetailsQuery() {
        given().
                spec(requestSpec).
                when().
                get(QUERY_ENDPOINT + DETAIL_QUERY).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get Query Wizard Statement Query")
    public void getStatementQuery() {
        given().
                spec(requestSpec).
                when().
                get(QUERY_ENDPOINT + STATEMENT_QUERY).
                then().
                spec(responseSpec);
    }

    /**
     * Saved Query Controller
     */
    @Test
    @Title("Post Save Query on Device")
    public void testA_postDeviceSaveQuery() {
        isPreviousTestPass = false;

        SavedQuery deviceSavedQuery = new SavedQuery("Automation_Device_Query_" + VALUE, "Created By Automation Script", "(adapters.adapter_ad.cn == exists(true))", "DEVICE", Collections.singletonList("Device_Tag_" + VALUE));
        Response response = given().
                spec(requestSpec).
                and().
                body(deviceSavedQuery).
                when().
                post(SAVED_QUERY);

        if (response.getStatusCode() == SC_OK)
            isPreviousTestPass = true;
        response.
                then().
                spec(responseSpec);
    }


    @Test
    @Title("Post Save Query Overwrite")
    public void testB_postDeviceSaveQueryOverWrite() {
        Assume.assumeTrue(isPreviousTestPass == true);
        isPreviousTestPass = false;
        SavedQuery deviceSavedQuery = new SavedQuery("Automation_Device_Query_" + VALUE, "Created By Automation Script", "(adapters.adapter_ad.cn == exists(true))", "DEVICE", Collections.singletonList("Device_Tag_" + VALUE));
        Response response = given().
                spec(requestSpec).
                and().
                body(deviceSavedQuery).
                when().
                patch(SAVED_QUERY + "rename/?oldName=Automation_Device_Query_" + VALUE + "&newName=" + "Update_Automation_Device_Query_" + VALUE + "&type=DEVICE");
        if (response.getStatusCode() == SC_OK)
            isPreviousTestPass = true;
        response.
                then().
                spec(responseSpec);

    }

    @Test
    @Title("Get Execute Saved Queries on Devices")
    public void testC_getExecuteDeviceSavedQuery() throws IOException {
        String deviceSavedQueryName;
        deviceSavedQueryName = getNameFromSaveQueryWizardURL(SAVED_DEVICE_QUERY_NAME);
        given().
                spec(requestSpec).
                when().
                get(SAVED_QUERY + "execute/device/" + deviceSavedQueryName).
                then().
                spec(responseSpec);
    }


    @Test
    @Title("Post Save Query on User")
    public void testD_postUserSaveQuery() {
        isPreviousTestPass = false;

        SavedQuery userSavedQuery = new SavedQuery("Automation_User_Query_" + VALUE, "Created By Automation Script", "(adapters.adapter_ad.cn == exists(true))", "USER", Collections.singletonList("User_Tag_" + VALUE));
        Response response = given().
                spec(requestSpec).
                and().
                body(userSavedQuery).
                when().
                post(SAVED_QUERY);
        if (response.getStatusCode() == SC_OK)
            isPreviousTestPass = true;
        response.
                then().
                spec(responseSpec);

    }

    @Test
    @Title("Post User Save Query Overwrite")
    public void testE_postUserSaveQueryOverWrite() {
        Assume.assumeTrue(isPreviousTestPass == true);
        isPreviousTestPass = false;
        SavedQuery userSavedQuery = new SavedQuery("Automation_User_Query_" + VALUE, "Created By Automation Script", "(adapters.adapter_ad.cn == exists(true))", "USER", Collections.singletonList("User_Tag_" + VALUE));
        Response response = given().
                spec(requestSpec).
                and().
                body(userSavedQuery).
                when().
                patch(SAVED_QUERY + "rename/?oldName=Automation_User_Query_" + VALUE + "&newName=" + "Update_Automation_User_Query" + VALUE + "&type=USER");
        if (response.getStatusCode() == SC_OK)
            isPreviousTestPass = true;
        response.
                then().
                spec(responseSpec);

    }

    @Test
    @Title("Get Execute Saved Queries on Users")
    public void testF_getExecuteUserSavedQuery() throws IOException {
        String userSavedQueryName;
        userSavedQueryName = getNameFromSaveQueryWizardURL(SAVED_USER_QUERY_NAME);
        given().
                spec(requestSpec).
                when().
                get(SAVED_QUERY + "execute/user/" + userSavedQueryName).
                then().
                spec(responseSpec);
    }


    @Test
    @Title("Get Device Saved Queries")
    public void getDeviceSavedQueries() {
        given().
                spec(requestSpec).
                when().
                get(SAVED_QUERY + "?type=DEVICE&" + SAVED_QUERY_PAGINATION).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get User Saved Queries")
    public void getUserSavedQueries() {
        given().
                spec(requestSpec).
                when().
                get(SAVED_QUERY + "?type=USER&" + SAVED_QUERY_PAGINATION).
                then().
                spec(responseSpec);
    }


    @Test
    @Title("Get All Saved Queries")
    public void getAllSavedQueries() {
        given().
                spec(requestSpec).
                when().
                get(SAVED_QUERY + "?" + SAVED_QUERY_PAGINATION).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get All Device Saved Queries Without Pagination")
    public void getAllSavedQueriesNoPaginationDevice() {
        given().
                spec(requestSpec).
                when().
                get(SAVED_QUERY + "?unpaged&type=DEVICE").
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get All User Saved Queries Without Pagination")
    public void getAllSavedQueriesNoPaginationUser() {
        given().
                spec(requestSpec).
                when().
                get(SAVED_QUERY + "?unpaged&type=USER").
                then().
                spec(responseSpec);
    }


    /**
     * Remaining
     * Patch- Rename User Saved Query	http://inventaserver:9092/saved-query/rename/?oldName=testuser&newName=test_user&type=USER
     * Patch- Rename Device Saved Query	http://inventaserver:9092/saved-query/rename/?oldName=SaveQuery14&newName=SaveQuery143&type=DEVICE
     */
    /**
     * new
     */

    /**
     * All Device Fields
     */
    @Test
    @Title("Get Query Wizard All AD Device Fields")
    public void getAllAdDeviceFields() {
        given().
                spec(requestSpec).
                when().
                get(ALL_DEVICE_FIELDS + AD).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get Query Wizard All AWS Device Fields")
    public void getAllAwsDeviceFields() {
        given().
                spec(requestSpec).
                when().
                get(ALL_DEVICE_FIELDS + AWS).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get Query Wizard All Azure Device Fields")
    public void getAllAzureDeviceFields() {
        given().
                spec(requestSpec).
                when().
                get(ALL_DEVICE_FIELDS + AZURE).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get Query Wizard All CrowdStrike Device Fields")
    public void getAllCrowdStrikeDeviceFields() {
        given().
                spec(requestSpec).
                when().
                get(ALL_DEVICE_FIELDS + CROWD_STRIKE).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get Query Wizard All VMWARE ESXI Device Fields")
    public void getAllVmwareEsxiDeviceFields() {
        given().
                spec(requestSpec).
                when().
                get(ALL_DEVICE_FIELDS + VMWARE).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get Query Wizard All Wmic Device Fields")
    public void getAllWmicDeviceFields() {
        given().
                spec(requestSpec).
                when().
                get(ALL_DEVICE_FIELDS + WMIC).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get Query Wizard All Shodan Device Fields")
    public void getAllShodanDeviceFields() {
        given().
                spec(requestSpec).
                when().
                get(ALL_DEVICE_FIELDS + SHODAN).
                then().
                spec(responseSpec);
    }
    @Test
    @Title("Get Query Wizard All Common Device Fields")
    public void getAllCommonDeviceFields() {
        given().
                spec(requestSpec).
                when().
                get(ALL_DEVICE_COMMON_FIELDS).
                then().
                spec(responseSpec);
    }


    /**
     * All User Fields
     */
    @Test
    @Title("Get Query Wizard All AD User Fields")
    public void getAllAdUserFields() {
        given().
                spec(requestSpec).
                when().
                get(ALL_USER_FIELDS + AD).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get Query Wizard All AWS User Fields")
    public void getAllAwsUserFields() {
        given().
                spec(requestSpec).
                when().
                get(ALL_USER_FIELDS + AWS).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get Query Wizard All CrowdStrike User Fields")
    public void getAllCrowdstrikeUserFields() {
        given().
                spec(requestSpec).
                when().
                get(ALL_USER_FIELDS + CROWD_STRIKE).
                then().
                spec(responseSpec);
    }


    @Test
    @Title("Get Query Wizard All Azure User Fields")
    public void getAllAzureUserFields() {
        given().
                spec(requestSpec).
                when().
                get(ALL_USER_FIELDS + AZURE).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get Query Wizard All Common User Fields")
    public void getAllCommonUserFields() {
        given().
                spec(requestSpec).
                when().
                get(ALL_USER_COMMON_FIELDS).
                then().
                spec(responseSpec);
    }

    /**
     *  Device TYPE Fields
     */

    @Test
    @Title("Get Query Wizard Azure Type Fields For Devices")
    public void getAzureTypeDeviceFields() {
        given().
                spec(requestSpec).
                when().
                get(TYPE_DEVICE_FIELDS + AZURE).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get Query Wizard AWS Type Fields For Devices")
    public void getAwsTypeDeviceFields() {
        given().
                spec(requestSpec).
                when().
                get(TYPE_DEVICE_FIELDS + AWS).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get Query Wizard AD Type Fields For Devices")
    public void getAdTypeDeviceFields() {
        given().
                spec(requestSpec).
                when().
                get(TYPE_DEVICE_FIELDS + AD).
                then().
                spec(responseSpec);
    }

    /**
     *  Device Object Fields
     */

    @Test
    @Title("Get Query Wizard Active Directory Object Fields For Devices")
    public void getAdObjectDeviceFields() {
        given().
                spec(requestSpec).
                when().
                get(OBJECT_DEVICE_FIELDS + AD).
                then().
                spec(responseSpec);
    }


    @Test
    @Title("Get Query Wizard AWS Object Fields For Devices")
    public void getAwsObjectDeviceFields() {
        given().
                spec(requestSpec).
                when().
                get(OBJECT_DEVICE_FIELDS + AWS).
                then().
                spec(responseSpec);
    }


    @Test
    @Title("Get Query Wizard Azure Object Fields For Devices")
    public void getAzureObjectDeviceFields() {
        given().
                spec(requestSpec).
                when().
                get(OBJECT_DEVICE_FIELDS + AZURE).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get Query Wizard Crowd Strike Object Fields For Devices")
    public void getCrowdStrikeObjectDeviceFields() {
        given().
                spec(requestSpec).
                when().
                get(OBJECT_DEVICE_FIELDS + CROWD_STRIKE).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get Query Wizard Shodan Object Fields For Devices")
    public void getShodanObjectDeviceFields() {
        given().
                spec(requestSpec).
                when().
                get(OBJECT_DEVICE_FIELDS + SHODAN).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get Query Wizard VMWARE ESXI Object Fields For Devices")
    public void getVmwareEsxiObjectDeviceFields() {
        given().
                spec(requestSpec).
                when().
                get(OBJECT_DEVICE_FIELDS + VMWARE).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get Query Wizard Common Object Fields For Devices")
    public void getCommonObjectDeviceFields() {
        given().
                spec(requestSpec).
                when().
                get(OBJECT_DEVICE_COMMON_FIELDS).
                then().
                spec(responseSpec);
    }
    /**
     * Object User Fields
     */

    @Test
    @Title("Get Query Wizard AWS Object Fields For User")
    public void getAwsObjectUserFields() {
        given().
                spec(requestSpec).
                when().
                get(OBJECT_USER_FIELDS + AWS).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get Query Wizard Azure Object Fields For User")
    public void getAzureObjectUserFields() {
        given().
                spec(requestSpec).
                when().
                get(OBJECT_USER_FIELDS + AZURE).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get Query Wizard Active Directory Object Fields For User")
    public void getAdObjectUserFields() {
        given().
                spec(requestSpec).
                when().
                get(OBJECT_USER_FIELDS + AD).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get Query Wizard Common Object Fields For User")
    public void getCommonObjectUserFields() {
        given().
                spec(requestSpec).
                when().
                get(OBJECT_USER_COMMON_FIELDS).
                then().
                spec(responseSpec);
    }
}
