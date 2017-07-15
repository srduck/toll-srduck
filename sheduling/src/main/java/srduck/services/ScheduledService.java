package srduck.services;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * Created by igor on 15.07.2017.
 */
@Service
public class ScheduledService {

    @Scheduled(fixedRate = 3000)
    public void tick() {
        System.out.println("ScheduledService.tick");
    }
}
