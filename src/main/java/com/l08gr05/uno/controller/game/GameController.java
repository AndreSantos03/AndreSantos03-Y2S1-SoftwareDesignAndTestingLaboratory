package com.l08gr05.uno.controller.game;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.l08gr05.uno.Application;
import com.l08gr05.uno.Game.Game;
import com.l08gr05.uno.controller.Controller;

public class GameController extends Controller<Game> {
    public GameController(Game game) {
        super(game);
        game.get_playerDeck().get_deckList().get(0).setIsSelected(true);
    }
    public void step(Application application,KeyStroke keyStroke){
        if(keyStroke!=null){
            if(keyStroke.getKeyType() == KeyType.Escape){
                application.setState(null);
            }
        }
    }
}
