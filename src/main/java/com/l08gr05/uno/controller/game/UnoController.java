package com.l08gr05.uno.controller.game;

import com.googlecode.lanterna.input.KeyType;
import com.l08gr05.uno.Application;
import com.l08gr05.uno.Game.Game;

public class UnoController extends GameController{
    private CPUController cpuController;
    private PlayerController playerController;
    public UnoController(Game game){
        super(game);
        playerController = new PlayerController(game);
        cpuController = new CPUController(game);
    }

    public  void step(Application application, KeyType keyStrokeType) {
        if (keyStrokeType == KeyType.Escape){
            application.setState(null);
        }
        playerController.step(application,keyStrokeType);
    }

    protected void cpuLogicTurn(Application application){
        cpuController.step(application);
    }
}
