package com.l08gr05.uno.controller.game;



import com.l08gr05.uno.Application;
import com.l08gr05.uno.Game.Game;
import com.l08gr05.uno.decks_cards.Card;

import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Set;

public class PlayerController extends GameController {
    private int indexSelected;
    private DrawController drawController;
    private PlayedCardController playedCardController;
    private ColorChooserController colorChooserController;


    public PlayerController(Game game) {
        super(game);
        drawController = new DrawController(game);
        playedCardController = new PlayedCardController(game);
        colorChooserController = new ColorChooserController(game);
        indexSelected = 0;
        setSelectStatus(0, true);
    }

    private void setSelectStatus(int index, boolean status) {
        getModel().get_playerDeck().get(index).setIsSelected(status);
    }

    private void playCard() {
        setSelectStatus(indexSelected, false);
        playedCardController.set_playedCard(getModel().get_playerDeck().get(indexSelected));
        indexSelected = 0;
        setSelectStatus(indexSelected, true);
    }

    private boolean canCardBePlayed() {
        Boolean ret = false;
        for (Card card : getModel().get_playerDeck().get_deckList()) {
            if (getModel().get_playedDeck().getTop().canCardBePlayedOver(card) || getModel().get_color() == card.get_color()) {
                ret = true;
            }
        }
        return ret;
    }
    private boolean isOneSelected(){
        for(Card card : getModel().get_playerDeck().get_deckList()){
            if(card.get_isSelected()){
                return true;
            }
        }
        return false;
    }
    public void step(Application application, Set<Integer> pressedKeys) throws IOException {
        if(!isOneSelected()){
            indexSelected = 0;
            setSelectStatus(indexSelected,true);
        }
        if (pressedKeys != null) {
            if (getModel().get_colorChooser()) {
                colorChooserController.step(application, pressedKeys);
            } else {
                if (canCardBePlayed()) {
                    getModel().set_playerDraw(false);
                    if (pressedKeys.contains(KeyEvent.VK_RIGHT) && indexSelected != getModel().get_playerDeck().size() - 1) {
                        setSelectStatus(indexSelected, false);
                        indexSelected++;
                        setSelectStatus(indexSelected, true);
                    } else if (pressedKeys.contains(KeyEvent.VK_LEFT) && indexSelected != 0) {
                        setSelectStatus(indexSelected, false);
                        indexSelected--;
                        setSelectStatus(indexSelected, true);
                    } else if (pressedKeys.contains(KeyEvent.VK_ENTER) && (getModel().get_playedDeck().getTop().canCardBePlayedOver(getModel().get_playerDeck().get(indexSelected)) || getModel().get_playerDeck().get(indexSelected).get_color() == getModel().get_color() )) {
                        if (getModel().get_playerDeck().size() == 1) {
                            //player won
                            application.setState(null);
                        }
                        playCard();
                        playedCardController.step(application, pressedKeys);
                    }
                } else {
                    getModel().set_playerDraw(true);
                    drawController.step(application, pressedKeys);
                }
            }
        }

    }
}
