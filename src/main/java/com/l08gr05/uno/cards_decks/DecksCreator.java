package com.l08gr05.uno.cards_decks;

import java.util.*;

public class DecksCreator {

    public Deque<Card> inTableDeck;
    public Queue<Card> playedDeck;
    public Set<Card> playerDeck;
    public Set<Card> cpuDeck;

    public DecksCreator() {
        List<String> coloredTypeList = Arrays.asList("1","2","3","4","5","6","7","8","9","plustwo","stop","reverse","block");
        List<String> blackTypeList = Arrays.asList("plusfour", "changecolor");
        List<String> colorsList =  Arrays.asList("red", "blue", "yellow", "green");

        List<Card> cardList = new ArrayList<>();

        for(String color:colorsList){
            //0s are created apart because there's only one instance of each of them
            cardList.add(new Card(color,"0"));
            for(String type : coloredTypeList){
                cardList.add(new Card(color,type));
                cardList.add(new Card(color,type));
            }
        }

        for(String type : blackTypeList){
            cardList.add(new Card(type));
            cardList.add(new Card(type));
            cardList.add(new Card(type));
            cardList.add(new Card(type));
        }

        Collections.shuffle(cardList);
        inTableDeck = new ArrayDeque<Card>(cardList);
        playedDeck.add(inTableDeck.pollLast());

        //Create CPus Deck
         for(int i = 1; i <= 7; i++){
                cpuDeck.add(inTableDeck.pollLast());
                System.out.println();
            }

         //Create Users Deck
         for(int i = 1; i <= 7; i++){
             playerDeck.add(inTableDeck.pollLast());
         }

    }

}
