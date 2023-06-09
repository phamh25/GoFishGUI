package com.example.gofishgui.fish;

import com.example.gofishgui.activities.MainActivity;

import java.util.ArrayList;

public class FishSmartAI {

    private ArrayList<FishCard> humanHand;
    private ArrayList<FishCard> computerHand;
    private ArrayList<FishCard> deck;
    int value;
    FishActionObject fishActionObject;
    private MainActivity mainActivity;

    public FishSmartAI(ArrayList<FishCard> humanHand, ArrayList<FishCard> computerHand, ArrayList<FishCard> deck,
                       MainActivity mainActivity) {
        this.humanHand = humanHand;
        this.computerHand = computerHand;
        this.deck = deck;
        this.fishActionObject = new FishActionObject(humanHand, computerHand, deck);
        this.mainActivity = mainActivity;

    }
    public boolean dumbAsk() {
        value = 1; //Implement later
        fishActionObject.askForCard(value, 1);

        System.out.print("Computer hand after ask: ");
        for (FishCard card : computerHand) {
            System.out.print(card.getValue() + " ");
        }
        System.out.println(" ");
        System.out.print("User hand after ask: ");
        for (FishCard card : humanHand) {
            System.out.print(card.getValue() + " ");
        }
        System.out.println(" ");

        return true;
    }

}
