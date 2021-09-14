package de.gothaer.games.takegame.player;

public class ComputerPlayer extends AbstractTakegamePlayer{

    private static final String COMPUTER_MESSAGE = "Computer nimmt %s Steine.\n";
    private final static int POSSIBLE_TURNS[] = {3,1,1,2};

    @Override
    public Integer doTurn(Integer stones) {

        int result = POSSIBLE_TURNS[stones % 4];

        System.out.println(String.format(COMPUTER_MESSAGE, result));
        return result;
    }
}
