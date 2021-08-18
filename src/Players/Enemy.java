package Players;

import Map.Map2D;

public class Enemy extends Character {
    private float health = 15f;
    private float armor = 5f;
    private String weapon = "";

    public Enemy(){}

    public Enemy(int x, int y, Map2D map2D) {
        super(x, y, map2D);
    }

    public Enemy(Map2D map2D) {
        super(map2D);
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
