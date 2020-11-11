package models.users;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UserNote {

    @JsonProperty
    private String note;

//    @JsonProperty
//    private String userId;

}
