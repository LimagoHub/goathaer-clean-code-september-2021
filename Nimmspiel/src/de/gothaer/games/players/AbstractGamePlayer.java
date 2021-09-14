package de.gothaer.games.players;

public abstract class AbstractGamePlayer<Scene, Turn> implements GamePlayer<Scene, Turn>{

    private final String name;
    public AbstractGamePlayer() {
        this.name = this.getClass().getSimpleName();
    }

    public AbstractGamePlayer(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }


}
