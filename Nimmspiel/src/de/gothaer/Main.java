package de.gothaer;

import de.gothaer.client.GameClient;
import de.gothaer.games.AbstractGame;
import de.gothaer.games.Game;
import de.gothaer.games.takegame.TakegameImpl;
import de.gothaer.games.takegame.player.ComputerPlayer;
import de.gothaer.games.takegame.player.HumanPlayer;

public class Main {


    public static void main(String[] args) {
        AbstractGame game = new TakegameImpl();
        game.addPlayer(new HumanPlayer());
        game.addPlayer(new ComputerPlayer());
        GameClient client = new GameClient(game);

        client.go();
    }
}
