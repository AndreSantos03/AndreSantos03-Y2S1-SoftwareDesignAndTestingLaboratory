package com.l08gr05.uno.controller.game;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.l08gr05.uno.Application;
import com.l08gr05.uno.Game.Game;

public class FlowController extends GameController{
    private static boolean playerTurn;
    private final PlayerController playerController;
    private final CPUController cpuController;

    public FlowController(Game game){
        super(game);
        playerController =  new PlayerController(game);
        cpuController = new CPUController(game);
        playerTurn = true;
    }
    protected static void setPlayerTurn(boolean turn){
        playerTurn = turn;
    }
    protected static boolean getPlayerTurn(){
        return playerTurn;
    }
    private GameController getController(){
        if(getPlayerTurn()){
            return playerController;
        }
        return cpuController;
    }
    @Override
    public void step(Application application, KeyStroke keyStroke){
        if(keyStroke != null && keyStroke.getKeyType() == KeyType.Escape){
            application.setState(null);
        }
        getController().step(application,keyStroke);
    }
}
