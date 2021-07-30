package somePackages;

import players.Hero;
import players.Princess;

public class Map {
    private int size;
    private char[][] map;
    private int[] pPosition;
    private int[] sPosition;

    public Map() {
    }

    public Map(int size, char[][] map) {
        this.size = size;
        this.map = map;
    }

    public void checkPosition(Princess princess, Hero hero) {
        char pToken = princess.getToken();
        char sToken = hero.getToken();

        for (int x = 0; x < map.length; x++) {
            for (int y = 0; y < map[x].length; y++) {
                if (pToken == map[x][y]) {
                    princess.setX(x);
                    princess.setY(y);
                }
                if (sToken == map[x][y]) {
                    hero.setX(x);
                    hero.setY(y);
                }
            }
        }
//        System.out.print(princess.getX() + " " + princess.getY());
        System.out.printf("Princess: X = %d, Y = %d \n" +
                "Hero: X = %d, Y = %d",
                princess.getX(), princess.getY(), hero.getX(), hero.getY());
    }

    public char getPoint(int x, int y) {
        return map[x][y];
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public char[][] getMap() {
        return map;
    }

    public void setMap(char[][] map) {
        this.map = map;
    }

    public int[] getpPosition() {
        return pPosition;
    }

    public void setpPosition(int[] pPosition) {
        this.pPosition = pPosition;
    }

    public int[] getsPosition() {
        return sPosition;
    }

    public void setsPosition(int[] sPosition) {
        this.sPosition = sPosition;
    }
}
