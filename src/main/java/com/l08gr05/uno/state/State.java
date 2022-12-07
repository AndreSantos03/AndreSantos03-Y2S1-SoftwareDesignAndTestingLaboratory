package com.l08gr05.uno.state;

import com.l08gr05.uno.Gui;
import com.l08gr05.uno.viewer.Viewer;

import javax.swing.text.View;

public class State{
    private Viewer viewer;
    private DecksHandler decksHandler;

    public State(){

        viewer = new Viewer();
    }

    public void step(Gui gui) throws Exception {
        viewer.step(gui);
    }
}
