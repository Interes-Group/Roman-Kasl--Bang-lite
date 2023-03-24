package sk.stuba.fei.uim.oop.cards.brown;

import sk.stuba.fei.uim.oop.cards.Card;
import sk.stuba.fei.uim.oop.game.GameBoard;
import sk.stuba.fei.uim.oop.game.Player;
import sk.stuba.fei.uim.oop.utility.KeyboardInput;

public class CatBalou extends BrownCard {

    public CatBalou(String name, GameBoard gameBoard) {
        super(name, gameBoard);
    }

    @Override
    public boolean canBePlayed(Player playing) {
        for (Player player : gameBoard.getPlayers()) {
            if (player != playing && (player.getHand().size() != 0 || player.getLaidCards().size() != 0)) {
                return true;
            }
        }
        System.out.println("No one but you does not have any cards.");
        return false;
    }

    @Override
    public void play(Player playing) {
        super.play(playing);
        Player target = super.choosePlayer(playing);
        while (target.getHand().size() == 0 && target.getLaidCards().size() == 0) {
            System.out.println(target.getName() + " has no cards! Choose someone else!");
            target = choosePlayer(playing);
        }

        if (target.getHand().size() == 0) {
            rmFromLaidCards(target);
        }
        else if (target.getLaidCards().size() == 0) {
            rmFromHand(target);
        }
        else {
            String input = KeyboardInput.readString("Do you choose a card from hand (Enter 'h') of from the cards laid in front of " + target.getName() + " (Enter anything)? ");
            if (input.equals("h")) {
                rmFromHand(target);
            }
            else {
                rmFromLaidCards(target);
            }
        }
    }

    private void rmFromHand(Player target) {
        System.out.println("You discarted a card from " + target.getName() + "'s hand.");
        Card card = target.getHand().remove(gameBoard.randInt(target.getHand().size()));
        gameBoard.discardCard(card);
    }

    private void rmFromLaidCards(Player target) {
        System.out.println("You discarted a card from cards laid in front of" + target.getName() + ".");
        Card card = target.getHand().remove(gameBoard.randInt(target.getHand().size()));
        gameBoard.discardCard(card);
    }
}
