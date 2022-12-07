package com.l08gr05.uno;

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