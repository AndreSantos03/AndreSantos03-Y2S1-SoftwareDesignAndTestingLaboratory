package com.l08gr05.uno.viewer.menu;

import com.l08gr05.uno.GUI;
import com.l08gr05.uno.Game.Menu;
import com.l08gr05.uno.viewer.Viewer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class MenuViewer extends Viewer<Menu> {

    public MenuViewer(Menu menu) {super(menu);}

    @Override
    public void drawElements(GUI gui) throws IOException {
        gui.drawMenu();
    }
}
