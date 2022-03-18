package com.nology;
import java.util.Comparator;

public class Card {
    private String suit;
    private String symbol;
    private int value;

    public Card(String suit, String symbol, int value) {
        this.suit = suit;
        this.symbol = symbol;
        this.value = value;
    }
    public String getSuit() {
        return suit;
    }
    public String getSymbol() {
        return symbol;
    }
    public int getValue() {
        return value;
    }
    public static Comparator<Card> compareBySuit = new Comparator<Card>() {
        @Override
        public int compare(Card o1, Card o2) {
            String suit1 = o1.getSuit();
            String suit2 = o2.getSuit();

            return  suit1.compareTo(suit2);
        }
    };

    public static Comparator<Card> compareByValue = new Comparator<Card>() {
        @Override
        public int compare(Card o1, Card o2) {
            int val1 = o1.getValue();
            int val2 = o2.getValue();

            return  val1 - val2;
        }
    };


    @Override
    public String toString() {
        return'{' +
                "suit: " + suit +
                ", symbol:  " + symbol +
                ", value: " + value + "}";
    }
}
