package com.nology;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class CardDeck {
    private ArrayList<Card> deckOfCards = new ArrayList<>();

    public CardDeck() {
        this.makeDeck();
    }

    public void makeDeck(){
        String[] suits = {"diamonds", "hearts", "clubs", "spades"};
        String[] symbols = {"♦", "♥", "♣", "♠"};
        int[] values = {2,3,4,5,6,7,8,9,10,11,12,13,14};
        for (int i = 0; i < suits.length; i++) {
            for (int j = 0; j < values.length; j++) {
                deckOfCards.add(new Card(suits[i],symbols[i], values[j]));
            }
        }
    }

    public List<Card> getCardDeck() {
        return deckOfCards;
    }
    public Card dealCard(){
        Card topCard = deckOfCards.get(deckOfCards.size() - 1);
        deckOfCards.remove(deckOfCards.size() - 1);
        return topCard;

    }
    public ArrayList<Card> sortDeckInNumberOrder(){
        deckOfCards.sort(Card.compareByValue);
        return this.deckOfCards;

    }
    public ArrayList<Card> sortDeckIntoSuits(){
        deckOfCards.sort(Card.compareBySuit);
        return this.deckOfCards;

    }
    public ArrayList<Card> shuffleDeck(int seed){
        Collections.shuffle(deckOfCards, new Random(seed));
        return this.deckOfCards;
    }
}
