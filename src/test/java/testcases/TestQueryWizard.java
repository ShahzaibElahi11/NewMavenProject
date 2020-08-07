package testcases;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BaseClass;

import java.io.IOException;
import java.nio.charset.Charset;

import static org.testng.Assert.assertEquals;

public class TestQueryWizard extends BaseClass {

    public static final String QUERY_ENDPOINT = "/query/devices/?query=";
    public static final String EQUAL_OPERATOR = "(type==%22VIRTUAL_MACHINE%22)";
    public static final String NOT_EQUAL_OPERATOR = "(not%20type==%22VIRTUAL_MACHINE%22)";
    public static final String EXIST_OPERATOR_TRUE = "(adapters.adapter_azure==exists(true))";
    public static final String EXIST_OPERATOR_FALSE = "(adapters.adapter_azure==exists(false))";
    public static final String START_WITH_OPERATOR = "(common.ipAddress==starts(%22172.%22))";
    public static final String END_WITH_OPERATOR = "(common.ipAddress==ends(%22.7%22))";
    public static final String IN_OPERATOR = "(common.hostName==in(%22DESKTOP-I8P4H1D%20,%20Inventa-Zone1-nsg%22))";
    public static final String CONTAIN_OPERATOR = "(common.ipAddress==contains(%2216.0%22))";
    public static final String AND_OPERATOR = "(type==%22VIRTUAL_MACHINE%22)and(common.hostName==%22App1Web2%22)";
    public static final String OR_OPERATOR = "(not%20type==%22VIRTUAL_MACHINE%22)or(common.hostName==%22App1Web2%22)";
    public static final String DETAIL_QUERY = "(adapters.adapter_ad.dNSHostName==%22DESKTOP-7DN8B20.inventa.local%22)";
    public static final String STATEMENT_QUERY = "(((adapters.adapter_azure.location%20==%20starts(%22east%22))and" +
            "(adapters.adapter_azure.Type%20==%20%22Storage%20Account%22))and((adapters.adapter_azure.name%20==%20%22inventargdiag%22)))";

    public static final String SAVED_QUERY = "/saved-query/";
    public static final String SAVED_QUERY_PAGINATION = "&page=0&size=100";

    @Test
    public void GetEqualOperator() throws IOException {

        HttpGet get = new HttpGet(BASE_ENDPOINT + QUERY_ENDPOINT + EQUAL_OPERATOR);
        get.setHeader("Authorization", "Bearer " + token);
        response = client.execute(get);
        int actualStatus = response.getStatusLine().getStatusCode();
        assertEquals(actualStatus, 200);
    }

    @Test
    public void GetNotEqualOperator() throws IOException {

        HttpGet get = new HttpGet(BASE_ENDPOINT + QUERY_ENDPOINT + NOT_EQUAL_OPERATOR);
        get.setHeader("Authorization", "Bearer " + token);
        response = client.execute(get);
        int actualStatus = response.getStatusLine().getStatusCode();
        assertEquals(actualStatus, 200);
    }

    @Test
    public void GetExistsOperatorTrue() throws IOException {

        HttpGet get = new HttpGet(BASE_ENDPOINT + QUERY_ENDPOINT + EXIST_OPERATOR_TRUE);
        get.setHeader("Authorization", "Bearer " + token);
        response = client.execute(get);
        int actualStatus = response.getStatusLine().getStatusCode();
        assertEquals(actualStatus, 200);
    }

    @Test
    public void GetExistsOperatorFalse() throws IOException {

        HttpGet get = new HttpGet(BASE_ENDPOINT + QUERY_ENDPOINT + EXIST_OPERATOR_FALSE);
        get.setHeader("Authorization", "Bearer " + token);
        response = client.execute(get);
        int actualStatus = response.getStatusLine().getStatusCode();
        assertEquals(actualStatus, 200);
    }
    @Test
    public void GetStartWithOperator() throws IOException {

        HttpGet get = new HttpGet(BASE_ENDPOINT + QUERY_ENDPOINT + START_WITH_OPERATOR);
        get.setHeader("Authorization", "Bearer " + token);
        response = client.execute(get);
        int actualStatus = response.getStatusLine().getStatusCode();
        assertEquals(actualStatus, 200);
    }

    @Test
    public void GetEndWithOperator() throws IOException {

        HttpGet get = new HttpGet(BASE_ENDPOINT + QUERY_ENDPOINT + END_WITH_OPERATOR);
        get.setHeader("Authorization", "Bearer " + token);
        response = client.execute(get);
        int actualStatus = response.getStatusLine().getStatusCode();
        assertEquals(actualStatus, 200);
    }
    @Test
    public void GetInOperator() throws IOException {

        HttpGet get = new HttpGet(BASE_ENDPOINT + QUERY_ENDPOINT + IN_OPERATOR);
        get.setHeader("Authorization", "Bearer " + token);
        response = client.execute(get);
        int actualStatus = response.getStatusLine().getStatusCode();
        assertEquals(actualStatus, 200);
    }

    @Test
    public void GetContainOperator() throws IOException {

        HttpGet get = new HttpGet(BASE_ENDPOINT + QUERY_ENDPOINT + CONTAIN_OPERATOR);
        get.setHeader("Authorization", "Bearer " + token);
        response = client.execute(get);
        int actualStatus = response.getStatusLine().getStatusCode();
        assertEquals(actualStatus, 200);
    }
    @Test
    public void GetANDOperator() throws IOException {

        HttpGet get = new HttpGet(BASE_ENDPOINT + QUERY_ENDPOINT + AND_OPERATOR);
        get.setHeader("Authorization", "Bearer " + token);
        response = client.execute(get);
        int actualStatus = response.getStatusLine().getStatusCode();
        assertEquals(actualStatus, 200);
    }

    @Test
    public void GetOROperator() throws IOException {


        HttpGet get = new HttpGet(BASE_ENDPOINT + QUERY_ENDPOINT + OR_OPERATOR);
        get.setHeader("Authorization", "Bearer " + token);
        response = client.execute(get);
        int actualStatus = response.getStatusLine().getStatusCode();
        assertEquals(actualStatus, 200);
    }

    @Test
    public void GetAdapterDetailsQuery() throws IOException {


        HttpGet get = new HttpGet(BASE_ENDPOINT + QUERY_ENDPOINT + DETAIL_QUERY);
        get.setHeader("Authorization", "Bearer " + token);
        response = client.execute(get);
        int actualStatus = response.getStatusLine().getStatusCode();
        assertEquals(actualStatus, 200);
    }

    @Test
    public void GetStatementQuery() throws IOException {


        HttpGet get = new HttpGet(BASE_ENDPOINT + QUERY_ENDPOINT + STATEMENT_QUERY);
        get.setHeader("Authorization", "Bearer " + token);
        response = client.execute(get);
        int actualStatus = response.getStatusLine().getStatusCode();
        assertEquals(actualStatus, 200);
    }

    /**
     * Saved Query Controller
     *
     */
    @Test
    public void PostDeviceSaveQuery()throws IOException {

        HttpPost request = new HttpPost(BASE_ENDPOINT + SAVED_QUERY);
        String auth = new String();
        byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("ISO-8859-1")));
        String authHeader = "Basic " + new String(encodedAuth);

        request.setHeader(HttpHeaders.AUTHORIZATION, authHeader);
        request.setHeader("Authorization", "Bearer " + token);

        String json = "{\"name\":\"Automation_Device_SaveQuery_#"+value+"\",\"query\": \"(hostName==\\\"inventa-windows\\\")\",\"type\": \"DEVICE\", \"description\": \"Automation_Device_SaveQuery_#"+value+"\"}";
        request.setEntity(new StringEntity(json, ContentType.APPLICATION_JSON));
        // Send
        response = client.execute(request);
        int actualStatusCode = response.getStatusLine().getStatusCode();
        Assert.assertEquals(actualStatusCode, 200);
    }

    @Test
    public void PostUserSaveQuery()throws IOException {

        HttpPost request = new HttpPost(BASE_ENDPOINT + SAVED_QUERY);
        String auth = new String();
        byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("ISO-8859-1")));
        String authHeader = "Basic " + new String(encodedAuth);

        request.setHeader(HttpHeaders.AUTHORIZATION, authHeader);
        request.setHeader("Authorization", "Bearer " + token);

        String json = "{\"name\":\"Automation_User_SaveQuery_#"+value+"\",\"query\": \"(common.displayName ==\\\"msiraj\\\")\",\"type\": \"USER\", \"description\": \"Automation_DeviceSaveQuery_#"+value+"\"}";

        request.setEntity(new StringEntity(json, ContentType.APPLICATION_JSON));
        // Send
        response = client.execute(request);
        int actualStatusCode = response.getStatusLine().getStatusCode();
        Assert.assertEquals(actualStatusCode, 200);
    }

    @Test
    public void PostSaveQueryOverWrite()throws IOException {

        HttpPost request = new HttpPost(BASE_ENDPOINT + SAVED_QUERY);
        String auth = new String();
        byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("ISO-8859-1")));
        String authHeader = "Basic " + new String(encodedAuth);

        request.setHeader(HttpHeaders.AUTHORIZATION, authHeader);
        request.setHeader("Authorization", "Bearer " + token);

        String json = "{\"name\":\"Automation_SaveQuery_OverWrite_#" + value + "\",\"query\": \"(hostName==\\\"inventa-windows\\\")\",\"type\": \"DEVICE\", \"description\": \"Over Write Done Automation_SaveQuery_#" + value + "\"}";
        request.setEntity(new StringEntity(json, ContentType.APPLICATION_JSON));
        // Send
        response = client.execute(request);
        int actualStatusCode = response.getStatusLine().getStatusCode();
        Assert.assertEquals(actualStatusCode, 200);

    }

    @Test
    public void GetDeviceSavedQueries() throws IOException {

        HttpGet get = new HttpGet(BASE_ENDPOINT + SAVED_QUERY + "?type=DEVICE" +SAVED_QUERY_PAGINATION);
        get.setHeader("Authorization", "Bearer " + token);
        response = client.execute(get);
        int actualStatus = response.getStatusLine().getStatusCode();
        assertEquals(actualStatus, 200);
    }

    @Test
    public void GetUserSavedQueries() throws IOException {

        HttpGet get = new HttpGet(BASE_ENDPOINT + SAVED_QUERY + "?type=USER" + SAVED_QUERY_PAGINATION);
        get.setHeader("Authorization", "Bearer " + token);
        response = client.execute(get);
        int actualStatus = response.getStatusLine().getStatusCode();
        assertEquals(actualStatus, 200);
    }

    @Test
    public void GetExecuteDeviceSavedQuery() throws IOException {

        HttpGet get = new HttpGet(BASE_ENDPOINT + SAVED_QUERY + "execute/device/" + SAVED_DEVICE_QUERY_NAME);
        get.setHeader("Authorization", "Bearer " + token);
        response = client.execute(get);
        int actualStatus = response.getStatusLine().getStatusCode();
        assertEquals(actualStatus, 200);
    }

    @Test
    public void GetExecuteUserSavedQuery() throws IOException {

        HttpGet get = new HttpGet(BASE_ENDPOINT + SAVED_QUERY + "execute/user/" + SAVED_USER_QUERY_NAME);
        get.setHeader("Authorization", "Bearer " + token);
        response = client.execute(get);
        int actualStatus = response.getStatusLine().getStatusCode();
        assertEquals(actualStatus, 200);
    }


    @Test
    public void GetAllSavedQueries() throws IOException {

        HttpGet get = new HttpGet(BASE_ENDPOINT + SAVED_QUERY + "?" +SAVED_QUERY_PAGINATION);
        get.setHeader("Authorization", "Bearer " + token);
        response = client.execute(get);
        int actualStatus = response.getStatusLine().getStatusCode();
        assertEquals(actualStatus, 200);
    }

    @Test
    public void GetAllSavedQueriesNoPaginationDevice() throws IOException {

        HttpGet get = new HttpGet(BASE_ENDPOINT + SAVED_QUERY + "unpaged?type=DEVICE");
        get.setHeader("Authorization", "Bearer " + token);
        response = client.execute(get);
        int actualStatus = response.getStatusLine().getStatusCode();
        assertEquals(actualStatus, 200);
    }

    @Test
    public void GetAllSavedQueriesNoPaginationUser() throws IOException {

        HttpGet get = new HttpGet(BASE_ENDPOINT + SAVED_QUERY + "unpaged?type=USER");
        get.setHeader("Authorization", "Bearer " + token);
        response = client.execute(get);
        int actualStatus = response.getStatusLine().getStatusCode();
        assertEquals(actualStatus, 200);
    }


    /**
     * Remaining
     * Patch- Rename User Saved Query	http://inventaserver:9092/saved-query/rename/?oldName=testuser&newName=test_user&type=USER
     * Patch- Rename Device Saved Query	http://inventaserver:9092/saved-query/rename/?oldName=SaveQuery14&newName=SaveQuery143&type=DEVICE
     */
    /**
     * new
     */

}
