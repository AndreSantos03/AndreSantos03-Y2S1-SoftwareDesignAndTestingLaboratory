package com.l08gr05.uno;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFrame;
import com.l08gr05.uno.decks_cards.Card;

import javax.imageio.ImageIO;
import javax.swing.text.Position;
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

public class GUI {

    private Terminal terminal;
    private int terminalWidth;
    private int terminalHeight;
    private Screen screen;
    private TextGraphics tg;
    private Set<Integer> pressedKeys;
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

    // The following 3 methods are used to initialize the GUI.
    private void setDimensions() throws IOException {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        terminalHeight = (int)screenSize.getHeight() / fontSize;
        terminalWidth = (int)terminalHeight*16/9;

        cardWidth = terminalWidth/14;
        cardHeight = (int) (0.6684 * cardWidth); //to mantain proportions
        Card.setWidthHeight(cardWidth,cardHeight);
    }

    private void setTerminal() throws Exception {
        AWTTerminalFontConfiguration fontConfig = loadFont();
        TerminalSize terminalSize = new TerminalSize(terminalWidth, terminalHeight);
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
        terminalFactory.setForceAWTOverSwing(true);
        terminalFactory.setTerminalEmulatorFontConfiguration(fontConfig);
        terminal = terminalFactory.createTerminal();
        terminal.setBackgroundColor(TextColor.ANSI.RED);
    }

    private void setScreen() throws IOException {
        screen = new TerminalScreen(terminal);
        tg = screen.newTextGraphics();
        screen.setCursorPosition(null);
        screen.startScreen();
        screen.doResizeIfNecessary();
    }

    public GUI() throws Exception {
        pressedKeys = new HashSet<>();
        setDimensions();
        setTerminal();
        setScreen();
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

    private void drawPixel(int x, int y, String text, String color) {
        tg.setBackgroundColor(TextColor.Factory.fromString(color));
        tg.putString(x, y, text);
    }

    public void updateKeyStrokes (){
        ((AWTTerminalFrame)terminal).getComponent(0).addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                pressedKeys.add(e.getKeyCode());

            }
            @Override
            public void keyReleased(KeyEvent e) {
                pressedKeys.remove(e.getKeyCode());

            }
        });
    }

    public Set<Integer> get_pressedKeys(){
        return pressedKeys;
    }


    public void drawImage(int x, int y, BufferedImage image) throws IOException {
        for (int xx = 0; xx < image.getWidth(); xx++) {
            for (int yy = 0; yy < image.getHeight(); yy++) {
                Color c = new Color(image.getRGB(xx, yy));
                String color = "#" + Integer.toHexString(c.getRGB()).substring(2);
                if (!color.equals("#47704c"))
                    drawPixel(xx + x, yy + y, " ", color);
            }
        }
    }

    public void drawSquare(int x, int y, int side, String color){
        for(int xx = x; xx <= x + side;xx++){
            for(int yy = y; yy <= y + side;yy++){
                drawPixel(xx,yy," ",getHex(color));
            }
        }
    }

    public void drawHighlight(int xx,int yy, int width, int height){
        int range = 3;
        for(int x = xx - range; x <= xx + width + range ; x ++){
            for(int y = yy - range; y <= yy;y++){
                drawPixel(x,y," ","#FFFF00");
            }
            for(int y = yy + height; y <= yy + height + range; y++){
                drawPixel(x,y," ", "#FFFF00");
            }
        }
        for(int y = yy; y <= yy+height;y++){
            for(int x = xx - range; x<= xx;x++){
                drawPixel(x,y," ","#FFFF00");
            }
            for(int x = xx + width; x<= xx+ width+range;x++){
                drawPixel(x,y," ","#FFFF00");
            }
        }
    }

    private String getHex(String color){
        String ret = "";
        switch(color){
            case "yellow":
                ret = "#FFFF00";
                break;
            case "green":
                ret = "#00FF00";
                break;
            case "red":
                ret = "#FF0000";
                break;
            case "blue":
                ret = "#0000FF";
        }
        return ret;
    }

    public int get_terminalWidth() {
        return terminalWidth;
    }

    public int get_terminalHeight() {
        return terminalHeight;
    }

    public int get_cardHeight(){return cardHeight;}
    public int get_cardWidth(){return cardWidth;}

    /*
    public void drawMenu() throws IOException {
        // BACKGROUND
        BufferedImage img_background = ImageIO.read(getClass().getResource("/UI/BACKGROUND.png"));
        img_background = scaleImage(img_background, get_terminalWidth(), get_terminalHeight());
        drawImage(0, 0, img_background);

        // JOGAR
        BufferedImage img_jogar = ImageIO.read(getClass().getResource("/UI/JOGAR.png"));
        drawImage(get_terminalWidth() / 2 - img_jogar.getWidth() / 2, get_terminalHeight() / 2 - img_jogar.getHeight() / 2, img_jogar);

        // SAIR
        BufferedImage img_sair = ImageIO.read(getClass().getResource("/UI/SAIR.png"));
        img_sair = scaleImage(img_sair, img_sair.getWidth() - 25, img_sair.getHeight() - 10);
        drawImage(get_terminalWidth() / 2 - img_sair.getWidth() / 2, get_terminalHeight() / 2 - img_sair.getHeight() / 2 - img_jogar.getHeight() / 2 + 150, img_sair);
    }
    */

    public void drawMenuBackGround() throws IOException {
        BufferedImage img_background = ImageIO.read(getClass().getResource("/UI/BACKGROUND.png"));
        img_background = scaleImage(img_background, get_terminalWidth(), get_terminalHeight());
        drawImage(0, 0, img_background);
    }
    public void drawMenuElement(int upFromMiddle, String imageFile) throws IOException {
        BufferedImage img = ImageIO.read(getClass().getResource(imageFile));
        drawImage(get_terminalWidth() / 2 - img.getWidth() / 2, get_terminalHeight() / 2 - upFromMiddle, img);
    }

    private BufferedImage scaleImage(BufferedImage src, int w,int h) {
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
}