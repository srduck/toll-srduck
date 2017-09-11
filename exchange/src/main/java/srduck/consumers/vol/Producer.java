package srduck.consumers.vol;

/**
 * Created by main on 11.09.17.
 */
public class Producer extends Thread {
    @Override
    public void run() {
        while (StartExchange.counter < 5){
            int local = StartExchange.counter++;
            System.out.println(Thread.currentThread().getName() + " : Увеличение счетсчика ->" + (local+1));
            StartExchange.counter = ++local;
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }
}
