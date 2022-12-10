package com.l08gr05.uno.viewer;

import com.l08gr05.uno.Gui;
import com.l08gr05.uno.decks_cards.Card;
import com.l08gr05.uno.decks_cards.Deck;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;

public class DeckViewer {

    public void drawPlayer(Gui gui, Deck deck) throws IOException {
        List<Card> deckList = deck.get_deckList();
        int x = gui.get_terminalWidth() / 12;
        int y = gui.get_terminalHeight() * 3/4;
        int xInc = gui.get_terminalWidth() * 10 / 12 / deckList.size();
        for(Card card : deckList){
            gui.drawImage(x,y,card.get_image());
            x += xInc;
        }
    }
    public void drawCPU(Gui gui, int size) throws IOException {
        int x = gui.get_terminalWidth() / 12;
        int y = gui.get_terminalHeight() * 1/8;
        int xInc = gui.get_terminalWidth() * 10 / 12 / size;
        for(int i = 1; i <= size;i++){
            gui.drawImage(x,y,Card.getBackImage());
            x += xInc;
        }
    }
    public void drawTop(Gui gui, BufferedImage img) throws IOException {
        gui.drawImage(gui.get_terminalWidth()/2 - Card.getWidth()/2, gui.get_terminalHeight()/2 - Card.getHeight()/2,img);
    }
}
