package somePackages;

import players.Hero;
import players.Princess;
import java.util.Arrays;

public class Map {
    private int size;
    private char[][] map;

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
//        System.out.print("Princess position: x=" + princess.getX() + " | y=" + princess.getY());
//        System.out.print("\n");
//        System.out.print("Hero position: x=" + hero.getX() + " | y=" + hero.getY());
//        System.out.println();
    }

    public char getPoint(int x, int y) {
        return map[x][y];
    }
    public void setPoint(char token, int currentX, int currentY, int goToX, int goToY) {
        map[goToX][goToY] = token;
        map[currentX][currentY] = '-';
    }

    public boolean pointIsValid(int point) {
        return point >= 0 && point <= getSize();
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

    public String toString() {
        return Arrays.deepToString(getMap());
    }

    public void showMap() {
        for (char[] chars : map) {
            System.out.print("[");
            for (char aChar : chars) {
                System.out.print(aChar + ", ");
            }
            System.out.print("] ");
            System.out.println();
        }
    }

    public void setMap(char[][] map) {
        this.map = map;
    }
}
