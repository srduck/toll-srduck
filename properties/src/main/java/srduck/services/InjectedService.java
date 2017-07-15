package srduck.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * Created by igor on 15.07.2017.
 */
@Service
public class InjectedService {

    @Value("${int.prop}")
    private Integer intProp;

    @Value("${bool.prop}")
    private Boolean boolProp;

    private int count;

    @PostConstruct
    private void init(){
        System.out.println("initProp = " + intProp);
        System.out.println("boolProp = " + boolProp);
    }



    @Scheduled(cron = "${cron.prop}")
    private void tick() {
        System.out.println("ScheduledService.tick " + count++);
    }
}
