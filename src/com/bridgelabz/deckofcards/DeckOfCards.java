package com.bridgelabz.deckofcards;

import java.util.Arrays;

public class DeckOfCards
{
    public static void main(String[] args) {
        String[] suit = {"Clubs", "Diamonds", "Hearts", "Spades"};
        String[] rank = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
        String[][] deck = new String[4][13];
        for (int i = 0; i < suit.length; i++) {
            for (int j = 0; j < rank.length; j++) {
                deck[i][j] = rank[j] + "(" + suit[i] + ")";
            }
        }
        String[][] shuffledDeck = shuffle(suit, rank, deck);
        System.out.println(Arrays.deepToString(shuffledDeck));
    }

    private static String[][] shuffle(String[] suit, String[] rank, String[][] deck) {
        String[] temp = new String[1];
        for (int i = 0; i < suit.length; i++) {
            for (int j = 0; j < rank.length; j++) {
                int random1 = (int) Math.floor(Math.random() * 10) % 4;
                int random2 = (int) Math.floor(Math.random() * 100) % 13;
                temp[0] = deck[i][j];
                deck[i][j] = deck[random1][random2];
                deck[random1][random2] = temp[0];
            }

        }
        return deck;
    }
}
