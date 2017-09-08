package srduck.states;

/**
 * Created by main on 08.09.17.
 */
public class ThreadExample extends Thread {

    @Override
    public void run (){
        System.out.println("Это ThreadExample выполнятеся в нити => " + Thread.currentThread().getName());
        int i = 0;
        for(;;){
            i++;
            if (i >= 2_000_000) break;
        }
    }
}
