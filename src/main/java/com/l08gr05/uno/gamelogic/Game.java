package com.l08gr05.uno.gamelogic;

import com.l08gr05.uno.gui.Gui;

import java.io.IOException;

public class Game{

    private DecksHandler decksHandler;
    private Gui gui;
    public Game() throws Exception {

        decksHandler = new DecksHandler();
        gui = new Gui();
        run();
    }

    private void run() throws Exception{
        while(true){
            gui.run();
        }
    }



}
