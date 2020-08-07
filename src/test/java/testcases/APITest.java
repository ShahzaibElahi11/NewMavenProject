package testcases;

import api.Apis;
import io.restassured.response.Response;
import models.BookingDatesPayload;
import models.BookingPayload;
import org.testng.annotations.Test;
import utils.BaseClass;

import java.util.Date;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;


public class APITest extends BaseClass {

    @Test
    public void getBookingReturns200(){

        Response response = given().get("https://restful-booker.herokuapp.com/booking/");

        assertThat(response.getStatusCode(),equalTo(200));
    }
    @Test
    public void getBookingByIdReturns200(){

        Response response = given().get("https://restful-booker.herokuapp.com/booking/1");

        assertThat(response.getStatusCode(),equalTo(200));
    }

    //Advance
    @Test
    public void getBookingReturn200(){

        Response response = Apis.getBookings();
        assertThat(response.getStatusCode(),equalTo(200));
    }

    @Test
    public void getBookingByIdReturn200(){

        Response response = Apis.getBookingById("1");

        assertThat(response.getStatusCode(),equalTo(200));
    }

    @Test
    public void postBookingReturn200(){

        BookingDatesPayload bookingDatesPayload = new BookingDatesPayload(new Date(), new Date());
        BookingPayload bookingPayload = new BookingPayload("Shahzaib", "Elahi", 300, false, bookingDatesPayload, "Nothing" );

        Response response = Apis.postBooking(bookingPayload);
        assertThat(response.getStatusCode(), equalTo(200));
    }



}
