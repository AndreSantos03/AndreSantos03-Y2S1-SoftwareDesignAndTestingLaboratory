package com.l08gr05.uno.controller.game;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.l08gr05.uno.Application;
import com.l08gr05.uno.Game.Game;

public class DrawController extends GameController{
    public DrawController(Game game){
        super(game);
    }

    public void step(Application application, KeyStroke keyStroke){
        if (keyStroke.getKeyType() == KeyType.Enter){
            getModel().playerDrawCard();
        }
    }
}
