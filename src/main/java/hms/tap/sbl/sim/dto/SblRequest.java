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
public class SblRequest {
    @JsonProperty("sender-address")
    private String senderAddress;
    @JsonProperty("correlation-id")
    private String correlationId;
    @JsonProperty("recipient-address")
    private String recipientAddress;
    @JsonProperty("encoding")
    private String encoding;
    @JsonProperty("message")
    private String message;
    @JsonProperty("operator")
    private String operator;
    @JsonProperty("sender-shortcode")
    private String senderShortcode;

}
