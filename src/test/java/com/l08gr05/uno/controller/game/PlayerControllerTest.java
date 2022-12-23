package com.l08gr05.uno.controller.game;

import com.l08gr05.uno.Application;
import com.l08gr05.uno.Game.Game;
import com.l08gr05.uno.decks_cards.Card;
import com.l08gr05.uno.decks_cards.Deck;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerControllerTest {

    private Application application;
    private Game game;
    private PlayerController playerController;
    private Set<Integer> pressedKeys;

    @BeforeEach
    public void setUp() throws Exception {
        game = Mockito.mock(Game.class);
        application = Mockito.mock(Application.class);

        Card yellowTwo = new Card("yellow", "02", 1);
        Card redBlock = new Card("red", "10", 1);
        Card plusFour = new Card("dark", "14", 1);

        Deck stubPlayerDeck = new Deck(Arrays.asList(yellowTwo, redBlock, plusFour));
        Mockito.when(game.get_playerDeck()).thenReturn(stubPlayerDeck);
        Deck stubPlayedDeck = new Deck(Arrays.asList(yellowTwo));
        Mockito.when(game.get_playedDeck()).thenReturn(stubPlayedDeck);

        pressedKeys = new HashSet<Integer>();
        playerController = new PlayerController(game);
    }

    @Test
    public void selectNextCard() {
        // Verifica que, inicialmente, a primeira carta está selecionada, mas que clicando na seta para a direita, passa a ser a segunda carta
        assertTrue(game.get_playerDeck().get(0).get_isSelected());
        pressedKeys.add(KeyEvent.VK_RIGHT);
        playerController.step(application, pressedKeys);
        assertTrue(game.get_playerDeck().get(1).get_isSelected());

        // Verifica que estando na ultima carta (neste caso a terceira), se continuarmos a clicar (10 vezes) para a direita, a ultima carta continua a estar selecionada
        for (int i = 0; i < 10; i++)
            pressedKeys.add(KeyEvent.VK_RIGHT);
        for (int i = 0; i < 10; i++)
            playerController.step(application, pressedKeys);
        assertTrue(game.get_playerDeck().get(2).get_isSelected());
    }


}
