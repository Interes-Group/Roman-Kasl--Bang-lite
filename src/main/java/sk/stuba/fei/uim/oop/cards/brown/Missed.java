package sk.stuba.fei.uim.oop.cards.brown;

import sk.stuba.fei.uim.oop.game.GameBoard;
import sk.stuba.fei.uim.oop.game.Player;

public class Missed extends BrownCard {

    public Missed(String name, GameBoard gameBoard) {
        super(name, gameBoard);
    }

    @Override
    public boolean canBePlayed(Player playing) {
        return false;
    }

    @Override
    public void play(Player playing) {
        super.play(playing);
        System.out.println(playing.getName() + " uses Missed card!");
    }
}
