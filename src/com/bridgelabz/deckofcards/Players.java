package com.bridgelabz.deckofcards;

import java.util.Arrays;
import java.util.Scanner;

public class Players
{
        public String[] playersName = new String[4];

    public void Player() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the number of player");
        int pn = scan.nextInt();
        if (pn > 4 || pn < 2) {
            System.out.println("Enter player from 2 to 4");
            Player();
        }
        for (int i = 0; i < pn; i++) {
            Scanner scan1 = new Scanner(System.in);
            System.out.println("Player " + (i + 1) + " : Enter the name of the player");
            String name = scan1.nextLine();
            playersName[i] = name;
        }
    }

    public void order() {
        for (int i = 0; i < playersName.length - 1; i++) {
            for (int j = 0; j < playersName.length - i - 1; j++) {
                if (playersName[j].length() > playersName[j+1].length()) {
                    String temp = playersName[j+1];
                    playersName[j] = playersName[j+1];
                    playersName[j+1] = temp;
                    System.out.println(Arrays.toString(playersName));
                }
            }
        }
    }
}