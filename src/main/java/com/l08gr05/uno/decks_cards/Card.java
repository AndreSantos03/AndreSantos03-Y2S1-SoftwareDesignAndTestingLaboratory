package com.l08gr05.uno.decks_cards;

import java.util.Arrays;

public class Card{

    private String type;
    private String color;
    private String pngName;

    public Card(String type){
        this("dark",type);
    }
    public Card(String color, String type){
        this.color = color;
        this.type = type;
        pngName = type + color.charAt(0) + ".png";
   }
    public String get_type(){
        return this.type;
    };

    public String get_color(){
        return this.color;
    };
    public String get_pngName(){return pngName;}

    public Boolean isNumber(){
        return Arrays.asList("00","01","02","03","04","05","06","07","08","09").contains(type);
    }
}
