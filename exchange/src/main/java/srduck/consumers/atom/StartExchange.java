package srduck.consumers.atom;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by main on 11.09.17.
 */
public class StartExchange extends Thread{
    static  public AtomicInteger counter = new AtomicInteger(0);
    public static void main (String... args){
        new Producer().start();
        new Consumer().start();
    }
}
