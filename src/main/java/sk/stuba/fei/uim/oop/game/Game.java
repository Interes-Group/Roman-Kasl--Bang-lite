package sk.stuba.fei.uim.oop.game;

import sk.stuba.fei.uim.oop.cards.brown.Bang;

import java.util.ArrayList;

public class Game {
    GameBoard gameBoard;

    public Game() {
        this.gameBoard = new GameBoard();
        ArrayList<Player> players = gameBoard.getPlayers();
        for (Player player : players) {
            player.dealCards(4);
        }


    }
}
