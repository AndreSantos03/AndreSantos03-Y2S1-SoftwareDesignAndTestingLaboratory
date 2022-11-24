package com.l08gr05.uno.cards;

import java.util.Arrays;

public class Card{

    private String type;
    private String color;

    public Card(String color, String type){
        this.color = color;
        this.type = type;
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
