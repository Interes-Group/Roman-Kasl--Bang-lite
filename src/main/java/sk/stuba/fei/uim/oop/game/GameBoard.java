package sk.stuba.fei.uim.oop.game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import sk.stuba.fei.uim.oop.cards.Card;
import sk.stuba.fei.uim.oop.cards.blue.*;
import sk.stuba.fei.uim.oop.cards.brown.*;
import sk.stuba.fei.uim.oop.utility.KeyboardInput;

public class GameBoard {
    private static Random rand = new Random();
    private ArrayList<Player> players = new ArrayList<>();
    private ArrayList<Player> deadPlayers = new ArrayList<>();

    private ArrayList<Card> deck = new ArrayList<>();
    private ArrayList<Card> discardPile = new ArrayList<>();

    public GameBoard() {
        fillDeck();
        setPlayers();
    }

    private void fillDeck() {
        for (int i = 0; i < 2; i++) {
            deck.add(new Barrel("Barrel", this));
        }
        for (int i = 0; i < 1; i++) {
            deck.add(new Dynamite("Dynamite", this));
        }
        for (int i = 0; i < 3; i++) {
            deck.add(new Prison("Prison", this));
        }
        for (int i = 0; i < 30; i++) {
            deck.add(new Bang("Bang", this));
        }
        for (int i = 0; i < 15; i++) {
            deck.add(new Missed("Missed", this));
        }
        for (int i = 0; i < 8; i++) {
            deck.add(new Beer("Beer", this));
        }
        for (int i = 0; i < 6; i++) {
            deck.add(new CatBalou("CatBalou", this));
        }
        for (int i = 0; i < 4; i++) {
            deck.add(new Stagecoach("Stagecoach", this));
        }
        for (int i = 0; i < 2; i++) {
            deck.add(new Indians("Indians", this));
        }
        Collections.shuffle(deck);
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

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public ArrayList<Player> getDeadPlayers() {
        return deadPlayers;
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

    public int randInt(int bound) {
        return rand.nextInt(bound);
    }

    public void playerDied(Player player) {
        player.discardAllCards();
        deadPlayers.add(player);
        players.remove(player);
        System.out.println(player.getName() + " has died!");
    }
}
