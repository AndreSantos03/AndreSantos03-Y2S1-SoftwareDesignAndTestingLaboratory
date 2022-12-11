package com.l08gr05.uno.viewer;/*
package com.l08gr05.uno.viewer;

import com.l08gr05.uno.Gui;
import com.l08gr05.uno.decks_cards.Card;
import com.l08gr05.uno.decks_cards.Deck;

import java.awt.image.BufferedImage;
import java.io.IOException;

public class Viewer {
    private DeckViewer deckViewer;
    public Viewer() throws IOException {
        deckViewer = new DeckViewer();
    }
    public void step(Gui gui, Deck playerDeck, int cpuSize, BufferedImage topCardImg) throws IOException {
        gui.clear();
        deckViewer.drawCPU(gui,cpuSize);
        deckViewer.drawPlayer(gui, playerDeck);
        deckViewer.drawTop(gui,topCardImg);
        gui.refresh();
    }
}*/


import com.l08gr05.uno.GUI;

import java.io.IOException;

public abstract class Viewer<T> {
    private final T model;

    public Viewer(T model) {
        this.model = model;
    }

    public T getModel() {
        return model;
    }

    public void draw(GUI gui) throws IOException {
        gui.clear();
        drawElements(gui);
        gui.refresh();
    }

    protected abstract void drawElements(GUI gui) throws IOException;
}
