package srduck.consumers.locks;

/**
 * Created by main on 11.09.17.
 */
public class Consumer extends Thread{


    @Override
    public void run() {
        int local = StartExchange.counter;
        while(StartExchange.counter < 5){
            StartExchange.readWriteLock.readLock().lock();
            try {
                if (local != StartExchange.counter)
                    System.out.println(Thread.currentThread().getName() + " : счетчик изменился -> " + StartExchange.counter);
            }
            finally {
                StartExchange.readWriteLock.readLock().unlock();
            }
        }
    }
}
