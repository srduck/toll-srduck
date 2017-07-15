package srduck;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import srduck.services.DataPeekService;
import srduck.services.DataSendService;

/**
 * Created by igor on 15.07.2017.
 */
@Configuration
public class InjectionContext {

    @Bean
    DataPeekService dataPeek(){
        return new DataPeekService();
    }

    @Bean
    DataSendService sendService() {
        return new DataSendService();
    }

}
