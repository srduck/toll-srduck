package srduck.creating;

/**
 * Created by main on 08.09.17.
 */
public class TwoWaysCreating {

    public static void main (String... args) throws InterruptedException {

        ExtendingThread extendingThread = new ExtendingThread();

        System.out.println("Это main, который выполняется в нити " + Thread.currentThread().getName());

        extendingThread.start();

        extendingThread.join();

        extendingThread.run();

        //Exception - нельзя вызывать если завершен
        //extendingThread.start();



        ImplementingRunable implementing = new ImplementingRunable();

        //Выполняется в потоке main; run - просто метод объекта
        implementing.run();

        new Thread(implementing).start();


    }
}
