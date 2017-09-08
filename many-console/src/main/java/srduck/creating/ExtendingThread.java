package srduck.creating;

/**
 * Created by main on 08.09.17.
 */
public class ExtendingThread extends Thread {

    @Override
    public void run() {
        super.run();
        System.out.println("Это наследник Thread c именем => " + Thread.currentThread().getName());
    }
}
