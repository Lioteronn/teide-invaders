package main;

import javax.swing.*;
import java.awt.*;

public class ShipsWrapper extends JPanel {

    private int xDelta, yDelta;
    private Image img;

    public ShipsWrapper(int x, int y, Image img) {
        this.xDelta = x;
        this.yDelta = y;
        this.img = img;
    }

    public void changeXDelta(int value){
        this.xDelta += value;
        repaint();
    }

    public void changeYDelta(int value){
        this.yDelta += value;
        repaint();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(this.img, this.xDelta, this.yDelta, this);
    }

    public int getxDelta() {
        return xDelta;
    }

    public int getyDelta() {
        return yDelta;
    }

    public Image getImg() {
        return img;
    }
}
