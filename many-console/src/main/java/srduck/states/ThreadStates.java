package srduck.states;

/**
 * Created by main on 08.09.17.
 */
public class ThreadStates {

    public static void main (String... args) throws InterruptedException{
        ThreadExample threadExample = new ThreadExample();

        System.out.println("после создания, и до запуска: " + threadExample.getState());

        threadExample.start();

        System.out.println("после запуска, и до зовершения: " + threadExample.getState());

        threadExample.join();

        System.out.println("после завершения: " + threadExample.getState());




    }


}
