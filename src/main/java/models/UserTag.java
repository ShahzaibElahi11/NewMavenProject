package models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class UserTag {

    @JsonProperty
    private String tag;

    @JsonProperty
    private List<String> userIds;

    public UserTag(String tag, List<String> userIds) {
        this.tag = tag;
        this.userIds = userIds;
    }
}
