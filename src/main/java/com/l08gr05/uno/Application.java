package com.l08gr05.uno;
import com.l08gr05.uno.gui.LanternaBasics;

import java.io.IOException;

public class Application {

    private final LanternaBasics gui;

    public Application(LanternaBasics gui) {
        this.gui = gui;
    }

    public static void main(String[] args) throws IOException {
        LanternaBasics gui = new LanternaBasics(50, 50);
    }
}