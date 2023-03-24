package sk.stuba.fei.uim.oop.cards.brown;

import sk.stuba.fei.uim.oop.cards.Card;
import sk.stuba.fei.uim.oop.cards.blue.Barrel;
import sk.stuba.fei.uim.oop.game.GameBoard;
import sk.stuba.fei.uim.oop.game.Player;

public class Bang extends BrownCard {

    public Bang(String name, GameBoard gameBoard) {
        super(name, gameBoard);
    }

    @Override
    public void play(Player playing) {
        super.play(playing);
        Player target = choosePlayer(playing);
        if (checkBarrel(target)) {
            return;
        }
        if (playsMissed(target)) {
            return;
        }
        else {
            target.alterLives(-1);
            System.out.println("You shot " + target.getName() + "! They lose a life!");
        }
    }

    private boolean checkBarrel(Player target) {
        for (Card card : target.getLaidCards()) {
            if (card instanceof Barrel) {
                if (((Barrel)card).hide(target)) {
                    return true;
                }
                else {
                    return false;
                }
            }
        }
        return false;
    }

    private boolean playsMissed(Player player) {
        for (Card card : player.getHand()) {
            if (card instanceof Missed) {
                card.play(player);
                return true;
            }
        }
        return false;
    }
}
