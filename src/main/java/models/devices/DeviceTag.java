package models.devices;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;


import java.util.List;

@AllArgsConstructor
public  class DeviceTag {

    @JsonProperty
    private String tag;

    @JsonProperty
    private List<String> deviceIds;


    public DeviceTag(List<String> deviceIds) {
        this.deviceIds = deviceIds;
    }

}

