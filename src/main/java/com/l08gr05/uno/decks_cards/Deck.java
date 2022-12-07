package com.l08gr05.uno.decks_cards;

import java.util.ArrayList;
import java.util.List;

public class Deck {
    protected List<Card> deckList;

    public Deck(){
        deckList = new ArrayList<>();
    }
    public Deck(List<Card> cardList){
        deckList = new ArrayList<>(cardList);
    }

    public void addCard(Card addedCard){
        deckList.add(addedCard);
    }
    public void addCards(List<Card> addedListCards){
        deckList.addAll(addedListCards);
    }
    //to be used for when restacking
    public void addBottom(List<Card> listCards){
        for(Card card:listCards){
            deckList.add(0,card);
        }
    }

    public Card drawTop(){
        Card drawnCard = deckList.get(deckList.size() - 1) ;
        deckList.remove(drawnCard);
        return drawnCard;
    }
    public List<Card> drawTop(int n){
        List<Card> rList = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            rList.add(drawTop());
        }
        return rList;
    }


    public List<Card> getDeck(){
        return deckList;
    }
}
