package srduck.creating;

/**
 * Created by main on 08.09.17.
 */
public class ImplementingRunable implements Runnable {
    @Override
    public void run() {
        System.out.println("Этот ImplementRunable имплементатор Runable выполняется в потоке => " + Thread.currentThread().getName());
    }
}
