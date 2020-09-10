package models.users;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.List;
@AllArgsConstructor
public class UserTag {

    @JsonProperty
    private String tag;

    @JsonProperty
    private List<String> userIds;


    //for Delete Method
    public UserTag(List<String> userIds) {
        this.userIds = userIds;
    }
}
