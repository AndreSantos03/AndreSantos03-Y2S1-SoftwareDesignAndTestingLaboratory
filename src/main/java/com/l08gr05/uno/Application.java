package com.l08gr05.uno;
import com.googlecode.lanterna.input.KeyStroke;
import com.l08gr05.uno.gamelogic.Game;
import com.l08gr05.uno.gui.LanternaBasics;

import java.io.IOException;

public class Application {

    private final LanternaBasics gui;

    public Application(LanternaBasics gui) {
        this.gui = gui;
    }

    public void main(String[] args) throws IOException {
        LanternaBasics gui = new LanternaBasics(1920, 1080);
        Game game = new Game();
    }
}