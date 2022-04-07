package com.bridgelabz.deckofcards;

public class DeckOfCards extends Players {
    public int[] freqCount = new int[4];
    public String[] cardsOfEachPlayer;
    public String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
    public String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
    int n = 4 * 13;

    public String[] deckInitialize() {
        String[] deck = new String[this.n];
        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 4; j++) {
                deck[4 * i + j] = ranks[i] + " of " + suits[j];
            }
        }
        deck = shuffleCard(deck);
        return deck;
    }

    public String[] shuffleCard(String[] deck) {
        for (int i = 0; i < n; i++) {
            int r = i + (int) (Math.random() * (n - i));
            String temp = deck[r];
            deck[r] = deck[i];
            deck[i] = temp;
        }
        return deck;
    }

    private int checkRankIndex(String a, String b) {
        int index1 = 0;
        int index2 = 0;
        for (int i = 0; i < ranks.length; i++) {
            if (a.equals(ranks[i])) {
                index1 = i;
            }
            if (b.equals(ranks[i])) {
                index2 = i;
            }
        }
        if (index1 > index2) {
            return 1;
        } else {
            return 0;
        }
    }

    private int[] CardsIndex(int player) {
        int[] cardIndex = new int[player * 9]; /// Initialize array with numbers
        for (int k = 0; k < player * 9; k++) {
            cardIndex[k] = 52;
        }
        int i = 0, min = 0, max = 51;
        while (i < player * 9) {
            int condition = 0;
            int randomIndex = (int) Math.floor(Math.random() * (max - min) + min);
            for (int index : cardIndex) {
                if (randomIndex == index) {
                    condition = 1;
                    break;
                }
            }
            if (condition == 0) {
                cardIndex[i] = randomIndex;
                i += 1;
            }
        }
        return cardIndex;
    }

    private String[] sortingCards(String[] cardsOfPlayer) {
        for (int i = 0; i < cardsOfPlayer.length - 1; i++) {
            for (int j = 0; j < cardsOfPlayer.length - i - 1; j++) {
                if (cardsOfPlayer[j].split(" ")[2].equals(cardsOfPlayer[j + 1].split(" ")[2])) {
                    int result = checkRankIndex(cardsOfPlayer[j].split(" ")[0], cardsOfPlayer[j + 1].split(" ")[0]);
                    if (result == 1) {
                        String temp = cardsOfPlayer[j];
                        cardsOfPlayer[j] = cardsOfPlayer[j + 1];
                        cardsOfPlayer[j + 1] = temp;
                    }
                }
            }
        }
        return cardsOfPlayer;
    }

    public void distribution() {
        String[] player = addingPlayer();
        String[] deck = deckInitialize();
        int[] cardIndex = CardsIndex(player.length);
        for (int i = 1; i < player.length + 1; i++) {
            System.out.println("\nPlayer " + player[i - 1] + " Cards :");
            cardsOfEachPlayer = new String[(cardIndex.length / player.length)];
            int p = 0;
            for (int j = i - 1; j < cardIndex.length; j = j + player.length) {
                System.out.print(deck[j] +" , ");
                cardsOfEachPlayer[p] = deck[j];
                p++;
                freqCounter(deck[j]);
            }
            String[] sortedCards = sortingCards(cardsOfEachPlayer);
            System.out.println();
            System.out.println("---- After sorting");
            for (String cards : sortedCards) {
                System.out.print(cards + " , ");
            }
            System.out.println();
            int k = 0;
            for (int count : freqCount) {
                System.out.print("\n" +suits[k] + ":" + count + " ");
                k++;
            }
            freqCount = new int[4];
            System.out.println();
        }
    }

    private void freqCounter(String deck) {
        String[] splitDeck = deck.split(" ");
        for (String suit : splitDeck) {
            if (suit.equals("Clubs")) {
                freqCount[0]++;
            }
            if (suit.equals("Diamonds")) {
                freqCount[1]++;
            }
            if (suit.equals("Hearts")) {
                freqCount[2]++;
            }
            if (suit.equals("Spades")) {
                freqCount[3]++;
            }
        }
    }

    public static void main(String[] args) {

        DeckOfCards deckOfCards = new DeckOfCards();
        deckOfCards.distribution();
    }
}