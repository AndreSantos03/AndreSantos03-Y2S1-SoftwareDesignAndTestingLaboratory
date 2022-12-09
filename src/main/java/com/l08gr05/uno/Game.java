package com.l08gr05.uno;
import com.l08gr05.uno.state.State;

public class Game{

    private Gui gui;
    private State state;


    public Game() throws Exception {
        state = new State();
        gui = new Gui();
        run();
    }

    private void run() throws Exception{
        while(gui.get_run()){
            state.step(gui);
            Thread.sleep(5);
        }
        gui.close();
    }



}
