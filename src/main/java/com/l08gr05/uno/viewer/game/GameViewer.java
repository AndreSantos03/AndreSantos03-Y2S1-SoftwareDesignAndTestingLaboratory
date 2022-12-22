package com.l08gr05.uno.viewer.game;

import com.l08gr05.uno.GUI;
import com.l08gr05.uno.Game.Game;
import com.l08gr05.uno.controller.game.FlowController;
import com.l08gr05.uno.decks_cards.Card;
import com.l08gr05.uno.viewer.Viewer;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.Flow;

public class GameViewer extends Viewer<Game> {
    public GameViewer(Game game){super(game);}
    @Override
    public void drawElements(GUI gui) throws IOException {
        drawPlayer(gui);
        drawCPU(gui);
        drawTop(gui);
        if(getModel().get_colorChooser() && getModel().get_playerTurn()){
            drawColorChooser(gui);
        }
//        gui.drawUI();
    }

    private void drawPlayer(GUI gui) throws IOException {
        List<Card> deckList = getModel().get_playerDeck().get_deckList();
        int x = gui.get_terminalWidth() / 12;
        int y = gui.get_terminalHeight() * 4/5;
        int xInc = gui.get_terminalWidth() * 10 / 12 / deckList.size();
        for(Card card : deckList){
            if(card.get_isSelected() && getModel().get_playerTurn() && !getModel().get_colorChooser()){
                gui.drawHighlight(x,y,Card.getWidth(),Card.getHeight());
            }
            gui.drawImage(x,y,card.get_image());
            x += xInc;
        }
    }
/*    private void drawCPU(GUI gui) throws IOException {
        int size = getModel().get_cpuDeck().size();
        int x = gui.get_terminalWidth() / 12;
        int y = gui.get_terminalHeight() * 1/8;
        int xInc = gui.get_terminalWidth() * 10 / 12 / size;
        for(int i = 1; i <= size;i++){
            gui.drawImage(x,y,Card.getBackImage());
            x += xInc;
        }
    }*/

    private void drawCPU(GUI gui) throws IOException {
        List<Card> deckList = getModel().get_cpuDeck().get_deckList();
        int x = gui.get_terminalWidth() / 12;
        int y = gui.get_terminalHeight() * 1 / 8;
        int xInc = gui.get_terminalWidth() * 10 / 12 / deckList.size();
        for (Card card : deckList) {
            if (card.get_isSelected()) {
                gui.drawHighlight(x, y, Card.getWidth(), Card.getHeight());
            }
            gui.drawImage(x, y, card.get_image());
            x += xInc;
        }
    }
    private void drawColorChooser(GUI gui){
        int increment = (gui.get_terminalWidth() - gui.get_terminalWidth() / 5) / 4;
        gui.drawSquare(gui.get_terminalWidth()/5 - gui.get_cardHeight() / 2, gui.get_terminalHeight()*3/5, gui.get_cardHeight(), "red");
        gui.drawSquare(gui.get_terminalWidth()/5 - gui.get_cardHeight() / 2 +increment, gui.get_terminalHeight()*3/5, gui.get_cardHeight(), "green");
        gui.drawSquare(gui.get_terminalWidth()/5 - gui.get_cardHeight() / 2 + 2 * increment, gui.get_terminalHeight()*3/5, gui.get_cardHeight(), "blue");
        gui.drawSquare(gui.get_terminalWidth()/5 - gui.get_cardHeight() / 2 + 3 * increment, gui.get_terminalHeight()*3/5, gui.get_cardHeight(), "yellow");
        switch( getModel().get_indexColorChooser()){
            case 0:
                gui.drawHighlight(gui.get_terminalWidth()/5 - gui.get_cardHeight() / 2, gui.get_terminalHeight()*3/5, gui.get_cardHeight(),gui.get_cardHeight());
                break;
            case 1:
                gui.drawHighlight(gui.get_terminalWidth()/5 - gui.get_cardHeight() / 2 +increment, gui.get_terminalHeight()*3/5, gui.get_cardHeight(),gui.get_cardHeight());
                break;
            case 2:
                gui.drawHighlight(gui.get_terminalWidth()/5 - gui.get_cardHeight() / 2 + 2 * increment, gui.get_terminalHeight()*3/5, gui.get_cardHeight(),gui.get_cardHeight());
                break;
            case 3:
                gui.drawHighlight(gui.get_terminalWidth()/5 - gui.get_cardHeight() / 2 + 3 * increment, gui.get_terminalHeight()*3/5, gui.get_cardHeight(),gui.get_cardHeight());
        }
    }
    private void drawTop(GUI gui) throws IOException {
        BufferedImage img = getModel().get_playedDeck().getTop().get_image();
        gui.drawImage(gui.get_terminalWidth()/2 - Card.getWidth()/2, gui.get_terminalHeight()/2 - Card.getHeight()/2,img);
    }

}
