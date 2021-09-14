package de.gothaer.games.players;

public interface GamePlayer<Scene, Turn> {

    String getName();
    Turn doTurn(final Scene scene);
}
