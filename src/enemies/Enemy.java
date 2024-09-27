package enemies;


import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


public class Enemy{

    private int x, y;
    private int speed = 2;

    private BufferedImage img;

    private EnemyType type;

    public Enemy(int x, int y, EnemyType type) {
        this.x = x;
        this.y = y;
        this.type = type;
        loadImage();
    }

    private void loadImage() {
        switch (type) {
            case T1:
                img = loadImageFromFile("src/sprites/EnemyT1.png");
                break;
            case T2:
                img = loadImageFromFile("src/sprites/EnemyT2.png");
                break;
            /*
                case T3:
                img = loadImageFromFile("src/sprites/EnemyT3.png");
                break;
            */
            case T4:
                img = loadImageFromFile("src/sprites/EnemyT4.png");
                break;
            /*
            case BOSS:
                img = loadImageFromFile("src/sprites/Boss.png");
                break;

             */
        }

    }
    private BufferedImage loadImageFromFile(String path) {
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File(path));
        } catch (IOException e) {
            e.printStackTrace(); // Imprimir el error en caso de fallo
            System.out.println("Error al cargar la imagen: " + path);
        }
        return image;
    }


    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public BufferedImage getImg() {
        return img;
    }

    public void setImg(BufferedImage img) {
        this.img = img;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, img.getWidth(), img.getHeight());
    }
}
