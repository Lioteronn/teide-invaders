package main;

import enemies.Enemy;
import enemies.Waves;
import entities.Missile;
import inputs.Keyboardinputs;
import inputs.Mouseinputs;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static javax.imageio.ImageIO.*;

public class GamePanel extends JPanel {

    private int score = 0;

    private Font minecraftFont;
    private BufferedImage img;
    private BufferedImage fondo;
    private BufferedImage disparo;
    private Waves waves;
    private int currentWave = 0;
    private BufferedImage contador;

    private Mouseinputs mouseInputs;
    private Player player;
    private ArrayList<Missile> missilesArrayList = new ArrayList<>();
    private ArrayList<Enemy> enemigosArrayList = new ArrayList<>(); // Lista de enemigos

    private boolean moveRight = false;
    private boolean moveLeft = false;
    private boolean moveUp = false;
    private boolean moveDown = false;

    public GamePanel(){

        try {
            minecraftFont = Font.createFont(Font.TRUETYPE_FONT, new File("src/Minecraftia.ttf")).deriveFont(12f); // Ajusta el tamaño según sea necesario
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(minecraftFont);
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }


        try {
            fondo = read(new File("src/sprites/fondo.png"));
            img = read(new File("src/sprites/Player.png"));
            disparo = read(new File("src/sprites/disparo.png"));
            contador = read(new File("src/sprites/Contador.png"));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error al leer la imagen: " + e.getMessage());
        }

        player = new Player(50, 100, img, this);

        waves = new Waves(1, 5, 3, 0, 0,  0);
        enemigosArrayList = waves.generateEnemies();

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
        for (int i = 0; i < enemigosArrayList.size(); i++) {
            Enemy enemigo = enemigosArrayList.get(i);
            g2d.drawImage(enemigo.getImg(),enemigo.getX(),enemigo.getY(), this);
        }


        //Nave
        g2d.drawImage(player.getImg(), player.getxDelta(), player.getyDelta(), this);


        //Disparo
        for (int i = 0; i < missilesArrayList.size(); i++) {
            Missile missile = missilesArrayList.get(i);
            g2d.drawImage(missile.getImage(), missile.getX(), missile.getY(), this);
            missile.move();
            for (int j = 0; j < enemigosArrayList.size(); j++) {
                Enemy enemigo = enemigosArrayList.get(j);

                if (missile.getBounds().intersects(enemigo.getBounds())) {
                    enemigosArrayList.remove(j);
                    missilesArrayList.remove(i);
                    setScore(getScore()+5);

                    break;
                }
            }
        }
        int contadorX = 100;
        int contadorY = 164;
        g2d.drawImage(contador, contadorX, contadorY, this);


        g2d.setColor(Color.WHITE);
        g2d.setFont(minecraftFont);
        g2d.drawString("" + score, contadorX+5, contadorY+22);



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

    public void setScore(int score) {
        this.score = score;
        repaint();
    }
    public int getScore() {
        return score;
    }
}
