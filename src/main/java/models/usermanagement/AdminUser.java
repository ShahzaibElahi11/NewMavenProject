package models.usermanagement;

import com.fasterxml.jackson.annotation.JsonProperty;

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


    public AdminUser(String emailAddress, String phone, String userName, String password, String passwordConfirm, String roleIds, String firstName, String lastName, String userType, boolean status) {
        this.emailAddress = emailAddress;
        this.phone = phone;
        this.userName = userName;
        this.password = password;
        this.passwordConfirm = passwordConfirm;
        this.roleIds = roleIds;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userType = userType;
        this.status = status;
    }
}
