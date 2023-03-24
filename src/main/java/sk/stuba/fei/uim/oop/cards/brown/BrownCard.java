package sk.stuba.fei.uim.oop.cards.brown;

import sk.stuba.fei.uim.oop.cards.Card;
import sk.stuba.fei.uim.oop.game.GameBoard;
import sk.stuba.fei.uim.oop.game.Player;

public class BrownCard extends Card {

    public BrownCard(String name, GameBoard gameBoard) {
        super(name, gameBoard);
    }

    @Override
    public void play(Player playing) {
        gameBoard.discardCard(this);
        super.play(playing);
    }
}
