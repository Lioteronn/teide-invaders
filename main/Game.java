package main;


import java.util.ArrayList;

public class Game {
    private GameWindow gameWindow;
    private GamePanel gamePanel;

    public Game() {
        gamePanel = new GamePanel();
        gameWindow = new GameWindow(gamePanel);
        gamePanel.requestFocus();
        gameLoop();
    }

    private void gameLoop() {
        int contadorDisparos = 0;

        while (true) {
            if (gamePanel.isMoveLeft()) {
                gamePanel.getPlayer().changeXDelta(-5);
            }
            if (gamePanel.isMoveRight()) {
                gamePanel.getPlayer().changeXDelta(5);
            }
            if (gamePanel.isMoveUp()) {
                gamePanel.getPlayer().changeYDelta(-5);
            }
            if (gamePanel.isMoveDown()) {
                gamePanel.getPlayer().changeYDelta(5);
            }

            if (contadorDisparos == 6) {
                gamePanel.getPlayer().setShootAvailable(true);
                contadorDisparos = 0;
            } else if (contadorDisparos < 6 && !gamePanel.getPlayer().isShootAvailable()) {
                contadorDisparos++;
            }

            gamePanel.update(gamePanel.getGraphics());
            gamePanel.repaint();

            try {
                Thread.sleep(70);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }
}
