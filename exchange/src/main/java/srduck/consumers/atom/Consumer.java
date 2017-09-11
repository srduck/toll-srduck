package srduck.consumers.atom;

/**
 * Created by main on 11.09.17.
 */
public class Consumer extends Thread{


    @Override
    public void run() {
        int local = StartExchange.counter.get();
        while(StartExchange.counter.get() < 5){
            if(local != StartExchange.counter.get())
                System.out.println(Thread.currentThread().getName() + " : счетчик изменился -> " + StartExchange.counter.get());
        }
    }
}
