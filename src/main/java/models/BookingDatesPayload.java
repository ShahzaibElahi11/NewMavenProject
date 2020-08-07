package models;


//               "checkin" : "2018-01-01",
//               "checkout" : "2019-01-01"
//    },

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class BookingDatesPayload {

    @JsonProperty
    private Date checkin;

    @JsonProperty
    private Date checkout;

    public BookingDatesPayload(Date checkin, Date checkout) {
        this.checkin = checkin;
        this.checkout = checkout;
    }
}

