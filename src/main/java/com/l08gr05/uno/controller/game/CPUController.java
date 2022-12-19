package com.l08gr05.uno.controller.game;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.l08gr05.uno.Application;
import com.l08gr05.uno.Game.Game;
import com.l08gr05.uno.decks_cards.Card;

import java.util.Arrays;
import java.util.List;

public class CPUController extends GameController {
    public CPUController(Game game){
        super(game);
    }
    public void step(Application application, KeyStroke keyStroke)
    {
    }

//    @Override
//    public void step(Application application, KeyStroke keyStroke){
//        List<Card> cardsList = getModel().get_cpuDeck().get_deckList();
//        Card topCard = getModel().get_topCard();
/*      Card Rating System:
        1 - Special Card/Same Color Stop or Reverse
        2 - Draw 2 Same Color
        3 - Card Same Color different Number
        4- Stop or Reverse Different
        5- Draw 2 Different Color
        6 - Same number Different Color
        7 - Draw 4
        8 - Color Changer
        If opponent has 1 card then:
        1 - Special Card/Same Color Stop or Reverse
        2 - Draw 2 Same Color
        3 - Draw 4
        4- Stop or Reverse Different
        5- Draw 2 Different Color
        6- Card Same Color different Number
        7- Same number Different Color
        8- Color Changer
*/
//        int min = 10; //random value doesn't matter
//        Card playableCard = null;
//        for(Card card : cardsList){
//            int rating;
//            if(card.get_color() == getModel().get_color()){
//                if(card.get_type() == "10" || card.get_type() == "11"){
//                    rating = 1;
//                }
//                else if(card.get_type() == "12"){
//                    rating = 2;
//                }
//                else{
//                    rating = 3;
//                }
//            }
//            else if(card.get_type() == topCard.get_type()){
//                if(card.get_type() == "10" || card.get_type() == "11"){
//                    rating = 4;
//                }
//                else if(card.get_type() == "12"){
//                    rating = 5;
//                }
//                else{
//                    rating = 6;
//                }
//            }
//            else if(card.get_type() == "14"){
//                rating = 7;
//            }
//            else{
//                rating = 18; //just for the Color Changer
//            }
//            if(rating < min){
//                min = rating;
//                playableCard = card;
//            }
//        }
//        getModel().cpuCardPlayer(playableCard);
//    }
}
