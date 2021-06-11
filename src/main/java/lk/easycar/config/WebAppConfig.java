package lk.easycar.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author ishanka on 6/11/21 at 7:44 PM
 * @since 0.0.1
 */
@Configuration
@ComponentScan(basePackages = "lk.easycar")
@EnableWebMvc
public class WebAppConfig {
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
