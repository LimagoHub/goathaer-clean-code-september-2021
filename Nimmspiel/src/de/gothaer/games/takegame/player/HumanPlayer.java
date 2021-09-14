package de.gothaer.games.takegame.player;

import java.util.Scanner;

public class HumanPlayer extends AbstractTakegamePlayer{

    public static final String USER_PROMPT = "Es git %s Steine. Bitte nehmen Sie 1,2 oder 3";
    private final Scanner scanner = new Scanner(System.in);


    public Integer doTurn(Integer stones) {
        System.out.println(String.format(USER_PROMPT, stones));
        return scanner.nextInt();
    }
}
