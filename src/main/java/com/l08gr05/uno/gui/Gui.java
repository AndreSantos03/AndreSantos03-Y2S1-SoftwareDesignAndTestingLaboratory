package com.l08gr05.uno.gui;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Gui {

    private Terminal terminal;
    private Screen screen;
    private TextGraphics tg;


    private AWTTerminalFontConfiguration loadFont() throws Exception
    {
        URL resource = getClass().getClassLoader().getResource("square.ttf");
        File fontFile = new File(resource.toURI());
        Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(font);

        Font loadedFont = font.deriveFont(Font.PLAIN, 1);
        AWTTerminalFontConfiguration fontConfig = AWTTerminalFontConfiguration.newInstance(loadedFont);
        return fontConfig;
    }

    public Gui() throws Exception{
        AWTTerminalFontConfiguration fontConfig = loadFont();
        TerminalSize terminalSize = new TerminalSize(1920, 1080);
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
        terminalFactory.setForceAWTOverSwing(true);
        terminalFactory.setTerminalEmulatorFontConfiguration(fontConfig);
        terminal = terminalFactory.createTerminal();

        screen = new TerminalScreen(terminal);
        tg = screen.newTextGraphics();
        screen.setCursorPosition(null);
        screen.startScreen();
        screen.doResizeIfNecessary();
    }

    public void drawText(int x, int y, String text, String color) {
        TextGraphics tg = screen.newTextGraphics();
        tg.setForegroundColor(TextColor.Factory.fromString(color));
        tg.putString(x, y, text);
    }



    public void run() throws IOException {
        screen.clear();
        for(int x = 0; x<= 100;x++){
            for(int y = 0; y<=100;y++) {
                drawText(0,0,"X", "#FF0000");
            }
        }
        screen.refresh();
    }

    private BufferedImage scaleImage(BufferedImage src, int w, int h){
        BufferedImage img = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        int x, y;
        int ww = src.getWidth();
        int hh = src.getHeight();
        int[] ys = new int[h];
        for (y = 0; y < h; y++)
            ys[y] = y * hh / h;
        for (x = 0; x < w; x++) {
            int newX = x * ww / w;
            for (y = 0; y < h; y++) {
                int col = src.getRGB(newX, ys[y]);
                img.setRGB(x, y, col);
            }
        }
        return img;
    }

    public void drawImage() throws IOException {
        BufferedImage image = ImageIO.read(getClass().getResource("JosePNGBaby.png"));
//        image = scaleImage(image,70,70)
        for (int x = 0; x < image.getWidth(); x++) {
            for(int y = 0; y < image.getHeight();y++) {
                Color c = new Color(image.getRGB(x, y));
                String color = "#" + Integer.toHexString(c.getRGB()).substring(2);
                drawText(x,y," ",color);
            }
        }
    }

//    public void drawCard(Position position, String text, Card card,Position position) {
//        String color;
//        switch(card.getColor()){
//            case "black":
//                color = "#000000";
//                break;
//            case "red":
//                color = " #fb0000 ";
//                break;
//            case "blue":
//                color =  "#0041ff";
//                break;
//            case "green":
//                color = "#1daf38";
//                break;
//            case "yellow":
//                color = "#fdf500";
//                break;
//        }
//        TextGraphics tg = screen.newTextGraphics();
//        tg.setForegroundColor(TextColor.Factory.fromString(color));
//        tg.putString(position.getX(), position.getY() + 1, "" + card.getType());
//    }

}