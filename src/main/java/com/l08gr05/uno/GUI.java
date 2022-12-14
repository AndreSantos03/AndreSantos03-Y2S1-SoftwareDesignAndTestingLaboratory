package com.l08gr05.uno;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.StyleSet;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;
import com.l08gr05.uno.decks_cards.Card;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

public class GUI {

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
    private KeyStroke keyStroke;
    private BufferedImage colorText;
    private BufferedImage drawCardsText;

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

    public GUI() throws Exception {

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
        terminal.setBackgroundColor(TextColor.ANSI.RED);

        screen = new TerminalScreen(terminal);
        tg = screen.newTextGraphics();
        screen.setCursorPosition(null);
        screen.startScreen();
        screen.doResizeIfNecessary();
        loadUIImages();
    }

    private void loadUIImages() throws IOException {
        colorText = ImageIO.read(getClass().getResource("/UI/Color.png"));
        colorText = scaleImage(colorText, terminalWidth/30);
    }
    public boolean get_run() {
        return run;
    }
    public void set_run(boolean run){
        this.run = run;
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

    public KeyStroke get_keystroke() throws IOException {
        keyStroke = screen.pollInput();
        return keyStroke;
    };
    private BufferedImage scaleImage(BufferedImage src, int w){
        int h = (int) (w * src.getHeight() /src.getWidth());
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
    public void drawSquare(int x, int y, int size, String color){
        String hexColor = "";
        switch (color){
            case "yellow":
                hexColor = "#ffff00";
                break;
            case "blue":
                hexColor = "#0000ff";
                break;
            case "green":
                hexColor = "#00ff00";
                break;
            case "red":
                hexColor = "#ff0000";
        }
        for(int xx = x; xx<= x + size;xx++){
            for(int yy = y; yy<= y + size;yy++){
                drawPixel(xx, yy, " ", hexColor);
            }
        }
    }

    public void drawImage(int x, int y, BufferedImage image) throws IOException {
        for (int xx = 0; xx < image.getWidth(); xx++) {
            for (int yy = 0; yy < image.getHeight(); yy++) {
                if(image == colorText){
                    System.out.println(image.getRGB(xx,yy));
                }
                if(image.getRGB(xx,yy) != 4681804){
                    Color c = new Color(image.getRGB(xx, yy));
                    String color = "#" + Integer.toHexString(c.getRGB()). substring(2);
                    drawPixel(xx + x, yy + y, " ", color);\ za
                }
            }
        }
    }

    public void drawHighlight(int xx,int yy, int width, int height) {
        int range = 3;
        for (int x = xx - range; x <= xx + width + range; x++) {
            for (int y = yy - range; y <= yy; y++) {
                drawPixel(x, y, " ", "#FFFF00");
            }
            for (int y = yy + height; y <= yy + height + range; y++) {
                drawPixel(x, y, " ", "#FFFF00");
            }
        }
        for (int y = yy; y <= yy + height; y++) {
            for (int x = xx - range; x <= xx; x++) {
                drawPixel(x, y, " ", "#FFFF00");
            }
            for (int x = xx + width; x <= xx + width + range; x++) {
                drawPixel(x, y, " ", "#FFFF00");
            }
        }
    }

    public void drawUI() throws IOException {
        drawImage(0,0,colorText);
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