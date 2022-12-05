package com.l08gr05.uno;
import com.l08gr05.uno.gamelogic.Game;

import java.io.IOException;

public class Application {

    public static void  main(String[] args) {
        try {
            Game game = new Game();
        }
        catch (Exception e)
        {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}