package api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utils.BaseClass;

import static io.restassured.RestAssured.given;

public class QueryWizardApis extends BaseClass {


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


    public static Response getEqualOperator() {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer" + token)
                .get(BASE_ENDPOINT_INVENTA + QUERY_ENDPOINT + EQUAL_OPERATOR);
    }

    public static Response getNotEqualOperator() {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer" + token)
                .get(BASE_ENDPOINT_INVENTA + QUERY_ENDPOINT + NOT_EQUAL_OPERATOR);
    }

    public static Response getExistsOperatorTrue() {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer" + token)
                .get(BASE_ENDPOINT_INVENTA + QUERY_ENDPOINT + EXIST_OPERATOR_TRUE);
    }

    public static Response getExistsOperatorFalse() {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer" + token)
                .get(BASE_ENDPOINT_INVENTA + QUERY_ENDPOINT + EXIST_OPERATOR_FALSE);
    }

    public static Response getStartWithOperator() {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer" + token)
                .get(BASE_ENDPOINT_INVENTA + QUERY_ENDPOINT + START_WITH_OPERATOR);
    }


    public static Response getEndWithOperator() {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer" + token)
                .get(BASE_ENDPOINT_INVENTA + QUERY_ENDPOINT + END_WITH_OPERATOR);
    }


    public static Response getInOperator() {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer" + token)
                .get(BASE_ENDPOINT_INVENTA + QUERY_ENDPOINT + IN_OPERATOR);
    }

    public static Response getContainOperator() {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer" + token)
                .get(BASE_ENDPOINT_INVENTA + QUERY_ENDPOINT + CONTAIN_OPERATOR);
    }

    public static Response getANDOperator() {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer" + token)
                .get(BASE_ENDPOINT_INVENTA + QUERY_ENDPOINT + AND_OPERATOR);
    }

    public static Response getOROperator() {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer" + token)
                .get(BASE_ENDPOINT_INVENTA + QUERY_ENDPOINT + OR_OPERATOR);
    }


    public static Response getAdapterDetailsQuery() {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer" + token)
                .get(BASE_ENDPOINT_INVENTA + QUERY_ENDPOINT + DETAIL_QUERY);
    }

    public static Response getStatementQuery() {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer" + token)
                .get(BASE_ENDPOINT_INVENTA + QUERY_ENDPOINT + STATEMENT_QUERY);
    }


    public static Response getDeviceSavedQueries() {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer" + token)
                .get(BASE_ENDPOINT_INVENTA + SAVED_QUERY + "?type=DEVICE&" + SAVED_QUERY_PAGINATION);
    }


    public static Response getUserSavedQueries() {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer" + token)
                .get(BASE_ENDPOINT_INVENTA + SAVED_QUERY + "?type=USER&" + SAVED_QUERY_PAGINATION);
    }


    public static Response getExecuteDeviceSavedQuery() {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer" + token)
                .get(BASE_ENDPOINT_INVENTA + SAVED_QUERY + "execute/device/" + SAVED_DEVICE_QUERY_NAME);
    }


    public static Response getExecuteUserSavedQuery() {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer" + token)
                .get(BASE_ENDPOINT_INVENTA + SAVED_QUERY + "execute/user/" + SAVED_USER_QUERY_NAME);
    }


    public static Response getAllSavedQueries() {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer" + token)
                .get(BASE_ENDPOINT_INVENTA + SAVED_QUERY + "?" +SAVED_QUERY_PAGINATION);
    }

    public static Response getAllSavedQueriesNoPaginationDevice() {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer" + token)
                .get(BASE_ENDPOINT_INVENTA + SAVED_QUERY + "unpaged?type=DEVICE");
    }

    public static Response getAllSavedQueriesNoPaginationUser() {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer" + token)
                .get(BASE_ENDPOINT_INVENTA + SAVED_QUERY + "?" +SAVED_QUERY_PAGINATION);
    }

}
