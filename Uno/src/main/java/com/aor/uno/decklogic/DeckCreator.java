package com.aor.uno.decklogic;

import com.aor.uno.cards.Card;

import java.util.*;

public class DeckCreator {

    private Deque<Card> inTableDeck;
    private Set<Card> playerDeck;
    private Set<Card> cpuDeck;

    public void tableDeckInitializer() {
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
        this.inTableDeck = new ArrayDeque<Card>(cardList);
    }

    public void cpuDeckInitializer(){
        for(int i = 1; i <= 7; i++){
            this.cpuDeck.add(this.inTableDeck.pollLast());
        }
    }
    public void playerDeckInitializer(){
        for(int i = 1; i <= 7; i++){
            this.playerDeck.add(this.inTableDeck.pollLast());
        }
    }

}
