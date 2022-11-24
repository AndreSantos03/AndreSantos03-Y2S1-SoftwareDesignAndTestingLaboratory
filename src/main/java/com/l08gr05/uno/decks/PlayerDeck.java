package com.l08gr05.uno.decks;

import com.l08gr05.uno.cards.Card;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PlayerDeck {
    private Set<Card> deck;

    public PlayerDeck(){
        deck = new HashSet<Card>();
    }

    public void add(Card card){
        deck.add(card);
    }

    public boolean remove(Card card){
        if(deck.contains(card)) {
            deck.remove(card);
            return true;
        }
        return false;
    }
}
