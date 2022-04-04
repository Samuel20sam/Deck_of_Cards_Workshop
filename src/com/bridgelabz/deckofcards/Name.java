package com.bridgelabz.deckofcards;

public class Name
{
    String name;
    String[] cards;

    public Name (String name, int noOfCards) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String[] getCards() {
        return cards;
    }
}
