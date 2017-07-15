package srduck;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;
import srduck.services.InjectedService;

/**
 * Created by igor on 15.07.2017.
 */
@Configuration
@PropertySource("classpath:/app.properties")
@EnableScheduling
public class PropContext {

    @Bean
    public InjectedService injectedService(){
        return new InjectedService();
    }
}
