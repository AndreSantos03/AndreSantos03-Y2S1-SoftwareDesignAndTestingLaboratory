package com.l08gr05.uno.gamelogic;

import com.l08gr05.uno.decks.InTableDeck;
import com.l08gr05.uno.decks.StackDeck;
import com.l08gr05.uno.decks.PlayerDeck;

public class Game {

    private InTableDeck inTableDeck;
    private StackDeck playedDeck;
    private PlayerDeck userDeck;
    private PlayerDeck cpuDeck;

    public Game(){
        inTableDeck = new InTableDeck();
        playedDeck = new StackDeck(inTableDeck.drawFirst());
        userDeck = new PlayerDeck();
        cpuDeck = new PlayerDeck();

        for(int i = 1; i <= 7; i++){
            userDeck.add(inTableDeck.drawCard());
            cpuDeck.add(inTableDeck.drawCard());
        }
    }
}
