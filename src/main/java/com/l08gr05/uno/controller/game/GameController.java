package com.l08gr05.uno.controller.game;


import com.googlecode.lanterna.input.KeyType;
import com.l08gr05.uno.Application;
import com.l08gr05.uno.Game.Game;
import com.l08gr05.uno.controller.Controller;
import com.l08gr05.uno.decks_cards.Card;
import com.l08gr05.uno.decks_cards.Deck;

public class GameController extends Controller {
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
    public void step(Application application, KeyType keyStrokeType){
        if(keyStrokeType == KeyType.Escape){
            application.setState(null);
        }
        if(keyStrokeType == KeyType.ArrowRight && indexSelected != playerDeck.size() ){
            getIndexCard().setIsSelected(false);
            indexSelected++;
            getIndexCard().setIsSelected(true);
        }
        else if(keyStrokeType==KeyType.ArrowLeft && indexSelected != 0){
            getIndexCard().setIsSelected(false);
            indexSelected--;
            getIndexCard().setIsSelected(true);
        }
        else if(keyStrokeType == KeyType.Enter){
            playerPlayCard();
        }
    }
    private void playerPlayCard(){
        getIndexCard().setIsSelected(false);
        playedDeck.addTop(playerDeck.remove(indexSelected));
        playerDeck.remove(indexSelected);
        indexSelected = 0;
        getIndexCard().setIsSelected(true);
    }

    private Card getIndexCard(){
        return playerDeck.get_deckList().get(indexSelected);
    }
}