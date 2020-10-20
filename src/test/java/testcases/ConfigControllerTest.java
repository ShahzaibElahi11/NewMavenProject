package testcases;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import utils.BaseTest;

import static constants.Constants.*;
import static io.restassured.RestAssured.given;

@RunWith(SerenityRunner.class)
public class ConfigControllerTest extends BaseTest {


    @Test
    @Title("Get Email Setting Configuration")
    public void getEmailConfiguration() {

        given().
                spec(requestSpec).
                when().
                get(CONFIG_ENDPOINT + CONFIG_TYPE + MAIL).
                then().
                spec(responseSpec);

    }

    @Test
    @Title("Get GUI Setting Configuration")
    public void getGuiConfiguration() {

        given().
                spec(requestSpec).
                when().
                get(CONFIG_ENDPOINT + CONFIG_TYPE + GUI).
                then().
                spec(responseSpec);

    }

    @Test
    @Title("Get Discovery Setting Configuration")
    public void getDiscoveryConfiguration() {

        given().
                spec(requestSpec).
                when().
                get(CONFIG_ENDPOINT + CONFIG_TYPE + DISCOVERY).
                then().
                spec(responseSpec);

    }

}
