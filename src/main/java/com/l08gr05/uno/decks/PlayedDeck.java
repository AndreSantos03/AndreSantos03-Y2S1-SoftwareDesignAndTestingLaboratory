package com.l08gr05.uno.decks;

import com.l08gr05.uno.cards.Card;

import java.util.*;

public class PlayedDeck {

    private Queue<Card> deck;

    public Queue<Card> getDeck() {
        return this.deck;
    }

    public PlayedDeck(Card card){
        deck = new ArrayDeque<>();
        deck.add(card);
    }

    public void add(Card card){
        deck.add(card);
    }

    public List<Card> restack(Card card){
        List<Card> restackList= new ArrayList<>();
        while(deck.size() != 1){
            restackList.add(deck.poll());
        }
        return restackList;
    }
}
