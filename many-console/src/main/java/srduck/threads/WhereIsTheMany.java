package srduck.threads;

/**
 * Created by main on 07.09.17.
 */
public class WhereIsTheMany {

    static int account = 0;
    static int transNum = 100000000;
    static int threadNum = 20;

    public static void main (String... args) throws InterruptedException {

        Runnable transaction = new Runnable(){
            @Override
            public void run(){
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
                for (int i = 0; i < transNum; i++){
                    account++;
                }
            }
        };

        Thread[] threads = new Thread[threadNum];
        for (int i = 0; i < threadNum; i++){
            threads[i] = new Thread(transaction);
            threads[i].start();
        }

        for (int i = 0; i < threadNum; i++){
            Thread thread = threads[i];
            thread.join();
        }

        System.out.println("Денег " + account + ", а должно быть: " + transNum*threadNum);
        if ((transNum*threadNum-account) > 0) {
            System.out.println("Где мои: " + (transNum * threadNum - account));
        }
    }
}
