package com.l08gr05.uno.gamelogic;

import com.l08gr05.uno.decks.PlayedDeck;
import com.l08gr05.uno.decks.PlayerDeck;
import com.l08gr05.uno.decks.StackDeck;

public class DecksHandler {
    private PlayedDeck playedDeck;
    private PlayerDeck playerDeck;
    private PlayerDeck cpuDeck;
    private StackDeck stackDeck;

    public PlayedDeck getPlayedDeck() {
        return this.playedDeck;
    }

    public PlayerDeck getPlayerDeck() {
        return this.playerDeck;
    }

    public PlayerDeck getCpuDeck() {
        return this.cpuDeck;
    }

    public StackDeck getStackDeck() {
        return this.stackDeck;
    }

    public DecksHandler(){

        //Decks Creation
        stackDeck = new StackDeck();
        playedDeck = new PlayedDeck(stackDeck.drawFirst());
        playerDeck = new PlayerDeck(stackDeck.drawListCards(7));
        cpuDeck = new PlayerDeck(stackDeck.drawListCards(7));
    }
}
