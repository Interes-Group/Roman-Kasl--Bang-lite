package sk.stuba.fei.uim.oop.cards.blue;

import sk.stuba.fei.uim.oop.game.GameBoard;
import sk.stuba.fei.uim.oop.game.Player;

public class Dynamite extends BlueCard {

    public Dynamite(String name, GameBoard gameBoard) {
        super(name, gameBoard);
    }

    @Override
    public void play(Player playing) {
        super.play(playing);
        super.placeInfrontOf(playing);
    }
}
