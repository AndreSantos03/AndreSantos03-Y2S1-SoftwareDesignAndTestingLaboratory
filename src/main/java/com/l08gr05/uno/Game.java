package com.l08gr05.uno;
import com.l08gr05.uno.gui.LanternaBasics;

import java.io.IOException;

public class Game {

    private final LanternaBasics gui;

    public Game(LanternaBasics gui) {
        this.gui = gui;
    }

    public static void main(String[] args) throws IOException {
        LanternaBasics gui = new LanternaBasics(50, 50);
    }
}