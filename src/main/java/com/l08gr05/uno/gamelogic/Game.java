package com.l08gr05.uno.gamelogic;

import com.l08gr05.uno.decks.InTableDeck;
import com.l08gr05.uno.decks.StackDeck;
import com.l08gr05.uno.decks.PlayerDeck;

public class Game{

    private InTableDeck inTableDeck;
    private StackDeck playedDeck;
    private PlayerDeck userDeck;
    private PlayerDeck cpuDeck;

    public Game(){

        //DecksCreation
        inTableDeck = new InTableDeck();
        userDeck = new PlayerDeck(inTableDeck.drawListCards(7));
        cpuDeck = new PlayerDeck(inTableDeck.drawListCards(7));
        playedDeck = new StackDeck(inTableDeck.drawFirst());
    }

    public void run(){
        while(true){
            
        }
    }
}
