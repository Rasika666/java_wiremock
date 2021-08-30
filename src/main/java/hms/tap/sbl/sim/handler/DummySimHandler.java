package hms.tap.sbl.sim.handler;

import hms.tap.sbl.sim.dto.SblRequest;
import hms.tap.sbl.sim.dto.SblResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class DummySimHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(DummySimHandler.class);

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


}
