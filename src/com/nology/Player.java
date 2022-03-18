package com.nology;

import java.util.ArrayList;

public class Player {
    private ArrayList<Card> playerCards = new ArrayList<>();
    private String playerName;
    private Card lastPlayed;

    public Player(ArrayList<Card> playerCards, String playerName) {
        this.playerCards = playerCards;
        this.playerName = playerName;
    }

    public String getPlayerName() {
        return playerName;
    }

    public ArrayList<Card> getPlayerCards() {
        return playerCards;
    }

    public Card layCard(){
        lastPlayed = playerCards.get(playerCards.size() - 1);
        playerCards.remove(playerCards.size() - 1);
        return lastPlayed;
    }

    public Card getLastPlayed() {
        return lastPlayed;
    }
}
