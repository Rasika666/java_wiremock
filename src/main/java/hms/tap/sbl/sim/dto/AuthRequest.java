
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
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class AuthRequest {
    private String correlationId;
    private String appId;
    private String appName;
    private String spId;
    private String spName;
    private String operator;
    private String subscriberId;
    private Data data;
}
