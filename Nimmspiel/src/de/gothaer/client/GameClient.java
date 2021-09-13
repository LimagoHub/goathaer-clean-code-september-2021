package de.gothaer.client;

import de.gothaer.games.Game;

public class GameClient {

    private final Game game;

    public GameClient(Game game) {
        this.game = game;
    }

    public void go() {
        game.play();
    }
}
