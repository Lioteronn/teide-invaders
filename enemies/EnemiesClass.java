package enemies;

import main.GamePanel;

public class EnemiesClass extends GamePanel {

    private int Hp;
    private int Tier;
    private int Points;
    private String Name;

    public EnemiesClass(int hp, int tier, int points, String name) {
        Hp = hp;
        Tier = tier;
        Points = points;
        Name = name;
    }


}
