package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by igor on 28.07.2017.
 */
@SpringBootApplication
@ComponentScan({"hello","services"})
public class Application {
    public static void main (String... args){
        SpringApplication.run(Application.class);
    }
}
