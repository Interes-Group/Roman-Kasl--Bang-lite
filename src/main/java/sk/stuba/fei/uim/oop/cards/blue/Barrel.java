package sk.stuba.fei.uim.oop.cards.blue;

import sk.stuba.fei.uim.oop.cards.Card;
import sk.stuba.fei.uim.oop.game.GameBoard;
import sk.stuba.fei.uim.oop.game.Player;

public class Barrel extends BlueCard {

    public Barrel(String name, GameBoard gameBoard) {
        super(name, gameBoard);
    }

    @Override
    public boolean canBePlayed(Player playing) {
        for (Card card : playing.getLaidCards()) {
            if (card instanceof Barrel) {
                System.out.println("You already have a barrel!");
                return false;
            }
        }
        return true;
    }

    @Override
    public void play(Player playing) {
        super.play(playing);
        super.placeInfrontOf(playing);
    }

    public boolean hide(Player player) {
        if (Math.random() < 0.25) {
            System.out.println(player.getName() + " hides in his barrel!");
            return true;
        }
        else {
            System.out.println(player.getName() + " couldn't hide in his barrel.");
            return false;
        }
    }
}
