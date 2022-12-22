package com.l08gr05.uno.controller.game;


import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.l08gr05.uno.Application;
import com.l08gr05.uno.Game.Game;
import com.l08gr05.uno.decks_cards.Card;

import java.awt.event.KeyEvent;
import java.util.Set;

public class PlayerController extends GameController{
    private int indexSelected;
    private DrawController drawController;
    private PlayedCardController playedCardController;
    private ColorChooserController colorChooserController;
    private Boolean colorChooser;
    public PlayerController(Game game){
        super(game);
        drawController = new DrawController(game);
        playedCardController = new PlayedCardController(game);
        colorChooserController = new ColorChooserController(game);
        indexSelected = 0;
        setSelectStatus(0,true);
    }
    private void setSelectStatus(int index, boolean status){
        getModel().get_playerDeck().get(index).setIsSelected(status);
    }

    private void playCard(){
        setSelectStatus(indexSelected,false);
        playedCardController.set_playedCard(getModel().get_playerDeck().get(indexSelected));
        indexSelected = 0;
        setSelectStatus(indexSelected,true);
    }
    private boolean canCardBePlayed(){
        Boolean ret = false;
        for(Card card : getModel().get_playerDeck().get_deckList()){
            if(getModel().get_playedDeck().getTop().canCardBePlayedOver(card) || getModel().get_color() == card.get_color()){
                ret = true;
            }
        }
        return ret;
    }

    public void step(Application application, Set<Character> pressedKeys) {
        if(pressedKeys != null){
            if(getModel().get_colorChooser()){
                colorChooserController.step(application,pressedKeys);
            }
            else{
                if(canCardBePlayed()){
                    if (pressedKeys.contains(KeyEvent.VK_RIGHT) && indexSelected != getModel().get_playerDeck().size() - 1) {
                        setSelectStatus(indexSelected, false);
                        indexSelected++;
                        setSelectStatus(indexSelected, true);
                    } else if (pressedKeys.contains(KeyEvent.VK_LEFT) && indexSelected != 0) {
                        setSelectStatus(indexSelected, false);
                        indexSelected--;
                        setSelectStatus(indexSelected, true);
                    } else if(pressedKeys.contains(KeyEvent.VK_ENTER) && getModel().get_playedDeck().getTop().canCardBePlayedOver(getModel().get_playerDeck().get(indexSelected))){
                        playCard();
                        playedCardController.step(application,pressedKeys);
                    }
                }
                else{
                    drawController.step(application,pressedKeys);
                }
            }
        }

    }
//    private int indexSelected;
//    private CPUController cpuController;
//    public PlayerController(Game game) {
//        super(game);
//        cpuController = new CPUController(game);
//        indexSelected = 0;
//        getModel().setSelectStatus(indexSelected,true);
//    }
//
//    @Override
//    public void step(Application application, KeyStroke keyStroke) {
//        if (keyStroke.getKeyType() == KeyType.ArrowRight && indexSelected != getModel().get_playerDeck().size() - 1) {
//            getModel().setSelectStatus(indexSelected, false);
//            indexSelected++;
//            getModel().setSelectStatus(indexSelected, true);
//        } else if (keyStroke.getKeyType() == KeyType.ArrowLeft && indexSelected != 0) {
//            getModel().setSelectStatus(indexSelected, false);
//            indexSelected--;
//            getModel().setSelectStatus(indexSelected, true);
//        } else if (keyStroke.getKeyType() == KeyType.Enter && getModel().playCardPlayer(indexSelected)) {
//            indexSelected = 0;
//            getModel().setSelectStatus(indexSelected, true);
//            cpuController.step(application,keyStroke);
//        }
//    }
}