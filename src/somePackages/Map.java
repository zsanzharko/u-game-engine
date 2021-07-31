package somePackages;

import players.Hero;
import players.Person;
import players.Princess;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Map {
    private int size;
    private char[][] map;
    List<LinkedList<Integer>> positions = new LinkedList<>();

    public Map() {
    }

    public Map(int size, char[][] map) {
        this.size = size;
        this.map = map;
    }

    public Map(int size) {
        this.size = size;
    }

    public void checkPosition() {
        for (int x = 0; x < map.length; x++) {
            for (int y = 0; y < map[x].length; y++) {
                LinkedList<Integer> position = new LinkedList<>();
                if (map[x][y] != '-') {
                    position.add(Character.getType(map[x][y]));
                    position.add(1, x);
                    position.add(1, y);
                    positions.add(position);
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
        map[currentX][currentY] = '-';
        map[goToX][goToY] = token;
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

    public void setMap(char[][] map) {
        this.map = map;
    }

    public String toString() {
        return Arrays.deepToString(getMap());
    }

    public void showMap() {
        for (char[] chars : map) {
            System.out.print("[ ");
            for (char aChar : chars) {
                System.out.print(aChar + " ");
            }
            System.out.print("]");
            System.out.println();
        }
    }

    public void generateMap() {
        String map = "-".repeat(size).repeat(size);
        this.map = nestingIntoAnArray(map);
    }

    public void setPlayersInMap(ArrayList<Person> players) {
        StringBuilder map = new StringBuilder();
        for (char[] chars : this.map)
            for (char aChar : chars) map.append(aChar);

        for (Person player : players)
            map.insert((int) (Math.random() * (Math.pow(size, 2))), player.getToken());

        this.map = nestingIntoAnArray(map.toString());
    }

    public char[][] nestingIntoAnArray(String map) {
        char[][] c = new char[size][size];
        for (int i = 0; i < c.length; ++i) {
            for (int k = 0; k < c[i].length; ++k) {
                c[i][k] = map.charAt(k);
            }
            map = map.substring(c.length);
        }
        return c;
    }

    public Map build() {
        return this;
    }
}
