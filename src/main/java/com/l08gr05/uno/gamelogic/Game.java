package com.l08gr05.uno.gamelogic;

import com.l08gr05.uno.decks.InTableDeck;
import com.l08gr05.uno.decks.StackDeck;
import com.l08gr05.uno.decks.PlayerDeck;

public class Game1 {

    private InTableDeck inTableDeck;
    private StackDeck playedDeck;
    private PlayerDeck userDeck;
    private PlayerDeck cpuDeck;

    public Game1(){
        inTableDeck = new InTableDeck();
        playedDeck = new StackDeck(inTableDeck.drawFirst());
        userDeck = new PlayerDeck(InTableDeck.drawCards(7));
        cpuDeck = new PlayerDeck(InTableDeck.drawCards(7));
    }
}
