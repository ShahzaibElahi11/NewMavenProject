package models.systemconfiguration;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;

@AllArgsConstructor
@Builder
public class GuiConfiguration {

    @JsonProperty("gui.refreshRate")
    private int refreshRate;

    @JsonProperty("gui.displayPerPage")
    private int displayPerPage;

    @JsonProperty("gui.sessionIdleTimeout")
    private int sessionIdleTimeout;

    @JsonProperty("gui.enableSessionTimeout")
    private boolean enableSessionTimeout;

}
