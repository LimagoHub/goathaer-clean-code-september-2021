package de.gothaer.games;

import de.gothaer.games.players.GamePlayer;
import de.gothaer.io.ConsoleWriter;
import de.gothaer.io.Writer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @param <Scene>
 * @param <Turn>
 */
public abstract class AbstractGame<Scene, Turn> implements Game{

    private static final String ERROR_MESSAGE = "Ungueltiger Zug";


    /*
        bla blupp
     */
    private GamePlayer<Scene, Turn> currentPlayer;
    private Scene scene;
    private Turn turn;

    private Writer writer = new ConsoleWriter();

    public Writer getWriter() {
        return writer;
    }

    public void setWriter(Writer writer) {
        this.writer = writer;
    }

    public GamePlayer<Scene, Turn> getCurrentPlayer() {
        return currentPlayer;
    }

    protected void setCurrentPlayer(GamePlayer<Scene, Turn> currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    protected Scene getScene() {
        return scene;
    }

    protected void setScene(Scene scene) {
        this.scene = scene;
    }

    protected Turn getTurn() {
        return turn;
    }

    protected void setTurn(Turn turn) {
        this.turn = turn;
    }

    private final List<GamePlayer<Scene, Turn>> players = new ArrayList<>();

    public void addPlayer(GamePlayer<Scene, Turn> player) {
        players.add(player);

    }
    public void removePlayer(GamePlayer<Scene, Turn> player) {
        players.remove(player);
    }

    protected List<GamePlayer<Scene, Turn>> getPlayers () {
        return Collections.unmodifiableList(players);
    }

    @Override
    public void play() {
        while( ! gameover()) executeGameRounds();
    }

    private void executeGameRounds() {
        for (GamePlayer<Scene,Turn> player: players) prepareTurn(player);
    }


    private void prepareTurn (GamePlayer<Scene,Turn> player) {
        setCurrentPlayer(player);
        executeSingleTurn();
    }

    private void executeSingleTurn() {
        if(gameover()) return;
        beforeExecute();
        executeSingleTurnUntilValid();
        terminateTurn();
    }


    private void executeSingleTurnUntilValid() {

        do turn = currentPlayer.doTurn(scene); while (playersTurnIsInvalid());

    }
    private boolean playersTurnIsInvalid() {
        if (isTurnValid()) {
            return false;
        }
        print(ERROR_MESSAGE);
        return true;
    }

    private void terminateTurn( ) {
        updateScene();
        checkLosing();
    }

    private void checkLosing() {
        if (gameover()) {
            print(String.format("Spieler %s hat verloren.", currentPlayer.getName()));
        }
    }


    protected void print(String message) {
        writer.write(message);
    }

    //--------------------------------------------------
    protected abstract boolean gameover();
    protected abstract boolean isTurnValid();
    protected abstract void updateScene();
    protected void beforeExecute() {
        // Ok
    }
}
