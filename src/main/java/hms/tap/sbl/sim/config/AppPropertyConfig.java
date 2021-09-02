package hms.tap.sbl.sim.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
public class AppPropertyConfig {

    @Value("${active.error}")
    private Integer activeErrorCode;
}
