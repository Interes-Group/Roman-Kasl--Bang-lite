package sk.stuba.fei.uim.oop.cards;

import java.util.ArrayList;

import sk.stuba.fei.uim.oop.game.GameBoard;
import sk.stuba.fei.uim.oop.game.Player;
import sk.stuba.fei.uim.oop.utility.KeyboardInput;

public class Card {
    protected String name;
    protected GameBoard gameBoard;

    public Card(String name, GameBoard gameBoard) {
        this.name = name;
        this.gameBoard = gameBoard;
    }

    public String getName() {
        return name;
    }

    public boolean canBePlayed(Player playing) {
        return true;
    }

    public void play(Player playing) {
        System.out.println("You chose " + name);
        playing.getHand().remove(this);
    }

    protected Player choosePlayer(Player playing) {
        ArrayList<Player> players = gameBoard.getPlayers();
        for (Player player : players) {
            System.out.println(players.indexOf(player)+1 + ". " + player.getName());
        }
        int playerIndex = KeyboardInput.readInt("Who do you choose to play this card on? ");
        --playerIndex;
        while (playerIndex < 0 || playerIndex >= players.size() || players.get(playerIndex) == playing) {
            if (playerIndex < 0 || playerIndex >= players.size()) {
                playerIndex = KeyboardInput.readInt("Invalid player number! Enter again: ");
            }
            else {
                playerIndex = KeyboardInput.readInt("You can't play this card on yourself! Enter again: ");
            }
            --playerIndex;
        }
        System.out.println();
        return players.get(playerIndex);
    }
}
