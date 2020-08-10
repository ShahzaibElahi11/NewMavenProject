package models.policyroutine;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EnforcePolicyOnDevice {

    @JsonProperty
    private String hostName;

    public EnforcePolicyOnDevice(String hostName) {
        this.hostName = hostName;
    }
}
