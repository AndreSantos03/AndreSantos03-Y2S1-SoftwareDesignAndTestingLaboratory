package com.l08gr05.uno.gamelogic;

import com.l08gr05.uno.cards.Card;
import com.l08gr05.uno.decks.InTableDeck;
import com.l08gr05.uno.decks.StackDeck;
import com.l08gr05.uno.decks.PlayerDeck;
import com.l08gr05.uno.gui.LanternaBasics;

import java.io.IOException;

public class Game{

    private InTableDeck inTableDeck;
    private StackDeck playedDeck;
    private PlayerDeck userDeck;
    private PlayerDeck cpuDeck;

    private LanternaBasics gui;


    public Game() throws IOException {

        //DecksCreation
        inTableDeck = new InTableDeck();
        userDeck = new PlayerDeck(inTableDeck.drawListCards(7));
        cpuDeck = new PlayerDeck(inTableDeck.drawListCards(7));
        playedDeck = new StackDeck(inTableDeck.drawFirst());

        gui = new LanternaBasics(1920, 1080);
        run();
    }

    public void run(){
        while(true){
            for(Card card: )
        }
    }
}
