package models.devices;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class DeviceTag {
    @JsonProperty
    private String tag;

    @JsonProperty
    private List<String> deviceIds;

    public DeviceTag(String tag, List<String> deviceIds) {
        this.tag = tag;
        this.deviceIds = deviceIds;
    }
}
