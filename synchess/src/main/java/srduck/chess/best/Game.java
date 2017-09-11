package srduck.chess.best;

import srduck.chess.oldschool.*;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by main on 11.09.17.
 */
public class Game {
    public static String[][] gambit = {
            {"e2-e4", "e7-e5"},
            {"Kg1-f3", "Kb8-c6"},
            {"Kb1-c3", "Kg8-f6"},
            {"d2-d4", "e5:d4"},
            {"Kc3-d5", "Неожиданно"}
    };

    public static void main (String... args) throws InterruptedException {

        BlockingDeque<String> whiteTurns = new LinkedBlockingDeque<>(1);
        BlockingDeque<String> blackTurns = new LinkedBlockingDeque<>(1);

        Player white = new Player(whiteTurns, blackTurns, gambit[0][0]);
        Player black = new Player(blackTurns, whiteTurns);
        white.start();
        black.start();
    };
}
