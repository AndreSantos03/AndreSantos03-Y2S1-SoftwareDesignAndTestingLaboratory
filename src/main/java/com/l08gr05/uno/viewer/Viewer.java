package com.l08gr05.uno.viewer;

import com.l08gr05.uno.Gui;
import com.l08gr05.uno.decks_cards.Deck;

import java.io.IOException;

public class Viewer {
    private DeckViewer deckViewer;
    public Viewer(){
        deckViewer = new DeckViewer();
    }
    public void step(Gui gui, Deck playerDeck) throws IOException {
        gui.clear();
        deckViewer.draw(gui, playerDeck);
        gui.refresh();
    }

}
