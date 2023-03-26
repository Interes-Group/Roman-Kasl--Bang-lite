package sk.stuba.fei.uim.oop.game;

import sk.stuba.fei.uim.oop.cards.Card;
import sk.stuba.fei.uim.oop.cards.blue.Dynamite;
import sk.stuba.fei.uim.oop.cards.blue.Prison;
import sk.stuba.fei.uim.oop.utility.KeyboardInput;

public class Game {
    GameBoard gameBoard;

    public Game() {
        this.gameBoard = new GameBoard();
        for (Player player : gameBoard.getPlayers()) {
            player.dealCards(4);
        }
        mainLoop();
        System.out.println(gameBoard.getPlayers().get(0).getName() + " wins!");
    }

    private void mainLoop() {
        int i = 0;
        while (gameBoard.getPlayers().size() > 1) {
            Player playing = gameBoard.getPlayers().get(i);
            System.out.println("\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
            System.out.println(playing.getName() + "'s turn:\n");
            if (checkDynamite(playing)) {
                if (i >= gameBoard.getPlayers().size()) {
                    i = 0;
                }
                continue;
            }
            else if (checkPrison(playing)) {
                i = nextIndex(playing);
                continue;
            }
            playerTurn(playing);
            i = nextIndex(playing);
        }
    }

    private boolean checkDynamite(Player playing) {
        for (Card card : playing.getLaidCards()) {
            if (card instanceof Dynamite) {
                if (((Dynamite)card).effect(playing) && playing.getLives() <= 0) {
                    gameBoard.playerDied(playing);
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    private boolean checkPrison(Player playing) {
        for (Card card : playing.getLaidCards()) {
            if (card instanceof Prison) {
                if (!((Prison)card).effect(playing)) {
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    private int nextIndex(Player playing) {
        int i = gameBoard.getPlayers().indexOf(playing) + 1;
        if (i >= gameBoard.getPlayers().size()) {
            i = 0;
        }
        return i;
    }

    private void playerTurn(Player player) {
        getCardsOnTurn(player);
        while (player.getHand().size() > 0) {
            boolean cont = playCard(player);
            if (!cont) {
                break;
            }
        }
        removeRedundantCards(player);
    }

    private void getCardsOnTurn(Player player) {
        player.dealCards(2);
        System.out.println("You get two cards.\n");
    }

    private boolean playCard(Player player) {
        printGameBoard();
        System.out.println("\nYour hand:");
        player.printHand();
        System.out.println();
        int input = KeyboardInput.readInt("Which card do you play? Enter card number (Enter any other number to end turn) ");
        if (input < 1 || input > player.getHand().size()) {
            return false;
        }
        input--;
        Card card = player.getHand().get(input);
        while (!card.canBePlayed(player)) {
            input = KeyboardInput.readInt("Choose another card: ");
            if (input < 1 || input > player.getHand().size()) {
                return false;
            }
            input--;
            card = player.getHand().get(input);
        }
        System.out.println();
        card.play(player);
        removeDeadPlayers();
        if (gameBoard.getPlayers().size() <= 1) {
            return false;
        }
        return true;
    }

    private void removeDeadPlayers() {
        Player player;
        for (int i = 0; i < gameBoard.getPlayers().size(); i++) {
            player = gameBoard.getPlayers().get(i);
            if (player.getLives() <= 0) {
                gameBoard.playerDied(player);
                i--;
            }
        }
    }

    private void removeRedundantCards(Player player) {
        int cardsLost = 0;
        while (player.getHand().size() > player.getLives()) {
            Card card = player.getHand().remove(gameBoard.randInt(player.getHand().size()));
            gameBoard.discardCard(card);
            cardsLost++;
        }
        System.out.println("You lost " + cardsLost + " cards!");
    }

    private void printGameBoard() {
        for (Player player : gameBoard.getPlayers()) {
            System.out.print(player.getName() + ": " + player.getLives() + " lives ");
            if (!player.getLaidCards().isEmpty()) {
                for (Card card : player.getLaidCards()) {
                    System.out.print(card.getName() + " ");
                }
            }
            System.out.println();
        }
    }
}
