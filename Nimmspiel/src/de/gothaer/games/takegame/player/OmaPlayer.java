package de.gothaer.games.takegame.player;

import java.util.Random;

public class OmaPlayer extends AbstractTakegamePlayer{

    private final Random random = new Random();

    public OmaPlayer() {
    }

    public OmaPlayer(String name) {
        super(name);
    }

    @Override
    public Integer doTurn(Integer integer) {
        return random.nextInt(3) + 1;
    }
}
