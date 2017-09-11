package srduck.consumers.locks;

/**
 * Created by main on 11.09.17.
 */
public class Producer extends Thread {
    @Override
    public void run() {
        while (StartExchange.counter < 5){
            int local = StartExchange.counter++;
            System.out.println(Thread.currentThread().getName() + " : Увеличение счетсчика ->" + (local+1));
            StartExchange.readWriteLock.writeLock().lock();
            try {
                StartExchange.counter = ++local;
            }
            finally {
                StartExchange.readWriteLock.writeLock().unlock();
            }
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }
}
