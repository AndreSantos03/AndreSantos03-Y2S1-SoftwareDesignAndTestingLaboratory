package com.l08gr05.uno.decks_cards;

import com.l08gr05.uno.cards.Card;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class StackDeckTest {

    private StackDeck stackDeck;

    @BeforeEach
    public void beforeEachTest() {
        stackDeck = new StackDeck();
    }

    @Test
    public void stackDeckTest() {
        assertEquals(108, stackDeck.getDeck().size());
    }

    @Test
    public void drawCardTest() {
        Card topCard = stackDeck.getDeck().peek();
        Card drawCard = stackDeck.drawCard();
        assertEquals(topCard, drawCard);
        assertEquals(107, stackDeck.getDeck().size());
    }

    @Test
    public void drawListCards() {
        // n = 0
        List<Card> cards = stackDeck.drawListCards(0);
        assertEquals(108, stackDeck.getDeck().size());
        assertEquals(0, cards.size());

        // n = 5
        cards = stackDeck.drawListCards(5);
        assertEquals(103, stackDeck.getDeck().size());
        assertEquals(5, cards.size());
    }

    @Test
    public void drawFirst() {
        Card selectedCard = stackDeck.drawFirst();
        assertTrue(selectedCard.isNumber());
        assertEquals(stackDeck.getDeck().size(), 107);
    }
}