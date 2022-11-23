package com.l08gr05.uno.cards;

import java.util.Arrays;

public class Card{

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

    public Boolean isNumber(){
        return Arrays.asList("0","1","2","3","4","5","6","7","8","9").contains(type);
    }
}
