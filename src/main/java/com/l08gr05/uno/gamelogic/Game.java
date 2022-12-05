package com.l08gr05.uno.gamelogic;

import com.l08gr05.uno.gui.GUI;
import com.l08gr05.uno.gui.LanternaBasics;
import com.l08gr05.uno.viewer.Position;

import java.io.IOException;

public class Game{

    private DecksHandler decksHandler;
    private LanternaBasics gui;
    public Game() throws IOException {

        decksHandler = new DecksHandler();
        gui = new LanternaBasics(250, 150);
        gui.drawTest(1, 1);
    }

    public void run(){

    }
}
