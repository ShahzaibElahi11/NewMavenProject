package models;
//        String json = "{ \"title\":\"AutomationRole_" + value + "\" , \"description\":\"This is Test Role Created By Regression Script \", \"status\":true, \"createdBy\":\"Automation Script\", \"permissionIds\":[\""+ PERMISSION_ID + "\"]}";

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Role {

    @JsonProperty
    private String title;

    @JsonProperty
    private String description;

    @JsonProperty
    private boolean status;

    @JsonProperty
    private String createdBy;

    @JsonProperty
    private List<String> permissionIds;

    public Role(String title, String description, boolean status, String createdBy, List<String> permissionIds) {
        this.title = title;
        this.description = description;
        this.status = status;
        this.createdBy = createdBy;
        this.permissionIds = permissionIds;
    }
}
