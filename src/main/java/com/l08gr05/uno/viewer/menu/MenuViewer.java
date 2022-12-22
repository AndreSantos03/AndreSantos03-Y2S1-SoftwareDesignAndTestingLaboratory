package com.l08gr05.uno.viewer.menu;

import com.l08gr05.uno.GUI;
import com.l08gr05.uno.Game.Menu;
import com.l08gr05.uno.viewer.Viewer;

import java.io.IOException;

public class MenuViewer extends Viewer<Menu> {

    public MenuViewer(Menu menu) {super(menu);}

    @Override
    public void drawElements(GUI gui) throws IOException {
        gui.drawMenuBackGround();
        for (int i = 0; i < getModel().getNumberEntries(); i++)
            gui.drawMenuElement(- i * 100, getModel().isSelected(i) ? getModel().getEntry(i) + "_HIGHLIGHTED.png" : getModel().getEntry(i) + ".png");
    }
}
