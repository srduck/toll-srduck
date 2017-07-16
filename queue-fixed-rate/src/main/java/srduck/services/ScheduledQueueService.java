package srduck.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

/**
 * Created by igor on 16.07.2017.
 */
@Service
public class ScheduledQueueService {

    private static Logger log = LoggerFactory.getLogger(ScheduledQueueService.class);

    BlockingDeque<String> queue = new LinkedBlockingDeque<>(100);
    private int putCount;
    private long previous;

    @Scheduled(fixedDelay = 1000)
    private void take() throws InterruptedException {
        //System.out.println("take trying!");
        log.info("take trying!");
        long current = System.currentTimeMillis();
//        log.info((current - previous) + " ScheduledQueueService.take " + queue.poll(500, TimeUnit.MILLISECONDS));
//        System.out.println( (current - previous) + " ScheduledQueueService.take " + queue.poll(500, TimeUnit.MILLISECONDS));
        log.info( (current - previous) + " ScheduledQueueService.take " + queue.take());
//        System.out.println( (current - previous) + " ScheduledQueueService.take " + queue.take());
        previous = current;

    }

    @Scheduled(fixedDelay = 5000)
    private void put() throws InterruptedException {
        int i = putCount++;
        log.info("ScheduledQueueService.put " + i);
//        System.out.println("ScheduledQueueService.put " + i);
        queue.put("new string => " + i);

    }
}
