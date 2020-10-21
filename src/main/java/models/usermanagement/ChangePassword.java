package models.usermanagement;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;

@AllArgsConstructor
@Builder
public class ChangePassword {

    @JsonProperty
    private String userId;

    @JsonProperty
    private String newPassword;

    @JsonProperty
    private String confirmPassword;
}

