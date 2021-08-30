package hms.tap.sbl.sim.router;

import hms.tap.sbl.sim.handler.DummySimHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RequestPredicates.contentType;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class DummySimRoute {

    @Bean
    public RouterFunction<ServerResponse> mobileInfoRequestRouting(DummySimHandler handler) {
        return route(
                POST("/sms/send").and(contentType(MediaType.APPLICATION_JSON)),
                handler::handle);
    }
}
