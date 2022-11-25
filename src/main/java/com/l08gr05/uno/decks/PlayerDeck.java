package com.l08gr05.uno.decks;

import com.l08gr05.uno.cards.Card;

import java.util.*;

public class PlayerDeck {
    private List<Card> deck;

    public List<Card> getDeck() {
        return this.deck;
    }

    public PlayerDeck(List<Card> list){
        deck = new ArrayList<>(list);
    }

    public void add(Card card){
        deck.add(card);
    }

    public void remove(Card card){
        deck.remove(card);
    }
}
