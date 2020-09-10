package models.usermanagement;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;

@AllArgsConstructor
@Builder
public class AdminUser {

    @JsonProperty
    private String emailAddress;

    @JsonProperty
    private String phone;

    @JsonProperty
    private String userName;

    @JsonProperty
    private String password;

    @JsonProperty
    private String passwordConfirm;

    @JsonProperty
    private String roleIds;

    @JsonProperty
    private String firstName;

    @JsonProperty
    private String lastName;

    @JsonProperty
    private String userType;

    @JsonProperty
    private boolean status;

    @JsonProperty
    private String _id;



}
