package srduck.chess.best;

import java.util.concurrent.BlockingDeque;

/**
 * Created by main on 11.09.17.
 */
public class Player extends Thread {

    private final boolean isWhite;
    private final BlockingDeque<String> outDeque;
    private final BlockingDeque<String> inDeque;
    private int iterTurns = 0;

    public Player(BlockingDeque<String> outDeque, BlockingDeque<String> inDeque, String firstTurn) throws InterruptedException{
        this.outDeque = outDeque;
        this.inDeque = inDeque;
        isWhite = true;
        outDeque.put(firstTurn);
        iterTurns++;
    }

    public Player(BlockingDeque<String> outDeque, BlockingDeque<String> inDeque){
        this.inDeque = inDeque;
        this.outDeque = outDeque;
        isWhite = false;
    }

    @Override
    public void run() {
        while(iterTurns < Game.gambit.length){
            try {
                inDeque.take();
                String nextTurn = isWhite ? Game.gambit[iterTurns][0] : Game.gambit[iterTurns][1];
                outDeque.put(nextTurn);
                iterTurns++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
