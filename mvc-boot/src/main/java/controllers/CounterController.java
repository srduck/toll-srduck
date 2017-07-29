package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by igor on 29.07.2017.
 */
@RestController
public class CounterController {
    private static final String template = "It's yours, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/counter")
    public CurrentState greeting(@RequestParam(value="name", defaultValue = "World") String name){
        return new CurrentState(counter.incrementAndGet(), String.format(template, name) );
    }

    @RequestMapping("/count")
    public Long getCount(){
        return counter.incrementAndGet();
    }

    @RequestMapping("/coords")
    public Response getCoords(@RequestParam(value="location") String location){
        System.out.println(location);
        return new Response(true, "OK");
    }
}
