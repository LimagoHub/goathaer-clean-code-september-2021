package de.gothaer;

import de.gothaer.client.GameClient;
import de.gothaer.games.Game;
import de.gothaer.games.takegame.TakegameImpl;

public class Main {


    public static void main(String[] args) {
        Game game = new TakegameImpl();
        GameClient client = new GameClient(game);

        client.go();
    }
}
