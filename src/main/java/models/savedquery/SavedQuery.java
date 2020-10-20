package models.savedquery;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class SavedQuery {

    @JsonProperty
    private String name;

    @JsonProperty
    private String description;

    @JsonProperty
    private String query;

    @JsonProperty
    private String type;

    @JsonProperty
    private List<String> tags;

}
