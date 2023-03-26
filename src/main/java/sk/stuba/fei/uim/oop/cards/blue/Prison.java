package sk.stuba.fei.uim.oop.cards.blue;

import sk.stuba.fei.uim.oop.cards.Card;
import sk.stuba.fei.uim.oop.game.GameBoard;
import sk.stuba.fei.uim.oop.game.Player;

public class Prison extends BlueCard {

    public Prison(String name, GameBoard gameBoard) {
        super(name, gameBoard);
    }

    @Override
    public boolean canBePlayed(Player playing) {
        for (Player player : gameBoard.getPlayers()) {
            if (player != playing && !isInPrison(player)) {
                return true;
            }
        }
        System.out.println("All other players are imprisioned!");
        return false;
    }

    @Override
    public void play(Player playing) {
        super.play(playing);
        Player target = choosePlayer(playing);
        while (isInPrison(target)) {
            System.out.println(target.getName() + " is imprisioned! Choose someone else!");
            target = choosePlayer(playing);
        }
        super.placeInfrontOf(target);
    }

    public boolean effect(Player player) {
        boolean bool;
        if (Math.random() < 0.25) {
            System.out.println("You escape from the prison!");
            bool = true;
        }
        else {
            System.out.println("You couldn't escape from the prison!");
            bool = false;
        }
        gameBoard.discardCard(this);
        player.getLaidCards().remove(this);
        return bool;
    }

    private boolean isInPrison(Player player) {
        for (Card card : player.getLaidCards()) {
            if (card instanceof Prison) {
                return true;
            }
        }
        return false;
    }
}
