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

    @JsonProperty
    private String _id;

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getPhone() {
        return phone;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public String getRoleIds() {
        return roleIds;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUserType() {
        return userType;
    }

    public boolean isStatus() {
        return status;
    }

    public String get_id() {
        return _id;
    }

    public AdminUser() { }


    public AdminUser(String emailAddress, String phone, String userName, String password, String passwordConfirm, String roleIds, String firstName, String lastName, String userType, boolean status, String _id) {
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
        this._id = _id;
    }

    //Add Builder Class
    public static class Builder {

        private String emailAddress;
        private String phone;
        private String userName;
        private String password;
        private String passwordConfirm;
        private String roleIds;
        private String firstName;
        private String lastName;
        private String userType;
        private boolean status;
        private String _id;

        public Builder setEmailAddress(String emailAddress) {
            this.emailAddress = emailAddress;
            return this;

        }

        public Builder setPhone(String phone) {
            this.phone = phone;
            return this;

        }

        public Builder setUserName(String userName) {
            this.userName = userName;
            return this;

        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;

        }

        public Builder setPasswordConfirm(String passwordConfirm) {
            this.passwordConfirm = passwordConfirm;
            return this;

        }

        public Builder setRoleIds(String roleIds) {
            this.roleIds = roleIds;
            return this;

        }

        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;

        }

        public Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;

        }

        public Builder setUserType(String userType) {
            this.userType = userType;
            return this;

        }

        public Builder setStatus(boolean status) {
            this.status = status;
            return this;

        }

        public Builder set_id(String _id) {
            this._id = _id;
            return this;

        }

        public AdminUser build() {
            return new AdminUser(emailAddress, phone, userName, password, passwordConfirm, roleIds, firstName, lastName, userType, status, _id);
        }
    }
}
