package srduck.chess.oldschool;

/**
 * Created by main on 11.09.17.
 */
public class ChessBoard {

    private volatile boolean bNextTurn = true; //Чей ход? (true - белые)
    private String sLastTurn; //последний ход

    public synchronized void makeTurn(String turnString, boolean color){
        while (bNextTurn != color){
            try {
                wait();
            } catch (InterruptedException e) {}
        }
        System.out.println(Thread.currentThread().getName() + " на доске передвинуты фигуры => " + turnString);
        this.sLastTurn = turnString;
        bNextTurn = !color;
        notifyAll();
    }

    public synchronized String waitTurn(boolean fromColor){
        while (bNextTurn == fromColor){
            try {
                wait();
            } catch (InterruptedException e) {}
        }
        notifyAll();
        return sLastTurn;
    }

}
