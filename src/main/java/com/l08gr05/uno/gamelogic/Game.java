package com.l08gr05.uno.gamelogic;

import com.l08gr05.uno.gui.GUI;
import com.l08gr05.uno.gui.LanternaBasics;

import java.io.IOException;

public class Game{

    private DecksHandler decksHandler;
    private LanternaBasics gui;
    public Game() throws IOException {

        decksHandler = new DecksHandler();
        gui = new LanternaBasics(1920, 1080);
        run();
    }

    public void run(){

    }
}
