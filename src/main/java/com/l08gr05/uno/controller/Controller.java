package com.l08gr05.uno.controller;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.l08gr05.uno.Application;

public abstract class Controller<T> {
    private final T model;
    private boolean PlayerTurn;


    public Controller(T model) {
        this.model = model;
    }

    public T getModel() {
        return model;
    }

    public abstract void step(Application application, KeyType keyStrokeType) ;
}
