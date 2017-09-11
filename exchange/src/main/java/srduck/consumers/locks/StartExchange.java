package srduck.consumers.locks;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by main on 11.09.17.
 */
public class StartExchange extends Thread{
    static final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    static  public int counter = 0;
    public static void main (String... args){
        new Producer().start();
        new Consumer().start();
        new Consumer().start();
        new Consumer().start();
        new Consumer().start();
    }
}
