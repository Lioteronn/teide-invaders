package enemies;
import enemies.Enemy;
import java.util.ArrayList;
import java.util.Random;

public class Waves {
    private int numero;
    private int t1;
    private int t2;
    private int t3;
    private int t4;
    private int bosses;

    // Constructor
    public Waves(int numero, int t1, int t2, int t3, int t4, int bosses) {
        this.numero = numero;
        this.t1 = t1;
        this.t2 = t2;
        this.t3 = t3;
        this.t4 = t4;
        this.bosses = bosses;
    }


    public ArrayList<Enemy> generateEnemies() {
        ArrayList<Enemy> enemies = new ArrayList<>();
        Random random = new Random();

        // Generar enemigos de cada tipo
        for (int i = 0; i < t1; i++) {
            enemies.add(new Enemy(randomX(), randomY(), EnemyType.T1));
        }
        for (int i = 0; i < t2; i++) {
            enemies.add(new Enemy(randomX(), randomY(), EnemyType.T2));
        }
        for (int i = 0; i < t3; i++) {
            enemies.add(new Enemy(randomX(), randomY(), EnemyType.T3));
        }
        for (int i = 0; i < t4; i++) {
            enemies.add(new Enemy(randomX(), randomY(), EnemyType.T4));
        }
        for (int i = 0; i < bosses; i++) {
            enemies.add(new Enemy(randomX(), randomY(), EnemyType.BOSS));
        }

        return enemies;
    }

    private int randomX() {
        return new Random().nextInt(80);
    }

    private int randomY() {
        return new Random().nextInt(130);
    }
}
