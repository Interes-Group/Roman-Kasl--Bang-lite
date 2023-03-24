package sk.stuba.fei.uim.oop.cards.blue;

import sk.stuba.fei.uim.oop.cards.Card;
import sk.stuba.fei.uim.oop.game.GameBoard;
import sk.stuba.fei.uim.oop.game.Player;

public class BlueCard extends Card {

    public BlueCard(String name, GameBoard gameBoard) {
        super(name, gameBoard);
    }

    protected void placeInfrontOf(Player target) {
        target.getLaidCards().add(this);
    }
}
