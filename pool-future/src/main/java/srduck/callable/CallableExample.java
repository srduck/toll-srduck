package srduck.callable;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by main on 12.09.17.
 */
public class CallableExample {

    public static class WordLengthCallable implements Callable<Integer> {
        private String word;

        public WordLengthCallable(String word){
            this.word = word;
        }

        @Override
        public Integer call() throws InterruptedException {
            System.out.println(Thread.currentThread().getName() + ": длина " + word + " -> "  + word.length());
            Thread.sleep(3000);
            return word.length();
        }
    }

    public static void main (String... args) throws Exception{
        ExecutorService pool = Executors.newFixedThreadPool(3);
        Set<Future<Integer>> set = new HashSet<Future<Integer>>();
        for(String word : args){
            Callable<Integer> callable = new WordLengthCallable(word);
            Future<Integer> future = pool.submit(callable);
            set.add(future);
        }
        int sum = 0;
        for (Future<Integer> future : set){
            sum += future.get();
        }
        System.out.printf("Сумма всех слов: %s%n", sum);
        System.exit(sum);
    }

}
