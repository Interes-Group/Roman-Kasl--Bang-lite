package sk.stuba.fei.uim.oop.game;

import java.util.ArrayList;

import sk.stuba.fei.uim.oop.cards.Card;
import sk.stuba.fei.uim.oop.utility.KeyboardInput;

public class Player {
    private String name;
    private int lives = 4;
    private ArrayList<Card> hand = new ArrayList<>();
    private ArrayList<Card> laidCards = new ArrayList<>();

    GameBoard gameBoard;

    public Player(GameBoard gameBoard) {
        this.gameBoard = gameBoard;
        this.name = KeyboardInput.readString("Enter name: ");
    }

    public void dealCards(int num) {
        for (int i = 0; i < num; i++) {
            hand.add(gameBoard.drawCard());
        }
    }

    public void dealCard() {
        hand.add(gameBoard.drawCard());
    }

    public String getName() {
        return name;
    }

    public void alterLives(int num) {
        lives += num;
    }

    public int getLives() {
        return lives;
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public ArrayList<Card> getLaidCards() {
        return laidCards;
    }

    public void discardAllCards() {
        while (!hand.isEmpty()) {
            gameBoard.discardCard(hand.remove(0));
        }
        while (!laidCards.isEmpty()) {
            gameBoard.discardCard(laidCards.remove(0));
        }
    }
}
