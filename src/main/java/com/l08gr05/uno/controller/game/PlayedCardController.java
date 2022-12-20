package com.l08gr05.uno.controller.game;

import com.googlecode.lanterna.input.KeyStroke;
import com.l08gr05.uno.Application;
import com.l08gr05.uno.Game.Game;
import com.l08gr05.uno.decks_cards.Card;

import java.util.Arrays;
import java.util.concurrent.Flow;

public class PlayedCardController extends GameController{
    private Card playedCard;

    public PlayedCardController(Game game){
        super(game);
        playedCard = null;
    }
    public void set_playedCard(Card card){
        playedCard = card;
    }

    private void stopReverse(){
        if(FlowController.getPlayerTurn()){
            getModel().get_playerDeck().remove(playedCard);
        }
        else{
            getModel().get_cpuDeck().remove(playedCard);
        }
        getModel().get_playedDeck().addTop(playedCard);
        System.out.println("Stop reverse");
        getModel().set_color(playedCard.get_color());
    }

    private void normal(){
        stopReverse();
        FlowController.setPlayerTurn(!FlowController.getPlayerTurn());
        System.out.println("Normal");
    }

    private void draw2(){
        normal();
        if(FlowController.getPlayerTurn()){
            getModel().get_cpuDeck().addTop(getModel().get_stackDeck().drawTop(2));
        }
        else{
            getModel().get_playerDeck().addTop(getModel().get_stackDeck().drawTop(2));
        }
        System.out.println("Draw 2");
    }
    private void draw4(){
        if(FlowController.getPlayerTurn()){
            getModel().get_playerDeck().remove(playedCard);
            getModel().get_cpuDeck().addTop(getModel().get_stackDeck().drawTop(4));
        }
        else{
            getModel().get_cpuDeck().remove(playedCard);
            getModel().get_playerDeck().addTop(getModel().get_stackDeck().drawTop(4));
        }
        getModel().get_playedDeck().addTop(playedCard);
        getModel().set_colorChooser(true);
        System.out.println("Draw 4");
    }
    public void colorChanger(){
        if(FlowController.getPlayerTurn()){
            getModel().get_playerDeck().remove(playedCard);
        }
        else{
            getModel().get_cpuDeck().remove(playedCard);
        }
        getModel().get_playedDeck().addTop(playedCard);
        getModel().set_colorChooser(true);
        System.out.println("Color Changer");
    }
    public void step(Application application, KeyStroke keyStroke){
        if(playedCard.isNumber()){
            normal();
        }
        else if(playedCard.get_type() == "14"){
            draw4();
        }
        else if(playedCard.get_type() == "13"){
            colorChanger();
        }
        else if(playedCard.get_type() == "12"){
            draw2();
        }
        else{
            stopReverse();
        }
    }
}
