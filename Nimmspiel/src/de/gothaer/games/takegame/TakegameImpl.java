package de.gothaer.games.takegame;
import de.gothaer.games.AbstractGame;

public class TakegameImpl extends AbstractGame<Integer,Integer> {



    public TakegameImpl() {
        setScene(23);

    }

    @Override
    protected boolean isTurnValid() {
        return getTurn() >=1 && getTurn() <= 3;
    }

    @Override
    protected void updateScene() {
        setScene(getScene() - getTurn()); ;
    }
    @Override
    protected boolean gameover() {
        return getScene() <= 0 || getPlayers().isEmpty();
    }

    @Override
    protected void beforeExecute() {
        print(String.format("%s ist am Zug.", getCurrentPlayer().getName()));
    }
}
