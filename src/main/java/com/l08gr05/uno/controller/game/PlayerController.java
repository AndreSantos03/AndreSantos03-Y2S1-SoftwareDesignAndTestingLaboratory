package com.l08gr05.uno.controller.game;


import com.googlecode.lanterna.input.KeyType;
import com.l08gr05.uno.Application;
import com.l08gr05.uno.Game.Game;

public class PlayerController extends GameController {
    private int indexSelected;
    private CPUController cpuController;
    private Game game;
    public PlayerController(Game game) {
        super(game);
        this.game = game;
        indexSelected = 0;
        getModel().setSelectStatus(indexSelected,true);
    }

    @Override
    public void step(Application application, KeyType keyStrokeType) {
        if (keyStrokeType == KeyType.ArrowRight && indexSelected != getModel().get_playerDeck().size() - 1) {
            getModel().setSelectStatus(indexSelected, false);
            indexSelected++;
            getModel().setSelectStatus(indexSelected, true);
        } else if (keyStrokeType == KeyType.ArrowLeft && indexSelected != 0) {
            getModel().setSelectStatus(indexSelected, false);
            indexSelected--;
            getModel().setSelectStatus(indexSelected, true);
        } else if (keyStrokeType == KeyType.Enter && getModel().playCardPlayer(indexSelected)) {
            indexSelected = 0;
            getModel().setSelectStatus(indexSelected, true);
            cpuController = new CPUController(game);
            cpuController.step(application,keyStrokeType);
        }
    }
}