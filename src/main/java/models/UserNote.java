package models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserNote {

    @JsonProperty
    private String note;

    @JsonProperty
    private String userId;

    public UserNote(String note, String userId) {
        this.note = note;
        this.userId = userId;
    }
}
