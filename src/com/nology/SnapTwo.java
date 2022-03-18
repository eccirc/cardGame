package com.nology;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SnapTwo extends CardDeck{

    private List<Player> players = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    private Player currentPlayer;
    private Player prevPlayer;
    private int turn = 2;
    private String message = "";


    public SnapTwo() {
    }

    public ArrayList<Card> dealCards(){
        ArrayList<Card> dealtCards = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            dealtCards.add(super.dealCard());
        }
        return dealtCards;
    }
    public void initPlayers(){
        System.out.println("Enter name for player 1:");
        players.add(new Player(dealCards(), scanner.next()));
        System.out.println("Enter name for player 2:");
        players.add(new Player(dealCards(), scanner.next()));
        scanner.nextLine();
    }
    public void setCurrentPlayer(){
        if(turn % 2 == 0){
            currentPlayer = players.get(0);
            prevPlayer = players.get(1);
        }
        else{
            currentPlayer = players.get(1);
            prevPlayer = players.get(0);

        }
    }
    public void takeTurn(Player player) throws IOException {
        System.out.println(player.getPlayerName() + ", press enter to lay a card");
        String enter =  scanner.nextLine();
        Card player1Card =  player.layCard();
        System.out.println(player.getPlayerName() + " laid: " + player1Card.getSymbol() + player1Card.getValue());
        turn ++;

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        long startTime = System.currentTimeMillis();
        int waitTime = 2000;
        while((System.currentTimeMillis() - startTime) < waitTime && !input.ready()){
        }
        if(input.ready()){
            message = input.readLine();
            input.close();
        }
        else {
           message = "";
        }
        System.out.println("Next player:");

    }
    public void playGame(){
        System.out.println("Player 1 press 's' and enter if you see a snap!");
        System.out.println("Player 2 press 'l' and enter if you see a snap!");

        super.shuffleDeck((int)(Math.random() * 10));
        initPlayers();
        setCurrentPlayer();
        try {
            takeTurn(currentPlayer);
        } catch (IOException e){
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
        while (true){
            setCurrentPlayer();
            try {
                takeTurn(currentPlayer);
            } catch (IOException e){
                System.out.println(Arrays.toString(e.getStackTrace()));
            }
            //  && Objects.equals(message, "s")
            if(currentPlayer.getLastPlayed().getValue() == prevPlayer.getLastPlayed().getValue()
                    && Objects.equals(message, "s") || Objects.equals(message, "l")){
                break;
            }


        }
        if (message == "s"){
            System.out.println(players.get(0).getPlayerName() + " wins!");

        } else System.out.println(players.get(1).getPlayerName() + " wins!");
    }
}
