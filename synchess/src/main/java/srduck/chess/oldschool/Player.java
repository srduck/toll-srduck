package srduck.chess.oldschool;

import java.util.Random;

/**
 * Created by main on 11.09.17.
 */
public class Player extends Thread {

    private final boolean isWhite;
    private final ChessBoard board;
    private int i = 0;

    public Player(boolean isWhite, ChessBoard board){
        this.isWhite = isWhite;
        this.board = board;
    }

    @Override
    public void run() {

        while (i < Game.gambit.length){
            if (isWhite){
                makeTurn(Game.gambit[i][0]);
                waitContraTurn();
            }
            else {
                waitContraTurn();
                makeTurn(Game.gambit[i][1]);
            }
            i++;
        }
    };

    private void waitContraTurn(){
        String turn = board.waitTurn(!isWhite);
       /* String counterPart = isWhite ? "Черных" : "Белых";
        System.out.println(Thread.currentThread().getName() + ":" + " Получен ход " + counterPart + " => " + turn);*/
    }


    private void makeTurn(String turn){
        /*String figures = isWhite ? "Черные" : "Белые";
        try {
            long millis = (long)(Math.random() * 2000);
            System.out.println(Thread.currentThread().getName() + ": " + figures + " думают => " + millis);
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + ": " +figures + " ходят => " + turn);*/
        board.makeTurn(turn, isWhite);

    }
}
