package com.l08gr05.uno.controller.game;

import com.googlecode.lanterna.input.KeyType;
import com.l08gr05.uno.Application;
import com.l08gr05.uno.Game.Game;

public class FlowController extends GameController{
    private final PlayerController playerController;
    public FlowController(Game game) {
        super(game);
        playerController = new PlayerController(game);
    }

    public void step(Application application, KeyType keyStrokeType) {
        if(keyStrokeType == KeyType.Escape){
            application.setState(null);
        }
        playerController.step(application,keyStrokeType);
    }
}
