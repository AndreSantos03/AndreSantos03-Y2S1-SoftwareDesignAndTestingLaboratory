package com.l08gr05.uno.controller.game;


import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.l08gr05.uno.Application;
import com.l08gr05.uno.Game.Game;

public class PlayerController extends GameController {
    private int indexSelected;
    private CPUController cpuController;
    public PlayerController(Game game) {
        super(game);
        cpuController = new CPUController(game);
        indexSelected = 0;
        getModel().setSelectStatus(indexSelected,true);
    }

    @Override
    public void step(Application application, KeyStroke keyStroke) {
        if (keyStroke.getKeyType() == KeyType.ArrowRight && indexSelected != getModel().get_playerDeck().size() - 1) {
            getModel().setSelectStatus(indexSelected, false);
            indexSelected++;
            getModel().setSelectStatus(indexSelected, true);
        } else if (keyStroke.getKeyType() == KeyType.ArrowLeft && indexSelected != 0) {
            getModel().setSelectStatus(indexSelected, false);
            indexSelected--;
            getModel().setSelectStatus(indexSelected, true);
        } else if (keyStroke.getKeyType() == KeyType.Enter && getModel().playCardPlayer(indexSelected)) {
            indexSelected = 0;
            getModel().setSelectStatus(indexSelected, true);
            cpuController.step(application,keyStroke);
        }
    }
}