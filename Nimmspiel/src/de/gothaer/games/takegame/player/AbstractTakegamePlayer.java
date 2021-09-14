package de.gothaer.games.takegame.player;

import de.gothaer.games.AbstractGame;
import de.gothaer.games.players.AbstractGamePlayer;

public abstract class AbstractTakegamePlayer extends AbstractGamePlayer<Integer, Integer> {

    private final String name;
    public AbstractTakegamePlayer() {
        this.name = this.getClass().getSimpleName();
    }

    public AbstractTakegamePlayer(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }


}
