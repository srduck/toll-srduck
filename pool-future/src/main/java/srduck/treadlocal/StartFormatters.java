package srduck.treadlocal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by main on 12.09.17.
 */
public class  StartFormatters {

    public static void main (String... args){
        ExecutorService pool = Executors.newFixedThreadPool(3);
        Formatter formatter = new Formatter();
        for (int i= 0; i < 10; i++){
            pool.submit(formatter);
        }
        pool.shutdown();

    }
}
