package com.l08gr05.uno.controller;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.l08gr05.uno.Application;

import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Set;

public abstract class Controller<T> {
    private final T model;

    public Controller(T model) {
        this.model = model;
    }

    public T getModel() {
        return model;
    }

    public abstract void step(Application application, Set<Integer> pressedKeys) throws IOException;
}
