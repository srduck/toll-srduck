package srduck.consumers.atom;

/**
 * Created by main on 11.09.17.
 */
public class Producer extends Thread {
    @Override
    public void run() {
        while (StartExchange.counter.get() < 5){
            int local = StartExchange.counter.get();
            System.out.println(Thread.currentThread().getName() + " : Увеличение счетсчика ->" + (local+1));
            StartExchange.counter.incrementAndGet();
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }
}
