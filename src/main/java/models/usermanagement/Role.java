package models.usermanagement;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
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

    @JsonProperty
    private String _id;

    //For Post Method
    public Role(String title, String description, boolean status, String createdBy, List<String> permissionIds) {
        this.title = title;
        this.description = description;
        this.status = status;
        this.createdBy = createdBy;
        this.permissionIds = permissionIds;
    }

}
