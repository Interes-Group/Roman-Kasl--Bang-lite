package sk.stuba.fei.uim.oop.game;

import java.util.ArrayList;
import java.util.Collections;

import sk.stuba.fei.uim.oop.cards.Card;
import sk.stuba.fei.uim.oop.cards.blue.*;
import sk.stuba.fei.uim.oop.cards.brown.*;

import sk.stuba.fei.uim.oop.utility.KeyboardInput;

public class GameBoard {
    private ArrayList<Player> players = new ArrayList<>();

    private ArrayList<Card> deck = new ArrayList<>();
    private ArrayList<Card> discardPile = new ArrayList<>();

    public GameBoard() {
        fillDeck();
        setPlayers();
    }

    private void fillDeck() {
        for (int i = 0; i < 2; i++) {
            deck.add(new Barrel());
        }
        for (int i = 0; i < 1; i++) {
            deck.add(new Dynamite());
        }
        for (int i = 0; i < 3; i++) {
            deck.add(new Prison());
        }
        for (int i = 0; i < 30; i++) {
            deck.add(new Bang());
        }
        for (int i = 0; i < 15; i++) {
            deck.add(new Missed());
        }
        for (int i = 0; i < 8; i++) {
            deck.add(new Beer());
        }
        for (int i = 0; i < 6; i++) {
            deck.add(new CatBalou());
        }
        for (int i = 0; i < 4; i++) {
            deck.add(new Stagecoach());
        }
        for (int i = 0; i < 2; i++) {
            deck.add(new Indians());
        }
        Collections.shuffle(deck);
        for (Card card : deck) {
            card.setGameBoard(this);
        }
    }



    private void setPlayers() {
        int playersCount = KeyboardInput.readInt("Enter number of players: ");
        while (playersCount < 2 || playersCount > 4) {
            playersCount = KeyboardInput.readInt("Min is 2 and max is 4! Enter again: ");
        }
        for (int i = 0; i < playersCount; i++) {
            Player newPlayer = new Player(this);
            players.add(newPlayer);
        }
    }

    public Card drawCard() {
        if (deck.isEmpty()) {
            while (!discardPile.isEmpty()) {
                deck.add(discardPile.remove(0));
            }
            Collections.shuffle(deck);
        }
        return deck.remove(0);
    }

    public void discardCard(Card card) {
        discardPile.add(card);
    }
}
