package com.l08gr05.uno.gui;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;
import com.l08gr05.uno.cards.Card;
import com.l08gr05.uno.viewer.Position;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class LanternaBasics{
    private final Screen screen;

    public LanternaBasics(Screen screen) {
        this.screen = screen;
    }

    public LanternaBasics(int width, int height) throws IOException {
        Terminal terminal = createTerminal(width, height);
        this.screen = createScreen(terminal);
        TerminalSize terminalSize = new TerminalSize(250, 150);
        DefaultTerminalFactoryefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
        terminalFactory.setForceAWTOverSwing(true);
        terminalFactory.setTerminalEmulatorFontConfiguration(fontConfig);
        terminal = terminalFactory.createTerminal();
    }
    private AWTTerminalFontConfiguration loadFont() throws Exception
    {
        URL resource = getClass().getClassLoader().getResource("fonts/square.ttf");
        File fontFile = new File(resource.toURI());
        Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(font);

        Font loadedFont = font.deriveFont(Font.PLAIN, 3);
        AWTTerminalFontConfiguration fontConfig = AWTTerminalFontConfiguration.newInstance(loadedFont);
        return fontConfig;
    }

    private Terminal createTerminal(int width, int height) throws IOException {
        TerminalSize terminalSize = new TerminalSize(width, height);
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
        Terminal terminal = terminalFactory.createTerminal();
        return terminal;
    }

    private Screen createScreen(Terminal terminal) throws IOException {
        final Screen screen;
        screen = new TerminalScreen(terminal);
        screen.setCursorPosition(null);
        screen.startScreen();
        screen.doResizeIfNecessary();
        return screen;
    }

    private static BufferedImage scale1(BufferedImage before, double scale) {
        int w = before.getWidth();
        int h = before.getHeight();
        // Create a new image of the proper size
        int w2 = (int) (w * scale);
        int h2 = (int) (h * scale);
        BufferedImage after = new BufferedImage(w2, h2, BufferedImage.TYPE_INT_ARGB);
        AffineTransform scaleInstance = AffineTransform.getScaleInstance(scale, scale);
        AffineTransformOp scaleOp
                = new AffineTransformOp(scaleInstance, AffineTransformOp.TYPE_BILINEAR);

        scaleOp.filter(before, after);
        return after;
    }


    public void drawTest(int x, int y) throws IOException {

        BufferedImage image = scale1(ImageIO.read(getClass().getResource("/resources/JosePNGBaby.png")),1);
        for(int xx = image.getMinTileX(); xx <= image.getMinTileX() + image.getNumXTiles();xx++){
            for(int yy = image.getMinTileY(); yy <= image.getMinTileY()+image.getNumYTiles();yy++){
                TextGraphics tg = screen.newTextGraphics();
                tg.setForegroundColor(TextColor.Factory.fromString(color));
                tg.putString(xx, yy, "" + );
                screen.refresh();
            }
        }
        screen.refresh();
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