package models.systemconfiguration;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;

@AllArgsConstructor
@Builder
public class EmailConfiguration {

    @JsonProperty("mail.enabled")
    private boolean sendEmail;

    @JsonProperty("mail.host")
    private String emailHost;

    @JsonProperty("mail.port")
    private int port;

    @JsonProperty("mail.username")
    private String username;

    @JsonProperty("mail.password")
    private String password;

    @JsonProperty("mail.sender")
    private String senderEmail;

    @JsonProperty("mail.ssl")
    private boolean ssl;

}
