package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import domain.Country;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by igor on 29.07.2017.
 */
@RestController
public class CounterController {

    @Autowired
    RestTemplate restTemplate;

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

        if (location.split(",").length != 2){
            return new Response(false, "There isn't location");
        }else {
            return new Response(true, "OK");
        }

    }

    @RequestMapping("/relay")
    public Country relay(){
        Country country = restTemplate.getForObject("http://services.groupkt.com/country/get/iso2code/RU", Country.class);
        return country;
    }
}
