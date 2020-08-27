package models.users;

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
    //for delete
    public UserTag(List<String> userIds) {
        this.userIds = userIds;
    }
}
