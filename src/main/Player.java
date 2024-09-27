package main;

import java.awt.*;

import entities.Missile;
import states.Acciones;

public class Player extends ShipsWrapper implements Acciones {

    private boolean shootAvailable = true;
    private GamePanel gamePanel;

    public Player(int x, int y, Image img, GamePanel gamePanel) {
        super(x, y, img);
        this.gamePanel = gamePanel;
    }

    @Override
    public void shoot() {
        if (shootAvailable) {
            shootAvailable = false;
            gamePanel.getMissilesArrayList().add(new Missile(getxDelta(), getyDelta() - 20, gamePanel.getDisparo()));
        }
    }

    @Override
    public void die() {

    }

    public boolean isShootAvailable() {
        return shootAvailable;
    }

    public void setShootAvailable(boolean shootAvailable) {
        this.shootAvailable = shootAvailable;
    }
}
