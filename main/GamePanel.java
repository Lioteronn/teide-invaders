package main;

import entities.Missile;
import inputs.Keyboardinputs;
import inputs.Mouseinputs;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class GamePanel extends JPanel {
    private BufferedImage img;
    private BufferedImage fondo;
    private BufferedImage disparo;
    private BufferedImage enemigo;
    private Mouseinputs mouseInputs;
    private Player player;
    private ArrayList<Missile> missilesArrayList = new ArrayList<>();
    private boolean moveRight = false;
    private boolean moveLeft = false;
    private boolean moveUp = false;
    private boolean moveDown = false;

    public GamePanel(){
        try {
            fondo = ImageIO.read(new File("sprites/fondo.png"));
            img = ImageIO.read(new File("sprites/Player.png"));
            disparo = ImageIO.read(new File("sprites/disparo.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        player = new Player(50, 100, img, this);

        mouseInputs = new Mouseinputs(this);
        addKeyListener(new Keyboardinputs(this));
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        g2d.scale(4.0, 4.0);

        //fondo
        g2d.drawImage(fondo, 0, 0, this);


        //enemigos
        g2d.drawImage(enemigo, 30, 30, this);

        //Nave
        g2d.drawImage(player.getImg(), player.getxDelta(), player.getyDelta(), this);


        for (int i = 0; i < missilesArrayList.size(); i++) {
            Missile missile = missilesArrayList.get(i);
            g2d.drawImage(missile.getImage(), missile.getX(), missile.getY(), this);
            missile.move();
        }
        //g.fillRect(xDelta,yDelta,50,50);

        //Disparo

    }

    public Player getPlayer() {
        return player;
    }

    public boolean isMoveRight() {
        return moveRight;
    }

    public boolean isMoveLeft() {
        return moveLeft;
    }

    public boolean isMoveUp() {
        return moveUp;
    }

    public boolean isMoveDown() {
        return moveDown;
    }

    public void setMoveRight(boolean moveRight) {
        this.moveRight = moveRight;
    }

    public void setMoveLeft(boolean moveLeft) {
        this.moveLeft = moveLeft;
    }

    public void setMoveUp(boolean moveUp) {
        this.moveUp = moveUp;
    }

    public void setMoveDown(boolean moveDown) {
        this.moveDown = moveDown;
    }

    public ArrayList<Missile> getMissilesArrayList() {
        return missilesArrayList;
    }

    public void setMissilesArrayList(ArrayList<Missile> missilesArrayList) {
        this.missilesArrayList = missilesArrayList;
    }

    public BufferedImage getDisparo() {
        return disparo;
    }
}
