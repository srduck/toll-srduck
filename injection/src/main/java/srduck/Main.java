package srduck;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by igor on 15.07.2017.
 */
public class Main {
    public static void main (String... args){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationContext.class);
    }
}
