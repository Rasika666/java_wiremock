
/*
 * (C) Copyright 2006-2021 hSenid Mobile Solutions (Pvt) Limited.
 *
 * All Rights Reserved.
 *
 * These materials are unpublished, proprietary, confidential source code of
 * hSenid Mobile Solutions (Pvt) Limited and constitute a TRADE SECRET
 * of hSenid Mobile Solutions (Pvt) Limited.
 *
 * hSenid Mobile Solutions (Pvt) Limited retains all title to and intellectual
 * property rights in these materials.
 *
 */

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
public class Data {

    private String cas;
    @JsonProperty("subscription-full")
    private Double subscriptionAmount;
    @JsonProperty("subscription-frequency")
    private String subscriptionFrequency;
    @JsonProperty("sms-mt")
    private Double smsMt;
    @JsonProperty("sms-mo")
    private Double smsMo;
    @JsonProperty("ussd-mt")
    private Double ussdMt;
    @JsonProperty("ussd-mo")
    private Double ussdMo;

    public boolean isFreeApp() {
        if (subscriptionAmount == null || subscriptionFrequency == null)
            return true;
        else
            return false;
    }

    public boolean isExtraCharging() {
        if (smsMt == null && cas == null && smsMo == null && ussdMt == null && ussdMo == null)
            return false;
        else
            return true;

    }

}
