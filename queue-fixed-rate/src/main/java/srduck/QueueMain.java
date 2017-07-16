package srduck;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by igor on 16.07.2017.
 */

public class QueueMain {
    public static void main (String... args){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(QueueContext.class);
    }
}
