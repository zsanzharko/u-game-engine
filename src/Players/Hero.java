package Players;

import Map.Map;

public class Hero extends Person {
    private float health = 20f;
    private float armor = 3.1f;
    private String weapon = "";

    public Hero() {

    }

    public Hero(Map map) {
        super(map);
    }

    public Hero(int x, int y, Map map) {
        super(x, y, map);
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
        return 'H';
    }
}
