package com.example.gofishgui.fish;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class FishHand extends LinearLayout implements View.OnClickListener {
    private Context c; // context
    private ImageView[] pc; // image views for human cards
    private Button[] b; // button array
    private int value; // card value that was asked for
    private String rank; // card rank that was asked for
    private Button lastClickedButton;
    ArrayList<FishCard> currHand; // arraylist for the hand
    ArrayList<FishCard> otherHand; // arraylist for the hand
    FishActionObject fishActionObject; // instance of FishActionObject

    // FishHand constructor
    // FishHand constructor
    public FishHand(Context c, ImageView[] pc, Button[] b, ArrayList<FishCard> currHand, ArrayList<FishCard> otherHand) {
        super(c);
        this.c = c;
        this.pc = pc;
        this.b = b;
        this.currHand = currHand; // current player's hand
        this.otherHand = otherHand; // other player's hand
        this.fishActionObject = new FishActionObject(currHand, otherHand); // create instance of FishActionObject
        for (int i = 0; i < pc.length; i++) {
            pc[i].setOnClickListener(this);
            b[i].setOnClickListener(this);
            b[i].setVisibility(INVISIBLE);
        }
        setOnClickListener(this);

        // (TEST) SOP hands before asking for card
        System.out.print("Current hand before ask: ");
        for (FishCard card : currHand) {
            System.out.print(card.getValue() + " ");
        }
        System.out.println(" ");
        System.out.print("Other hand before ask: ");
        for (FishCard card : otherHand) {
            System.out.print(card.getValue() + " ");
        }
        System.out.println(" ");
    }


    // OnClickListener method
    @Override
    public void onClick(View v) {
        if (v instanceof ImageView) { // if card is clicked
            for (int i = 0; i < pc.length; i++) {
                if (v == pc[i]) {
                    b[i].setVisibility(VISIBLE); // show a button
                    lastClickedButton = b[i];
                } else {
                    b[i].setVisibility(INVISIBLE);
                }
            }
        } else if (v instanceof Button) { // if the button is clicked
            for (int i = 0; i < b.length; i++) {
                if (v == b[i]) { // go through button array and find card value that was asked for
                    switch(i) {
                        case 0:
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                            // get the card value
                            value = currHand.get(i).getValue();
                            // call askForCard() method on fishActionObject
                            fishActionObject.askForCard(value);

                            // (TEST) SOP hands after asking for a card
                            System.out.print("Current hand after ask: ");
                            for (FishCard card : currHand) {
                                System.out.print(card.getValue() + " ");
                            }
                            System.out.println(" ");
                            System.out.print("Other hand after ask: ");
                            for (FishCard card : otherHand) {
                                System.out.print(card.getValue() + " ");
                            }
                            System.out.println(" ");
                            break;
                    }
                }
            }
            lastClickedButton.setVisibility(INVISIBLE);
            lastClickedButton = null;
        } else { // if card is not clicked
            for (int i = 0; i < b.length; i++) {
                b[i].setVisibility(INVISIBLE);
            }
            if (lastClickedButton != null) {
                lastClickedButton.setVisibility(INVISIBLE);
                lastClickedButton = null;
            }
        }
    }
}





