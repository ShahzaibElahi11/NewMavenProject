package testcases;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Title;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import utils.BaseTest;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static constants.Constants.*;
import static io.restassured.RestAssured.given;

@RunWith(SerenityRunner.class)
public class QueryWizardTest extends BaseTest {

    public static String SAVED_DEVICE_QUERY_NAME = "";
    public static String SAVED_USER_QUERY_NAME = "";


    public static String getNameFromSaveQueryWizardURL(String url) throws IOException {
        ObjectMapper mapper = new ObjectMapper(); // just need one
        String json = readJsonFromUrl(url).toString();
        Map<String, Object> map = mapper.readValue(json, Map.class);
        return ((Map) ((List) ((Map) map.get("data")).get("content")).get(0)).get("name") + "";
    }


    static {
        try {
            SAVED_DEVICE_QUERY_NAME = getNameFromSaveQueryWizardURL("http://inventaserver:9092/saved-query/?type=DEVICE&page=0&size=1");
            //SAVED_USER_QUERY_NAME = getNameFromSaveQueryWizardURL("http://inventaserver:9092/saved-query/?type=USER&page=0&size=1");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    @Title("Get Query Wizard Equal Operator")
    public void getEqualOperator(){
        given().
                spec(requestSpec).
                when().
                get(QUERY_ENDPOINT + EQUAL_OPERATOR).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get Query Wizard Not Equal Operator")
    public void getNotEqualOperator(){
        given().
                spec(requestSpec).
                when().
                get(QUERY_ENDPOINT + NOT_EQUAL_OPERATOR).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get Query Wizard Exists Operator with True Condition")
    public void getExistsOperatorTrue(){
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
    public void getStartWithOperator(){
        given().
                spec(requestSpec).
                when().
                get(QUERY_ENDPOINT + START_WITH_OPERATOR).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get Query Wizard End With Operator")
    public void getEndWithOperator(){
        given().
                spec(requestSpec).
                when().
                get(QUERY_ENDPOINT + END_WITH_OPERATOR).
                then().
                spec(responseSpec);
    }
    @Test
    @Title("Get Query Wizard IN Operator")
    public void getInOperator(){
        given().
                spec(requestSpec).
                when().
                get( QUERY_ENDPOINT + IN_OPERATOR).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get Query Wizard Contain Operator")
    public void getContainOperator(){
        given().
                spec(requestSpec).
                when().
                get(QUERY_ENDPOINT + CONTAIN_OPERATOR).
                then().
                spec(responseSpec);
    }
    @Test
    @Title("Get Query Wizard AND Operator")
    public void getANDOperator(){
        given().
                spec(requestSpec).
                when().
                get(QUERY_ENDPOINT + AND_OPERATOR).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get Query Wizard OR Operator")
    public void getOROperator(){
        given().
                spec(requestSpec).
                when().
                get(QUERY_ENDPOINT + OR_OPERATOR).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get Query Wizard Connector Details Query")
    public void getConnectorDetailsQuery(){
        given().
                spec(requestSpec).
                when().
                get(QUERY_ENDPOINT + DETAIL_QUERY).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get Query Wizard Statement Query")
    public void getStatementQuery(){
        given().
                spec(requestSpec).
                when().
                get(QUERY_ENDPOINT + STATEMENT_QUERY).
                then().
                spec(responseSpec);
    }

    /**
     * Saved Query Controller
     *
     */
    @Ignore
    @Test
    @Title("Post Enforce Save Query on Device")
    public void postDeviceSaveQuery(){
        //BASE_ENDPOINT_INVENTA + SAVED_QUERY
        //String json = "{\"name\":\"Automation_Device_SaveQuery_#"+value+"\",\"query\": \"(hostName==\\\"inventa-windows\\\")\",\"type\": \"DEVICE\", \"description\": \"Automation_Device_SaveQuery_#"+value+"\"}";

    }

    @Ignore
    @Test
    @Title("Post Enforce Save Query on User")
    public void postUserSaveQuery(){
        //BASE_ENDPOINT_INVENTA + SAVED_QUERY
        // String json = "{\"name\":\"Automation_User_SaveQuery_#"+value+"\",\"query\": \"(common.displayName ==\\\"msiraj\\\")\",\"type\": \"USER\", \"description\": \"Automation_DeviceSaveQuery_#"+value+"\"}";
    }

    @Ignore
    @Test
    @Title("Post Enforce Save Query Overwrite")
    public void postSaveQueryOverWrite(){
        //BASE_ENDPOINT_INVENTA + SAVED_QUERY
        // String json = "{\"name\":\"Automation_SaveQuery_OverWrite_#" + value + "\",\"query\": \"(hostName==\\\"inventa-windows\\\")\",\"type\": \"DEVICE\", \"description\": \"Over Write Done Automation_SaveQuery_#" + value + "\"}";

    }

    @Test
    @Title("Get Device Saved Queries")
    public void getDeviceSavedQueries(){
        given().
                spec(requestSpec).
                when().
                get(SAVED_QUERY + "?type=DEVICE&" + SAVED_QUERY_PAGINATION).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get User Saved Queries")
    public void getUserSavedQueries(){
        given().
                spec(requestSpec).
                when().
                get(SAVED_QUERY + "?type=USER&" + SAVED_QUERY_PAGINATION).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get Execute Saved Queries on Devices")
    public void getExecuteDeviceSavedQuery(){
        given().
                spec(requestSpec).
                when().
                get(SAVED_QUERY + "execute/device/" + SAVED_DEVICE_QUERY_NAME).
                then().
                spec(responseSpec);
    }

    @Ignore
    @Test
    @Title("Get Execute Saved Queries on Users")
    public void getExecuteUserSavedQuery(){
        given().
                spec(requestSpec).
                when().
                get(SAVED_QUERY + "execute/user/" + SAVED_USER_QUERY_NAME).
                then().
                spec(responseSpec);
    }


    @Test
    @Title("Get All Saved Queries")
    public void getAllSavedQueries(){
        given().
                spec(requestSpec).
                when().
                get(SAVED_QUERY + "?" + SAVED_QUERY_PAGINATION).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get All Device Saved Queries Without Pagination")
    public void getAllSavedQueriesNoPaginationDevice(){
        given().
                spec(requestSpec).
                when().
                get(SAVED_QUERY + "?unpaged&type=DEVICE").
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get All User Saved Queries Without Pagination")
    public void getAllSavedQueriesNoPaginationUser(){
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

    @Test
    @Title("Get Query Wizard All AD Device Fields")
    public void getAllAdDeviceFields(){
        given().
                spec(requestSpec).
                when().
                get(ALL_DEVICE_FIELDS + AD).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get Query Wizard All AWS Device Fields")
    public void getAllAwsDeviceFields(){
        given().
                spec(requestSpec).
                when().
                get(  ALL_DEVICE_FIELDS + AWS).
                then().
                spec(responseSpec);
    }
    @Test
    @Title("Get Query Wizard All Azure Device Fields")
    public void getAllAzureDeviceFields(){
        given().
                spec(requestSpec).
                when().
                get(ALL_DEVICE_FIELDS + AZURE).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get Query Wizard All Wmic Device Fields")
    public void getAllWmicDeviceFields(){
        given().
                spec(requestSpec).
                when().
                get(ALL_DEVICE_FIELDS + WMIC).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get Query Wizard All AD User Fields")
    public void getAllAdUserFields(){
        given().
                spec(requestSpec).
                when().
                get( ALL_USER_FIELDS + AD).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get Query Wizard All AWS User Fields")
    public void getAllAwsUserFields(){
        given().
                spec(requestSpec).
                when().
                get(ALL_USER_FIELDS + AWS).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get Query Wizard All Azure User Fields")
    public void getAllAzureUserFields(){
        given().
                spec(requestSpec).
                when().
                get(ALL_USER_FIELDS + AZURE).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get Query Wizard Azure Type Fields For Devices")
    public void getAzureTypeDeviceFields(){
        given().
                spec(requestSpec).
                when().
                get(TYPE_DEVICE_FIELDS + AZURE).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get Query Wizard Aws Type Fields For Devices")
    public void getAwsTypeDeviceFields(){
        given().
                spec(requestSpec).
                when().
                get(TYPE_DEVICE_FIELDS + AWS).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get Query Wizard Aws Type Fields For Devices")
    public void getAdTypeDeviceFields(){
        given().
                spec(requestSpec).
                when().
                get(TYPE_DEVICE_FIELDS + AD).
                then().
                spec(responseSpec);
    }




}
