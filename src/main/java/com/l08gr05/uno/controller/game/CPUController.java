package com.l08gr05.uno.controller.game;

import com.googlecode.lanterna.input.KeyType;
import com.l08gr05.uno.Application;
import com.l08gr05.uno.Game.Game;
import com.l08gr05.uno.controller.Controller;

public class CPUController extends GameController{
    public  CPUController(Game game){
        super(game);
    }
    public void step(Application application, KeyType keyStrokeType) {
        System.out.println("We got all the way here, look at us!");
    };
}
