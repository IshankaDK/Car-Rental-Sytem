package lk.easycar.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ishanka on 6/11/21 at 7:45 PM
 * @since 0.0.1
 */
@Configuration
@Import({JPAConfig.class})
public class WebRootConfig {
}
