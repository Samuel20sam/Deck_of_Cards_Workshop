package com.bridgelabz.deckofcards;

import java.util.Arrays;

public class DeckOfCards extends Players {
    public static String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
    public static String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
    int n = suits.length * ranks.length;

    public String[] deckInitialize()
    {
        String[] deck = new String[this.n];
        for (int i = 0; i < ranks.length; i++)
        {
            for (int j = 0; j < suits.length; j++)
            {
                deck[suits.length * i + j] = ranks[i] + " of " + suits[j];
            }
        }
        deck = shuffleCard(deck);
        return deck;
    }
    public String[] shuffleCard(String[] deck)
    {
        for (int i = 0; i < n; i++) {
            int r = i + (int) (Math.random() * (n - i));
            String temp = deck[r];
            deck[r] = deck[i];
            deck[i] = temp;
        }
        return deck;
    }

    public int[] index() {
        int[] cardIndex = new int[9];
        int i = 0, min = 0, max = 51;
        while (i < 9) {
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

    public void distribution() {
        String[] player = addingPlayer();
        String[] deck = deckInitialize();
        int[] cardIndex = index();
        System.out.println(Arrays.toString(cardIndex));

        for (int i = 1; i < player.length + 1; i++) {
            System.out.println("Player " + player[i - 1] + " Cards :");
            for (int j = i - 1; j < cardIndex.length; j = j + player.length) {
                System.out.printf("|| %s    ", deck[j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        DeckOfCards deckOfCards = new DeckOfCards();
        deckOfCards.distribution();
    }
}