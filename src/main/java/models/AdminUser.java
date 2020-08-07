package models;

import com.fasterxml.jackson.annotation.JsonProperty;

//        String json = "{ \"emailAddress\": \"automation"+value+"@gmail.com\", \"phone\":\"1"+value+"\", \"userName\":\"Automation_User_"+value+"\", \"password\":\"password123\", \"passwordConfirm\":\"password123\", \"roleIds\":\""+ ROLE_ID +"\", \"firstName\": \"Automation_Test_User_Name_"+value+" \", \"lastName\": \"User\", \"userType\": \"OPERATOR\"}";
public class AdminUser {

    @JsonProperty("Email Address")
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

    public AdminUser(String emailAddress, String phone, String userName, String password, String passwordConfirm, String roleIds, String firstName, String lastName, String userType) {
        this.emailAddress = emailAddress;
        this.phone = phone;
        this.userName = userName;
        this.password = password;
        this.passwordConfirm = passwordConfirm;
        this.roleIds = roleIds;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userType = userType;
    }
}
