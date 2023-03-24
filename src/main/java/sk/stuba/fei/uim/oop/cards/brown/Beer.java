package sk.stuba.fei.uim.oop.cards.brown;

import sk.stuba.fei.uim.oop.game.GameBoard;
import sk.stuba.fei.uim.oop.game.Player;

public class Beer extends BrownCard {

    public Beer(String name, GameBoard gameBoard) {
        super(name, gameBoard);
    }

    @Override
    public void play(Player playing) {
        super.play(playing);
        playing.alterLives(1);
        System.out.println("You get one life!");
    }
}
