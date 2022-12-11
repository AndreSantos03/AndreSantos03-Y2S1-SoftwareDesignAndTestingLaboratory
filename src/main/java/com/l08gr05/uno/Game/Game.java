package com.l08gr05.uno.Game;

import com.l08gr05.uno.decks_cards.Card;
import com.l08gr05.uno.decks_cards.Deck;
import com.l08gr05.uno.decks_cards.StackDeck;

import java.io.IOException;

public class Game {
    private Deck stackDeck;
    private Deck playedDeck;
    private Deck playerDeck;
    private Deck cpuDeck;

    public Game() throws IOException {
        stackDeck = new StackDeck();
        playedDeck = new Deck(stackDeck.drawFirst());
        playerDeck = new Deck(stackDeck.drawTop(7));
        cpuDeck = new Deck(stackDeck.drawTop(7));
    }

    public Deck get_stackDeck(){
        return stackDeck;
    }
    public Deck get_playerDeck(){
        return playerDeck;
    }
    public Deck get_cpuDeck(){
        return get_cpuDeck();
    }
    public Card get_topCard(){
        return playerDeck.getTop();
    }
}
