package com.l08gr05.uno.controller.game;


import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.l08gr05.uno.Application;
import com.l08gr05.uno.Game.Game;

public class PlayerController extends GameController{
    private int indexSelected;
    public PlayerController(Game game){
        super(game);
        indexSelected = 0;
        setSelectStatus(0,true);
    }
    private void setSelectStatus(int index, boolean status){
        getModel().get_playerDeck().get(index).setIsSelected(status);
    }

    private void playCard(){
        getModel().get_playedDeck().addTop(getModel().get_playerDeck().remove(indexSelected));
        indexSelected = 0;
        FlowController.setPlayerTurn(false);
    }

    public void step(Application application, KeyStroke keyStroke) {
        if (keyStroke != null){
            if (keyStroke.getKeyType() == KeyType.ArrowRight && indexSelected != getModel().get_playerDeck().size() - 1) {
                setSelectStatus(indexSelected, false);
                indexSelected++;
                setSelectStatus(indexSelected, true);
            } else if (keyStroke.getKeyType() == KeyType.ArrowLeft && indexSelected != 0) {
                setSelectStatus(indexSelected, false);
                indexSelected--;
                setSelectStatus(indexSelected, true);
            } else if(keyStroke.getKeyType() == KeyType.Enter && getModel().get_playedDeck().getTop().canCardBePlayedOver(getModel().get_playerDeck().get(indexSelected))){
                playCard();
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