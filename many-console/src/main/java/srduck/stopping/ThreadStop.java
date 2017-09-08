package srduck.stopping;

/**
 * Created by main on 08.09.17.
 */
public class ThreadStop {
    public static void main(String... args) throws InterruptedException{

        StopedThread stopedThread = new StopedThread();

        System.out.println("stopedThread после создания, и до запуска: " + stopedThread.getState());

        stopedThread.start();

        System.out.println("stopedThread после запуска, и до зовершения: " + stopedThread.getState());

        stopedThread.setNeedStop(true);

        stopedThread.join();

        System.out.println("stopedThread после завершения: " + stopedThread.getState());

        StopedThread stoped2 = new StopedThread();

        System.out.println("stoped2 после создания, и до запуска: " + stoped2.getState());

        stoped2.start();

        System.out.println("stoped2 после запуска, и до зовершения: " + stoped2.getState());

        stoped2.stop();
        stoped2.join();

        System.out.println("stoped2 после завершения: " + stoped2.getState());
    }
}
