package players;

import Map.Map;

public class Enemy extends Person {
    private float health = 15f;
    private float armor = 5f;
    private String weapon = "";

    public Enemy(){}

    public Enemy(int x, int y, Map map) {
        super(x, y, map);
    }

    public Enemy(Map map) {
        super(map);
    }

    public float getHealth() {
        return health;
    }

    public void setHealth(float health) {
        this.health = health;
    }

    public float getArmor() {
        return armor;
    }

    public void setArmor(float armor) {
        this.armor = armor;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    public char getToken() {
        return 'E';
    }
}
