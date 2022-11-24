package com.l08gr05.uno.decks;

import com.l08gr05.uno.cards.Card;

import java.util.*;

public class InTableDeck {
    private Deque<Card> deck;

    public InTableDeck(){
        deck = new ArrayDeque<>();
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
        deck = new ArrayDeque<Card>(cardList);
    }

    public Card drawCard(){
        return deck.pollLast();
    }

    public List<Card> drawListCards(int n){
        List<Card> rList = new ArrayList();
        for(int i = 1; i <= n; i++){
            rList.add(drawCard());
        }
        return rList;
    }

    public Card drawFirst(){
        Card card_selected = drawCard();
        while(!card_selected.isNumber()){
            deck.addFirst(card_selected);
            card_selected = drawCard();
        }
        return card_selected;
    }

    public boolean singleCardLeft(){
        return deck.size() == 1;
    }
}
