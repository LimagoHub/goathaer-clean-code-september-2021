package de.gothaer.games.takegame;

import de.gothaer.games.Game;

import java.util.Scanner;

public class TakegameImpl implements Game {

    public static final String USER_PROMP = "Es git %s Steine. Bitte nehmen Sie 1,2 oder 3";
    public static final String ERROR_MESSAGE = "Ungueltiger Zug";
    public static final String COMPUTER_MESSAGE = "Computer nimmt %s Steine.\n";
    private final Scanner scanner = new Scanner(System.in);
    private int stones;
    private int turn;

    public TakegameImpl() {
        this.stones = 23;

    }

    @Override
    public void play() {
        while( ! gameover()) {
            executeTurns();
        }
    }

    private void executeTurns() {
        humanTurn();
        computerturn();
    }

    private void humanTurn() {
        if(gameover()) return;


        while(true) {
            print(String.format(USER_PROMP, stones));
            turn = scanner.nextInt();;
            if(turn >=1 && turn <= 3) break;
            print(ERROR_MESSAGE);
        }
        terminateTurn("Mensch");
    }

    private void computerturn() {

        if(gameover()) return ;


        final int possibleTurns[] = {3,1,1,2};
         turn = possibleTurns[stones % 4];

        print(String.format(COMPUTER_MESSAGE, turn));

        terminateTurn("Computer");
    }

    private void terminateTurn( String player) {
        updateScene();
        ckeckLosing(player);
    }

    private void ckeckLosing(String player) {
        if (gameover()) {
            print(String.format("Spieler %s hat verloren.", player));
        }
    }
    private void print(String message) {
        System.out.println(message);
    }
    private void updateScene() {
        stones -= turn;
    }

    private boolean gameover() {
        return stones <= 0;
    }

}
