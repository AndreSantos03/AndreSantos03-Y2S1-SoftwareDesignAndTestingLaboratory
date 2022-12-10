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
import com.l08gr05.uno.decks_cards.Card;

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
    private int terminalWidth;
    private int terminalHeight;
    private Screen screen;
    private TextGraphics tg;
    private Set<Character> pressedKeys = new HashSet<>();
    private boolean run = true;
    private int fontSize = 2;
    private int cardWidth;
    private int cardHeight;

    private AWTTerminalFontConfiguration loadFont() throws Exception {
        URL resource = getClass().getClassLoader().getResource("square.ttf");
        File fontFile = new File(resource.toURI());
        Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(font);

        Font loadedFont = font.deriveFont(Font.PLAIN, fontSize);
        AWTTerminalFontConfiguration fontConfig = AWTTerminalFontConfiguration.newInstance(loadedFont);
        return fontConfig;
    }

    public Gui() throws Exception {

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        terminalHeight = (int)screenSize.getHeight() / fontSize;
        terminalWidth = (int)terminalHeight*16/9;

        cardWidth = terminalWidth/14;
        cardHeight = (int) (0.6684 * cardWidth);//to mantain proportions
        Card.setWidthHeight(cardWidth,cardHeight);

        AWTTerminalFontConfiguration fontConfig = loadFont();
        TerminalSize terminalSize = new TerminalSize(terminalWidth, terminalHeight);
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
        terminalFactory.setForceAWTOverSwing(true);
        terminalFactory.setTerminalEmulatorFontConfiguration(fontConfig);
        terminal = terminalFactory.createTerminal();

        screen = new TerminalScreen(terminal);
        tg = screen.newTextGraphics();
        screen.setCursorPosition(null);
        screen.startScreen();
        screen.doResizeIfNecessary();

        ((AWTTerminalFrame) terminal).getComponent(0).addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                pressedKeys.add(e.getKeyChar());
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    run = false;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                pressedKeys.remove(e.getKeyChar());
            }
        });
    }

    public boolean get_run() {
        return run;
    }

    public void refresh() throws IOException {
        screen.refresh();
    }

    public void clear() {
        screen.clear();
    }

    public void close() throws IOException {
        screen.close();
    }

    public void drawPixel(int x, int y, String text, String color) {
        tg.setBackgroundColor(TextColor.Factory.fromString(color));
        tg.putString(x, y, text);
    }


    public void drawImage(int x, int y, BufferedImage image) throws IOException {
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

    public int get_terminalWidth() {
        return terminalWidth;
    }

    public int get_terminalHeight() {
        return terminalHeight;
    }

    public int get_cardHeight(){return cardHeight;}
    public int get_cardWidth(){return cardWidth;}
}