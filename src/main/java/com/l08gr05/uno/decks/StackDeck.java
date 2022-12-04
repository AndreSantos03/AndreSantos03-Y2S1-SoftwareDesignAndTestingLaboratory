package com.l08gr05.uno.decks;


import com.l08gr05.uno.cards.Card;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StackDeck extends Deck{
    public StackDeck(){
        List<String> coloredTypeList = Arrays.asList("1","2","3","4","5","6","7","8","9","plustwo","reverse","block");
        List<String> blackTypeList = Arrays.asList("plusfour", "changecolor");
        List<String> colorsList =  Arrays.asList("red", "blue", "yellow", "green");

        for(String color:colorsList){
            //0s are created apart because there's only one instance of each of them
            deckList.add(new Card(color,"0"));
            for(String type : coloredTypeList){
                deckList.add(new Card(color,type));
                deckList.add(new Card(color,type));
            }
        }

        for(String type : blackTypeList){
            deckList.add(new Card(type));
            deckList.add(new Card(type));
            deckList.add(new Card(type));
            deckList.add(new Card(type));
        }

        Collections.shuffle(deckList);
    }
}
