package com.bridgelabz.deckofcards;

import java.util.Scanner;

public class Player
{
    public static Scanner in = new Scanner(System.in);
    int players;
    int card;
    Name[] player;
    String[][] deck;

    public Player(int players, int card, String[][] deck)
    {
        this.players = players;
        this.card = card;
        this.deck = deck;
        start();
    }

    public void start() {
        player = new Name[4];
        for (int i = 0; i < player.length; i++)
        {
            System.out.println("Please Enter the " + i + " player name");
            String name = in.next();
            player[i] = new Name(name);
        }
    }
}