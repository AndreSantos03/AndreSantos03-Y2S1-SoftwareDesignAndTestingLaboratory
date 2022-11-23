package com.aor.uno.cards;

public class Card {

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

    public void cardPlayed();

    public void cardDrawn();
}
