package com.l08gr05.uno.viewer;

import com.l08gr05.uno.Gui;
import com.l08gr05.uno.decks_cards.Card;
import com.l08gr05.uno.decks_cards.Deck;

import java.io.IOException;
import java.util.List;

public class DeckViewer {
    public void draw(Gui gui, Deck deck) throws IOException {
        List<Card> deckList = deck.get_deckList();
        int x = gui.get_terminalWidth() / 12;
        int y = gui.get_terminalHeight() * 3/4;
        int xInc = gui.get_terminalWidth() * 10 / 12 / deckList.size();
        for(Card card : deckList){
            gui.drawImage(x,y,card.get_pngName());
            x += xInc;
        }
    }
}
