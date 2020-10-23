package models.devices;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DeviceNotes {

    @JsonProperty
    private String note;

//    @JsonProperty
//    private String deviceId;

    public DeviceNotes(String note) {
        this.note = note;
    }
}
