package com.l08gr05.uno.controller.game;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.l08gr05.uno.Application;
import com.l08gr05.uno.Game.Game;

public class FlowController extends GameController{
    private final PlayerController playerController;
    private final DrawController drawController;
    private boolean unplayable;
    private boolean colorChooser;
    public FlowController(Game game) {
        super(game);
        playerController = new PlayerController(game);
        drawController = new DrawController(game);
    }

    public void step(Application application, KeyStroke keyStroke) {
        getModel().setPlayerDraw();
        if(keyStroke!=null) {
            if (keyStroke.getKeyType() == KeyType.Escape) {
                application.setState(null);
            }
            if (getModel().get_playerDraw()) {
                drawController.step(application,keyStroke);
            } else {
                playerController.step(application, keyStroke);
            }
        }
    }
}
