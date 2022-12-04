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

import java.io.IOException;

public class LanternaBasics{
    private final Screen screen;

    public LanternaBasics(Screen screen) {
        this.screen = screen;
    }

    public LanternaBasics(int width, int height) throws IOException {
        Terminal terminal = createTerminal(width, height);
        this.screen = createScreen(terminal);
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

    public void drawTest(Position position, char c) {
        TextGraphics tg = screen.newTextGraphics();
        tg.putString(position.getX(), position.getY(), "" + c);
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