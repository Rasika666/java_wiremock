package hms.tap.sbl.sim.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class SblResponse {
    @JsonProperty("status-description")
    private String statusDescription;
    private String status;


    public static SblResponse getSuccessMessage() {
        SblResponse sblResponse = new SblResponse();
        sblResponse.setStatus("accepted");
        sblResponse.setStatusDescription("Message added to the mt dispatch queue");

        return sblResponse;
    }
}
