package sk.stuba.fei.uim.oop.cards.brown;

import sk.stuba.fei.uim.oop.game.GameBoard;
import sk.stuba.fei.uim.oop.game.Player;

public class Stagecoach extends BrownCard {

    public Stagecoach(String name, GameBoard gameBoard) {
        super(name, gameBoard);
    }

    public void play(Player playing) {
        super.play(playing);
        playing.dealCards(2);
        System.out.println("You draw two cards.");
    }
}
