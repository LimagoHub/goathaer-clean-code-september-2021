package de.gothaer.games.takegame;

import de.gothaer.games.Game;

import java.util.Scanner;

public class TakegameImpl implements Game {

    public static final String USER_PROMP = "Es git %s Steine. Bitte nehmen Sie 1,2 oder 3";
    public static final String ERROR_MESSAGE = "Ungueltiger Zug";
    public static final String COMPUTER_MESSAGE = "Computer nimmt %s Steine.\n";
    private final Scanner scanner = new Scanner(System.in);
    private int stones;
    private boolean gameover;

    public TakegameImpl() {
        this.stones = 23;
        this.gameover =false;
    }

    @Override
    public void play() {
        while( ! gameover) {
            executeTurns();
        }
    }

    private void executeTurns() {
        humanTurn();
        computerturn();
    }

    private void humanTurn() {
        int turn;

        while(true) {
            print(String.format(USER_PROMP, stones));
            turn = scanner.nextInt();;
            if(turn >=1 && turn <= 3) break;
            print(ERROR_MESSAGE);
        }
        stones-=turn;
    }

    private void computerturn() {

        if(stones <= 0) {
            print("Du Loser");
            gameover = true;
            return;
        }
        if(stones == 1) {
            print("Du hast nur Glueck gehabt!");
            gameover = true;
            return;
        }

        final int possibleTurns[] = {3,1,1,2};
        int turn = possibleTurns[stones % 4];

        print(String.format(COMPUTER_MESSAGE, turn));

        stones -= turn;
    }

    private void print(String message) {
        System.out.println(message);
    }
}
