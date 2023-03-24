package sk.stuba.fei.uim.oop.cards.brown;

import sk.stuba.fei.uim.oop.cards.Card;
import sk.stuba.fei.uim.oop.game.GameBoard;
import sk.stuba.fei.uim.oop.game.Player;

public class Indians extends BrownCard {

    public Indians(String name, GameBoard gameBoard) {
        super(name, gameBoard);
    }

    @Override
    public void play(Player playing) {
        super.play(playing);
        for (Player player : gameBoard.getPlayers()) {
            if (player == playing) {
                continue;
            }
            if (!playsBang(player)) {
                player.alterLives(-1);
                System.out.println(player.getName() + " gets shot by the indians!");
            }
        }
    }

    private boolean playsBang(Player player) {
        for (Card card : player.getHand()) {
            if (card instanceof Bang) {
                gameBoard.discardCard(card);
                player.getHand().remove(card);
                System.out.println(player.getName() + " scares the indians away.");
                return true;
            }
        }
        return false;
    }
}
