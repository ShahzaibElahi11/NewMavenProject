package testcases;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import utils.BaseTest;

import static constants.GeneralControllerConstants.*;
import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_OK;

@RunWith(SerenityRunner.class)
public class GeneralControllerTest extends BaseTest {


    @Test
    @Title("Get Clear Cache")
    public void getClearCache() {
        given().
                spec(requestSpec).
                when().
                get(GENERAL + CLEAR_CACHE).
                then().
                assertThat().
                statusCode(SC_OK);
    }

    @Test
    @Title("Get Load Cache")
    public void getLoadCache() {
        given().
                spec(requestSpec).
                when().
                get(GENERAL + LOAD_CACHE).
                then().
                assertThat().
                statusCode(SC_OK);
    }


}
