package srduck.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by main on 08.09.17.
 */
@RestController
public class ManyController {

    Logger log = LoggerFactory.getLogger(ManyController.class);

    private AtomicInteger counter = new AtomicInteger();

    @RequestMapping("/increment")
    public State increment(){
        log.info(Thread.currentThread().getName() + " /increment");
        for (int i = 0; i < 10000; i++){
            counter.incrementAndGet();
        }
        return new State("ok");
    }

    @RequestMapping("/get")
    public int get(){
        log.info(Thread.currentThread().getName() + " /get");
        return counter.get();
    }

    @RequestMapping("/set")
    public int set(@RequestParam(value="value") int value){
        log.info(Thread.currentThread().getName() + " /set");
        counter.set(value);
        return counter.get();
    }

}

