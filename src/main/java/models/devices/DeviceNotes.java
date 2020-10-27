package models.devices;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DeviceNotes {

    @JsonProperty
    private String note;

}
