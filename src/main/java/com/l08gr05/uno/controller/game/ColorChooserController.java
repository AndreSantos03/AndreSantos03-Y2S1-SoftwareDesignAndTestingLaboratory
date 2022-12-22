package com.l08gr05.uno.controller.game;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.l08gr05.uno.Application;
import com.l08gr05.uno.Game.Game;
import com.l08gr05.uno.decks_cards.Card;

import java.awt.event.KeyEvent;
import java.util.*;
import java.util.concurrent.Flow;

public class ColorChooserController extends GameController{
    public ColorChooserController(Game game){
        super(game);
    }

    private void playerColorChooser( Set<Character> pressedKeys){
        if(pressedKeys.contains(KeyEvent.VK_LEFT) && getModel().get_indexColorChooser() > 0){
            getModel().set_indexColorChooser(getModel().get_indexColorChooser() - 1);
        }
        else if(pressedKeys.contains(KeyEvent.VK_RIGHT) && getModel().get_indexColorChooser() < 3){
            getModel().set_indexColorChooser(getModel().get_indexColorChooser() + 1);
        }
        else if(pressedKeys.contains(KeyEvent.VK_ENTER)){
            switch(getModel().get_indexColorChooser()){
                case 0:
                    getModel().set_color("red");
                    break;
                case 1:
                    getModel().set_color("green");
                    break;
                case 2:
                    getModel().set_color("blue");
                    break;
                case 3:
                    getModel().set_color("yellow");
            }
            getModel().set_colorChooser(false);
            getModel().set_playerTurn(false);
        }
    }

    private void cpuColorChooser(){
        List<Card> cpuList = getModel().get_cpuDeck().get_deckList();
        int numRed = 0;
        int numGreen = 0;
        int numBlue = 0;
        int numYellow = 0;
        Map<String,Integer> colors = new HashMap<>();
        colors.put("red",numRed);
        colors.put("green",numGreen);
        colors.put("blue",numBlue);
        colors.put("yellow",numYellow);
        for(Card card:cpuList){
            switch(card.get_color()){
                case "red":
                    numRed++;
                    break;
                case "green":
                    numGreen++;
                    break;
                case "blue":
                    numBlue++;
                    break;
                case "yellow":
                    numYellow++;
            }
        }
        String chosenColor = Collections.max(colors.entrySet(), (entry1,entry2) -> entry1.getValue() - entry2.getValue()).getKey();
        getModel().set_color(chosenColor);
        getModel().set_colorChooser(false);
        getModel().set_playerTurn(true);
    }

    public void step(Application application,  Set<Character> pressedKeys){
        if(getModel().get_playerTurn()) {
            playerColorChooser(pressedKeys);
        }
        else{
            cpuColorChooser();
        }
    }
}
