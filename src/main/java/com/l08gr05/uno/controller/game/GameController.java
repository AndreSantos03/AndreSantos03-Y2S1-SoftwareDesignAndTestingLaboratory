package com.l08gr05.uno.controller.game;


import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.l08gr05.uno.Application;
import com.l08gr05.uno.Game.Game;
import com.l08gr05.uno.controller.Controller;
import com.l08gr05.uno.decks_cards.Deck;

public abstract class GameController extends Controller<Game> {

    public GameController(Game game) {
        super(game);
    }
}
