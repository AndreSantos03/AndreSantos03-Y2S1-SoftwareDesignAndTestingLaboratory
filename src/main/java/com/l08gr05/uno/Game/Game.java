package com.l08gr05.uno.Game;

import com.l08gr05.uno.decks_cards.Deck;
import com.l08gr05.uno.decks_cards.StackDeck;

import java.io.IOException;

public class Game {
    private Deck stackDeck;
    private Deck playedDeck;
    private Deck playerDeck;
    private Deck cpuDeck;
    private String color;
    private boolean colorChooser;
    private int indexColorChooser;
    private boolean playerTurn;
    public Game() throws IOException {
        stackDeck = new StackDeck();
        playedDeck = new Deck(stackDeck.drawFirst());
        color = playedDeck.getTop().get_color();
        playerDeck = new Deck(stackDeck.drawTop(7));
        cpuDeck = new Deck(stackDeck.drawTop(7));
        colorChooser = false;
        playerTurn = true;
    }

    public Deck get_stackDeck(){
        return stackDeck;
    }
    public Deck get_playerDeck(){
        return playerDeck;
    }
    public Deck get_cpuDeck(){
        return cpuDeck;
    }

    public Deck get_playedDeck() {
        return playedDeck;
    }
    public boolean get_playerTurn(){
        return playerTurn;
    }
    public void set_playerTurn(boolean turn){
        playerTurn = turn;
    }
/*
    public Card get_topCard(){
        return playedDeck.getTop();
    }
*/

/*
    public void setSelectStatus(int index, boolean select){
        playerDeck.get(index).setIsSelected(select);
    }
*/
/*    public boolean playCardPlayer(int index){
        if(get_topCard().canCardBePlayedOver(playerDeck.get(index))){
            playerDeck.get(index).setIsSelected(false);
            playedDeck.addTop(playerDeck.remove(index));
            color = get_topCard().get_color();
            return true;
        }
        return false;
    }*/
/*    public boolean cpuCardPlayer(Card card){
        if(get_topCard().canCardBePlayedOver(card)){
            card.setIsSelected(false);
            cpuDeck.remove(card);
            playedDeck.addTop(card);
            color = get_topCard().get_color();
            return true;
        }
        return false;
    }*/
/*
    public void setPlayerDraw(){
        playerDraw = true;
        for(Card card: playerDeck.get_deckList()){
            if(get_topCard().canCardBePlayedOver(card)){
                playerDraw = false;
            }
        }
    }
*/

/*
    public void playerDrawCard(){
        playerDeck.addTop(stackDeck.drawTop());
    }
*/

    public void set_color(String color){
        this.color = color;
    }
    public String get_color(){
        return color;
    }
    public void set_colorChooser(boolean chooser){
        colorChooser = chooser;
    }
    public boolean get_colorChooser(){
        return colorChooser;
    }
    public void set_indexColorChooser(int index){
        System.out.println(index);
        indexColorChooser = index;
    }
    public int get_indexColorChooser(){
        return indexColorChooser;
    }
}
