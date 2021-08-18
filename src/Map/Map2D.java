package Map;

import Players.Character;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Map2D extends Map {
    private int size;
    private char[][] map;
    List<LinkedList<Integer>> positions = new LinkedList<>();
    private ArrayList<Character> characters = null;

    public Map2D() {
    }

    public Map2D(int size, char[][] map) {
        this.size = size;
        this.map = map;
    }

    public Map2D(int size) {
        this.size = size;
    }

    public void showPosition(Character character) {
        boolean breaking = false;
        for (int x = 0; x < map.length; ++x) {
            for (int y = 0; y < map[x].length; ++y) {
                if (map[x][y] == character.getToken()) {
                    if (x == character.getX() && y == character.getY()) {
                        System.out.println(character.getToken() + ":\n"
                                + "x: " + x + "\n"
                                + "y: " + y);
                        breaking = true;
                        break;
                    }
                }
            }
            if (breaking) break;
        }
        showMap();
    }

    public boolean checkPosition(Character character) {
        for (char[] chars : map) {
            for (char aChar : chars) {
                if (aChar == character.getToken()) {
                    if (aChar == map[character.getX()][character.getY()]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public char point(int x, int y) {
        return map[x][y];
    }

    private boolean checkCoordinates(int x, int y) {
        for (LinkedList<Integer> position : positions) {
            if (map[x][y] == position.get(0)) {
                if (x == position.get(1) && y == position.get(2))
                    return true;
            }
        }
        return false;
    }

    public void setPlayersInMap(ArrayList<Character> characters) {
        StringBuilder map = new StringBuilder();
        for (char[] chars : this.map)
            for (char aChar : chars) map.append(aChar);

        for (Character character : characters) {
            boolean isValid = true;
            while (isValid) {
                int point = (int) (Math.random() * (Math.pow(size, 2)));
                if (!pointIsValid(map.toString(), point, character.getToken())) {
                    character.setX(point / size);
                    character.setY(point % size);
                    map.deleteCharAt(point);
                    map.insert(point, character.getToken());
                    isValid = false;
                }
            }
        }
        this.map = nestingIntoAnArray(map.toString());
        setPersons(characters);
    }

    private boolean pointIsValid(int point) {
        return point >= 0 && point < getSize();
    }

    public int convertMap(int coordinate) {
        if (!pointIsValid(coordinate))
            if (coordinate > 0)
                return coordinate % getSize();
            else return coordinate + getSize();
        return coordinate;
    }

    private boolean pointIsValid(String map, int point, char token) {
        return map.charAt(point) == token;
    }

    private void addPosition(int x, int y) {
        LinkedList<Integer> position = new LinkedList<>();
        position.add((int) map[x][y]);
        position.add(x);
        position.add(y);
        positions.add(position);
    }

    public char getPoint(int x, int y) {
        return map[x][y];
    }

    public void setPoint(char token, int currentX, int currentY, int goToX, int goToY) {
        map[currentX][currentY] = '-';
        map[goToX][goToY] = token;
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

    /*
    * TODO
    *  Edit method toString();
    * */

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

    public ArrayList<Character> getPersons() {
        return characters;
    }

    public void setPersons(ArrayList<Character> characters) {
        this.characters = characters;
    }

    public Character getPerson(int x, int y) {
        for (Character character : characters)
            if (character.getX() == x && character.getY() == y) return character;
        return null;
    }

    public void deletePerson(Character character) {
        map[character.getX()][character.getX()] = '-';
        characters.remove(character);
    }
}
