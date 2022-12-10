package com.l08gr05.uno.state;

import com.l08gr05.uno.Gui;
import com.l08gr05.uno.decks_cards.Deck;
import com.l08gr05.uno.decks_cards.StackDeck;
import com.l08gr05.uno.viewer.Viewer;

import java.io.IOException;

public class State{
    private Viewer viewer;
    private Deck playedDeck;
    private Deck playerDeck;
    private Deck cpuDeck;
    private Deck stackDeck;


    public State() throws IOException {
        viewer = new Viewer();

        stackDeck = new StackDeck();
        playedDeck = new Deck(stackDeck.drawTop(7));
        playerDeck = new Deck(stackDeck.drawTop(7));
        cpuDeck = new Deck(stackDeck.drawTop(7));
    }

    public void step(Gui gui) throws Exception {
        viewer.step(gui, playerDeck);
    }
}
