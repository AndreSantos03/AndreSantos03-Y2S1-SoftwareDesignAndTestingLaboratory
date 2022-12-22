package com.l08gr05.uno.state;

import com.googlecode.lanterna.input.KeyStroke;
import com.l08gr05.uno.Application;
import com.l08gr05.uno.GUI;
import com.l08gr05.uno.controller.Controller;
import com.l08gr05.uno.viewer.Viewer;

public abstract class State<T>{
    private final T model;
    private final Controller<T> controller;
    private final Viewer<T> viewer;

    public  State(T model)  {
        this.model = model;
        this.viewer = getViewer();
        this.controller = getController();
    }

    protected abstract Viewer<T> getViewer();
    protected abstract Controller<T> getController();

    public T getModel(){return model;}

    public void step(Application application,GUI gui) throws Exception {
        gui.updateKeyStrokes();
        controller.step(application,gui.get_pressedKeys());
        viewer.draw(gui);
    }
}
