package com.l08gr05.uno;
import com.l08gr05.uno.Game.Game;
import com.l08gr05.uno.state.GameState;
import com.l08gr05.uno.state.State;

public class Application {

    private GUI gui;
    private State state;

    public Application() throws Exception {
        this.gui = new GUI();
        this.state = new GameState(new Game());
    }

    public static void main(String[] args) throws Exception {
        new Application().start();
    }

    public void setState(State state) {
        this.state = state;
    }

    private void start() throws Exception {
        try {
            while (this.state != null) {
                state.step(this,gui);
            }
            gui.close();
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
