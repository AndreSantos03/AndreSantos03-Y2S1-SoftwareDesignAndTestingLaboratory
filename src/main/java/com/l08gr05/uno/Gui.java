package com.l08gr05.uno;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFrame;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Gui {

    private Terminal terminal;
    private Screen screen;
    private TextGraphics tg;
    private Set<Character> pressedKeys = new HashSet<>();
    private boolean run = true;

    private AWTTerminalFontConfiguration loadFont() throws Exception {
        URL resource = getClass().getClassLoader().getResource("square.ttf");
        File fontFile = new File(resource.toURI());
        Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(font);

        Font loadedFont = font.deriveFont(Font.PLAIN, 2);
        AWTTerminalFontConfiguration fontConfig = AWTTerminalFontConfiguration.newInstance(loadedFont);
        return fontConfig;
    }

    public Gui() throws Exception {
        AWTTerminalFontConfiguration fontConfig = loadFont();
        TerminalSize terminalSize = new TerminalSize(480, 360);
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
        terminalFactory.setForceAWTOverSwing(true);
        terminalFactory.setTerminalEmulatorFontConfiguration(fontConfig);
        terminal = terminalFactory.createTerminal();

        screen = new TerminalScreen(terminal);
        tg = screen.newTextGraphics();
        screen.setCursorPosition(null);
        screen.startScreen();
        screen.doResizeIfNecessary();

        ((AWTTerminalFrame)terminal).getComponent(0).addKeyListener(new KeyAdapter()
        {
            @Override
            public void keyPressed(KeyEvent e)
            {
                pressedKeys.add(e.getKeyChar());
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE)
                {
                    run = false;
                }
            }
            @Override
            public void keyReleased(KeyEvent e)
            {
                pressedKeys.remove(e.getKeyChar());
            }
        });
    }

    public boolean get_run(){
        return run;
    }

    public void refresh() throws IOException {screen.refresh();}
    public void clear(){screen.clear();}
    public void close() throws IOException {screen.close();}

    public void drawPixel(int x, int y, String text, String color) {
        tg.setBackgroundColor(TextColor.Factory.fromString(color));
        tg.putString(x, y, text);
    }

    private BufferedImage scaleImage(BufferedImage src, double scale) {
        int w = (int) (src.getWidth() * scale);
        int h = (int) (src.getHeight() * scale);
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

    public void drawImage(int x, int y, String imageName) throws IOException {
        String resName = "/Cards/" + imageName;
        System.out.println(resName);
        BufferedImage image = ImageIO.read(getClass().getResource(resName));
        image = scaleImage(image, 0.2);
        for (int xx = 0; xx < image.getWidth(); xx++) {
            for (int yy = 0; yy < image.getHeight(); yy++) {
                Color c = new Color(image.getRGB(xx, yy));
                String color = "#" + Integer.toHexString(c.getRGB()).substring(2);
                drawPixel(xx + x, yy + y, " ", color);
            }
        }
    }

    public Set<Character> getPressedKeys() {
        return pressedKeys;
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