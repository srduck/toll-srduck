package srduck;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;
import srduck.services.ScheduledService;

/**
 * Created by igor on 15.07.2017.
 */
@Configuration
public class SchedulingContext {

    @Bean
    ScheduledService scheduledService(){
        return new ScheduledService();
    }
}
