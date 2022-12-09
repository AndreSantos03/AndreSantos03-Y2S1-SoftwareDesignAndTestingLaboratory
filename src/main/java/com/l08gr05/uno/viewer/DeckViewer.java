package com.l08gr05.uno.viewer;

import com.l08gr05.uno.Gui;
import com.l08gr05.uno.decks_cards.Card;
import com.l08gr05.uno.decks_cards.Deck;

import java.io.IOException;

public class DeckViewer {
    public void draw(Gui gui, Deck deck) throws IOException {
        gui.drawImage(0,0,deck.get_deckList().get(0).get_pngName());
    }
}
