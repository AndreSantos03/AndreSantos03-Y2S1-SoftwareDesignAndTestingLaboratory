package com.l08gr05.uno.gamelogic;

import com.l08gr05.uno.decks_cards.Deck;
import com.l08gr05.uno.decks_cards.StackDeck;

public class DecksHandler {
    private Deck playedDeck;
    private Deck playerDeck;
    private Deck cpuDeck;
    private Deck stackDeck;

    public Deck getPlayedDeck() {
        return this.playedDeck;
    }

    public Deck getPlayerDeck() {
        return this.playerDeck;
    }

    public Deck getCpuDeck() {
        return this.cpuDeck;
    }

    public Deck getStackDeck() {
        return this.stackDeck;
    }


    public DecksHandler(){

        //Decks Creation
        stackDeck = new StackDeck();
        playedDeck = new Deck(stackDeck.drawTop(7));
        playerDeck = new Deck(stackDeck.drawTop(7));
        cpuDeck = new Deck(stackDeck.drawTop(7));
    }

}
