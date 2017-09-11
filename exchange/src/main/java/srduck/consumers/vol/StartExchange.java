package srduck.consumers.vol;

/**
 * Created by main on 11.09.17.
 */
public class StartExchange extends Thread{
    static volatile public int counter = 0;
    public static void main (String... args){
        new Producer().start();
        new Consumer().start();
    }
}
