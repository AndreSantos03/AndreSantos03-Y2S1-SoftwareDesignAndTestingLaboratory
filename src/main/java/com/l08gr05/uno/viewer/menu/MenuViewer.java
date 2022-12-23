package com.l08gr05.uno.viewer.menu;

import com.l08gr05.uno.GUI;
import com.l08gr05.uno.Game.Menu;
import com.l08gr05.uno.viewer.Viewer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;

public class MenuViewer extends Viewer<Menu> {

    private BufferedImage backgroundImg;
    private BufferedImage jogar;
    private BufferedImage jogarHighlighed;
    private BufferedImage sair;
    private BufferedImage sairHighlighed;

    public MenuViewer(Menu menu) throws IOException {
        super(menu);
        loadImages();
    }

    private void loadImages() throws IOException {
        backgroundImg = ImageIO.read(getClass().getResource("/UI/BACKGROUND.png"));
        backgroundImg = scaleImage(backgroundImg, GUI.getTerminalWidth());
        jogar = ImageIO.read(getClass().getResource("/UI/JOGAR.png"));
        backgroundImg = ImageIO.read(getClass().getResource("/UI/JOGAR_HIGHLIGHTED.png"));
        backgroundImg = ImageIO.read(getClass().getResource("/UI/SAIR.png"));
        backgroundImg = ImageIO.read(getClass().getResource("/UI/SAIR_HIGHLIGHTED.png"));
    };

    private BufferedImage scaleImage(BufferedImage src, int w) {
        int h = src.getHeight() / src.getWidth() * w;
        BufferedImage img = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        int ww = src.getWidth();
        int hh = src.getHeight();
        int[] ys = new int[h];
        for (int y = 0; y < h; y++)
            ys[y] = y * hh / h;
        for (int x = 0; x < w; x++) {
            int newX = x * ww / w;
            for (int y = 0; y < h; y++) {
                int col = src.getRGB(newX, ys[y]);
                img.setRGB(x, y, col);
            }
        }
        return img;
    }

    @Override
    public void drawElements(GUI gui) throws IOException {
        gui.drawImage(0,0,backgroundImg);
        if(getModel().isSelected(0)){
            gui.drawImage(gui.get_terminalWidth() / 2 - jogarHighlighed.getWidth() / 2, gui.get_terminalHeight() / 2 + gui.get_terminalHeight() / 7,jogarHighlighed);
            gui.drawImage(gui.get_terminalWidth() / 2 - jogarHighlighed.getWidth() / 2, gui.get_terminalHeight() / 2 + gui.get_terminalHeight() / 7,sair);
        }
        else{
            gui.drawImage(gui.get_terminalWidth() / 2 - jogarHighlighed.getWidth() / 2, gui.get_terminalHeight() / 2 + gui.get_terminalHeight() / 7,jogar);
            gui.drawImage(gui.get_terminalWidth() / 2 - jogarHighlighed.getWidth() / 2, gui.get_terminalHeight() / 2 + gui.get_terminalHeight() / 7,sairHighlighed);
        }
//        gui.drawMenuBackGround();
//        for (int i = 0; i < getModel().getNumberEntries(); i++)
//            gui.drawMenuElement(- i * 100, getModel().isSelected(i) ? getModel().getEntry(i) + "_HIGHLIGHTED.png" : getModel().getEntry(i) + ".png");
    }

}
