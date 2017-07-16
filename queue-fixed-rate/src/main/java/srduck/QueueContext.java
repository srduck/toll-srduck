package srduck;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import srduck.services.ScheduledQueueService;

/**
 * Created by igor on 16.07.2017.
 */
@Configuration
@EnableScheduling
public class QueueContext {

    @Bean
    public ScheduledQueueService shedService(){
        return new ScheduledQueueService();
    }

    @Bean
    public TaskScheduler poolSheduler(){
        ThreadPoolTaskScheduler sheduler = new ThreadPoolTaskScheduler();
        sheduler.setThreadNamePrefix("poolSheduler");
        sheduler.setPoolSize(20);
        return sheduler;
    }
}
