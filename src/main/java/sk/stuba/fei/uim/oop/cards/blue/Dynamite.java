package sk.stuba.fei.uim.oop.cards.blue;

import java.util.ArrayList;

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

    public boolean effect(Player player) {
        boolean bool;
        if (Math.random() < 0.25) {
            System.out.println("The dynamite has blown into your face! You lose three lives!");
            player.alterLives(-3);
            gameBoard.discardCard(this);
            bool = true;
        }
        else {
            ArrayList<Player> players = gameBoard.getPlayers();
            System.out.println("The dynamite did not blow!");
            int index = players.indexOf(player);
            Player newOwner;
            if (index == 0) {
                newOwner = players.get(players.size() - 1);
            }
            else {
                newOwner = players.get(index - 1);
            }
            newOwner.getLaidCards().add(this);
            bool = false;
        }
        player.getLaidCards().remove(this);
        return bool;
    }
}
