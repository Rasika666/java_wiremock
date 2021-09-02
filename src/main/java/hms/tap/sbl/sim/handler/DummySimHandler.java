package hms.tap.sbl.sim.handler;

import hms.tap.sbl.sim.config.AppPropertyConfig;
import hms.tap.sbl.sim.dto.AuthRequest;
import hms.tap.sbl.sim.dto.AuthResponse;
import hms.tap.sbl.sim.dto.SblRequest;
import hms.tap.sbl.sim.dto.SblResponse;
import hms.tap.sbl.sim.util.PropertyLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.*;

@Component
public class DummySimHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(DummySimHandler.class);


    private Properties errorMappings = PropertyLoader.load("error.properties");

    @Autowired
    private AppPropertyConfig appPropertyConfig;

    public Mono<ServerResponse> handle (final ServerRequest request) {

        return request.bodyToMono(SblRequest.class)
                .doOnSuccess(result -> System.out.println("proceed " +  result))
                .doOnError(err -> System.out.println("Error occurred while deserializing"+ err))
                .map(sblRequest -> SblResponse.getSuccessMessage())
                .flatMap(sblResponse -> ServerResponse
                        .ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(Mono.just(sblResponse), SblResponse.class)
                )
                .doOnError(err -> System.out.println("Error occurred"+ err));
    }

    public Mono<ServerResponse> blinkHandle(ServerRequest request) {
        String tid = request.queryParam("tid").get();

        String s = getErrCodeMap().get(appPropertyConfig.getActiveErrorCode());

        return ServerResponse.ok().bodyValue(tid + "::" + String.valueOf(appPropertyConfig.getActiveErrorCode()) + "::" + s);
    }

    private Map<Integer, String> getErrCodeMap() {

        Map<Integer, String> errCodeMap = new HashMap<>();
        Set<String> banglalinkErrorCodeKeys = errorMappings.stringPropertyNames();
        for (String banglalinkErrorCodeKey : banglalinkErrorCodeKeys) {
            errCodeMap.put(Integer.valueOf(banglalinkErrorCodeKey), errorMappings.getProperty(banglalinkErrorCodeKey, "ERROR_RESP_FROM_IN"));
        }

        return errCodeMap;
    }

    public Mono<ServerResponse> yReqHandle(ServerRequest request) {
        return request.bodyToMono(AuthRequest.class)
                .map(r -> AuthResponse.getSuccessInstance(r.getCorrelationId(), r.getAppId(), r.getSubscriberId()))
                .flatMap(authResponse -> ServerResponse.ok().bodyValue(authResponse));

    }


}
