package com.l08gr05.uno.controller.game;


import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.l08gr05.uno.Application;
import com.l08gr05.uno.Game.Game;
import com.l08gr05.uno.controller.Controller;
import com.l08gr05.uno.decks_cards.Deck;

public class GameController extends Controller<Game>{
    private int indexSelected = 0;
    private Deck stackDeck;
    private Deck playerDeck;
    private Deck cpuDeck;
    private Deck playedDeck;

    public GameController(Game game){
        super(game);
        stackDeck = game.get_stackDeck();
        playedDeck = game.get_playedDeck();
        playerDeck = game.get_playerDeck();
        cpuDeck = game.get_cpuDeck();
        playerDeck.get_deckList().get(indexSelected).setIsSelected(true);
    }
    @Override
    public void step(Application application, KeyStroke keyStroke){
        if(keyStroke.getKeyType() == KeyType.Escape){
            application.setState(null);
        }
        if(keyStroke.getKeyType() == KeyType.ArrowRight && indexSelected != playerDeck.size() ){
            playerDeck.get_deckList().get(indexSelected).setIsSelected(false);
            indexSelected++;
            playerDeck.get_deckList().get(indexSelected).setIsSelected(true);
        }
        else if(keyStroke.getKeyType()==KeyType.ArrowLeft && indexSelected != 0){
            playerDeck.get_deckList().get(indexSelected).setIsSelected(false);
            indexSelected--;
            playerDeck.get_deckList().get(indexSelected).setIsSelected(true);
        }
    }
}
