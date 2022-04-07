package com.bridgelabz.deckofcards;

import java.util.Arrays;
import java.util.Scanner;

public class Players
{
    public String[] addingPlayer()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the number of player");
        int p = scan.nextInt();
        String[] playersName = new String[p];
        if(p>4 || p<2)
        {
            System.out.println("Enter player from 2 to 4");
            addingPlayer();
        }
        for(int i=0; i < p; i++) {
            Scanner input = new Scanner(System.in);
            System.out.println("Player "  + (i+1) +  " : Enter the player name");
            String name = input.nextLine();
            playersName[i] = name;
        }

        for(int i = 0; i < playersName.length; i++)
        {
            for(int j = 0; j < playersName.length; j++) {
                if(playersName[i].hashCode() != playersName[j].hashCode()) {
                    if(playersName[i].length() > playersName[j].length()) {
                        String temp = playersName[j];
                        playersName[j] = playersName[i];
                        playersName[i] = temp;
                        System.out.println(Arrays.toString(playersName));
                    }
                }
            }
        }
        return playersName;
    }
}