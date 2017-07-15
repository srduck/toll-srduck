package srduck;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by igor on 15.07.2017.
 */
public class SchedMain {
    public static void main(String... arg) throws InterruptedException {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SchedulingContext.class);
    }
}
