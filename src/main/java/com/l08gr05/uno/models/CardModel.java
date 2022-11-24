package com.l08gr05.uno.models;

import com.l08gr05.uno.cards.Card;

public class CardModel {

    private Position position;
    private Card card;
    private static int length;
    private static int width;

    public CardModel(Position position, Card card) {
        this.position = position;
        this.card = card;
    }
}
