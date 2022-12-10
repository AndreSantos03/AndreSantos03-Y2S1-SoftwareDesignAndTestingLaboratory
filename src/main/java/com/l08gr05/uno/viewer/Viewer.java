package com.l08gr05.uno.viewer;

import com.l08gr05.uno.Gui;
import com.l08gr05.uno.decks_cards.Card;
import com.l08gr05.uno.decks_cards.Deck;

import java.io.IOException;

public class Viewer {
    private DeckViewer deckViewer;
    public Viewer() throws IOException {
        deckViewer = new DeckViewer();
    }
    public void step(Gui gui, Deck playerDeck, int cpuSize, Card topCard) throws IOException {
        gui.clear();
        deckViewer.drawCPU(gui,cpuSize);
        deckViewer.drawPlayer(gui, playerDeck);
        gui.refresh();
    }

}
