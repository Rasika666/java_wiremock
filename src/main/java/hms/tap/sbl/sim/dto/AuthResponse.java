
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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AuthResponse {
    private String statusCode;
    private String statusDescription;
    private String correlationId;
    private String appId;
    private String subscriberId;
    private String operator;


    public static AuthResponse getSuccessInstance(String correlationId, String appId, String subscriberId) {
        return new AuthResponse("S1000", "Success", correlationId, appId, subscriberId, "robi");
    }

}
