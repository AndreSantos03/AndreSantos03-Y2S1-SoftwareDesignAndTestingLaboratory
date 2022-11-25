package com.l08gr05.uno.decks;

import com.l08gr05.uno.cards.Card;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PlayerDeck {
    private List<Card> deck;

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
