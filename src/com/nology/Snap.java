package com.nology;

import java.util.Random;
import java.util.Scanner;

public class Snap extends CardDeck{
    private Scanner scanner = new Scanner(System.in);
    private Card laidCard;
    private Card prevCard = new Card("", "", 0);
    private boolean isSnap = false;

    public Snap() {}

    public void takeTurn(){
        scanner.nextLine();
        laidCard = super.dealCard();
        System.out.println("top card: " + laidCard.getSymbol() + laidCard.getValue() + " " + laidCard.getSuit());
        if(laidCard.getValue() == prevCard.getValue()){
            System.out.println("top card: " + laidCard.getSymbol() + laidCard.getValue() + " " + laidCard.getSuit());
            System.out.println("prev card: " + prevCard.getSymbol() + prevCard.getValue() + " " + prevCard.getSuit());
            isSnap = true;
        }

    }
    public void playGame(){
        super.shuffleDeck((int)(Math.random() * 10));
        System.out.println("Press the Enter key to start laying cards: ");
        this.takeTurn();
        while(!isSnap){
            this.takeTurn();
            prevCard = laidCard;
            if(super.getCardDeck().size() == 0){
                super.makeDeck();
                super.shuffleDeck((int)(Math.random() * 10));
            }
        }
       System.out.println("Snap!");
    }
}
