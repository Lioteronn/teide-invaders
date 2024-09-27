package entities;

import java.awt.*;
import java.awt.image.ImageObserver;


// Missile class
public class Missile {
    private int x, y;
    private int speed = 2;
    private Image image;

    public Missile(int x, int y, Image image) {
        this.x = x;
        this.y = y;
        this.image = image;
    }

    public void move() {
        y -= speed;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Image getImage() {
        return image;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, image.getWidth(null), image.getHeight(null));
    }
}
