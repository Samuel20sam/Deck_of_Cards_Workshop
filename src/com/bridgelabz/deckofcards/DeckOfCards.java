package com.bridgelabz.deckofcards;

import java.util.Arrays;

public class DeckOfCards extends Players
{
    public static String[] suits = { "Clubs", "Diamonds", "Hearts", "Spades" };
    public static String[] ranks = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace" };
    public static int n = suits.length * ranks.length;

    public String[] start()
    {
        String[] deck = new String[n];
        for (int i = 0; i < ranks.length; i++) {
            for (int j = 0; j < suits.length; j++) {
                deck[suits.length * i + j] = ranks[i] + " - " + suits[j];
            }
        }
    return deck;
    }

    public static String[] shuffle(String[] deck)
    {
        for (int i = 0; i < n; i++) {
            int r = i + (int) (Math.random() * (n - i));
            String temp = deck[r];
            deck[r] = deck[i];
            deck[i] = temp;
        }
    return deck;
    }

    public static void main(String[] args)
    {
        DeckOfCards deckOfCards = new DeckOfCards();
        Players players = new Players();
        players.Player();
        players.order();
        String[] deck = deckOfCards.start();
        String[] deckShuffle = shuffle(deck);
        System.out.println(Arrays.toString(deckShuffle));
    }
}