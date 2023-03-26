package sk.stuba.fei.uim.oop.cards.brown;

import sk.stuba.fei.uim.oop.game.GameBoard;
import sk.stuba.fei.uim.oop.game.Player;

public class Missed extends BrownCard {

    public Missed(String name, GameBoard gameBoard) {
        super(name, gameBoard);
    }

    @Override
    public boolean canBePlayed(Player playing) {
        System.out.println("You can only play this to block Bang!");
        return false;
    }

    @Override
    public void play(Player playing) {
        playing.getHand().remove(this);
        gameBoard.discardCard(this);
        System.out.println(playing.getName() + " uses Missed card!");
    }
}
