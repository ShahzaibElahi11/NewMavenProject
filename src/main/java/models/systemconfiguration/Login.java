package models.systemconfiguration;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Login {

    @JsonProperty
    private String username;

    @JsonProperty
    private String password;

}
