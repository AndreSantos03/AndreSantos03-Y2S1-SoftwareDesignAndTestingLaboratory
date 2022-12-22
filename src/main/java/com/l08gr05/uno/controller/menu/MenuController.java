package com.l08gr05.uno.controller.menu;

import com.googlecode.lanterna.input.KeyStroke;
import com.l08gr05.uno.Application;
import com.l08gr05.uno.Game.Game;
import com.l08gr05.uno.Game.Menu;
import com.l08gr05.uno.controller.Controller;

import java.awt.event.KeyEvent;
import java.util.Set;

public class MenuController extends Controller<Menu> {

    public MenuController(Menu menu) {super(menu); }

    @Override
    public void step(Application application, Set<Integer> pressedKeys) {
        if (pressedKeys != null) {
            if (pressedKeys.contains(KeyEvent.VK_UP))
                getModel().previousEntry();
            else if (pressedKeys.contains(KeyEvent.VK_DOWN))
                getModel().nextEntry();
            else if (pressedKeys.contains(KeyEvent.VK_ESCAPE))
                application.setState(null);
        }
    }
}
