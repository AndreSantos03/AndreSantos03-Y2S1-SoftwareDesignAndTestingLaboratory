package com.l08gr05.uno.cards_decks;

import java.util.Deque;
import java.util.Queue;
import java.util.Set;

public class Card {

    private String type;
    private String color;
    private static int id;
    private static int id_tracker = 0; //used to give different IDs throughout
    public Card(String color, String type){
        this.color = color;
        this.type = type;
        id = id_tracker;
        id_tracker++;
    }
    public Card(String type){
        this.color = "black";
        this.type = type;
    }
    public String getType(){
        return this.type;
    };

    public String getColor(){
        return this.color;
    };
}
