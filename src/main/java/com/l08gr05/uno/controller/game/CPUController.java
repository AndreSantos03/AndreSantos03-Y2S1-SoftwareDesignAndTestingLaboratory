package com.l08gr05.uno.controller.game;

import com.googlecode.lanterna.input.KeyType;
import com.l08gr05.uno.Application;
import com.l08gr05.uno.Game.Game;
import com.l08gr05.uno.decks_cards.Card;

import java.util.List;

public class CPUController extends GameController{
    public CPUController(Game game){
        super(game);
    }
    @Override
    public void step(Application application, KeyType keyStrokeType){
        List<Card> cardsList = getModel().get_cpuDeck().get_deckList();
        Card sameColorSpecial;
        Card sameNumber;
        Card blackCard
        for(Card card : cardsList){

        }
    }
}
