package Map;

import Players.Person;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Map {
    private int size;
    private char[][] map;
    List<LinkedList<Integer>> positions = new LinkedList<>();
    private ArrayList<Person> persons = null;

    public Map() {
    }

    public Map(int size, char[][] map) {
        this.size = size;
        this.map = map;
    }

    public Map(int size) {
        this.size = size;
    }

    public void showPosition(Person person) {
        boolean breaking = false;
        for (int x = 0; x < map.length; ++x) {
            for (int y = 0; y < map[x].length; ++y) {
                if (map[x][y] == person.getToken()) {
                    if (x == person.getX() && y == person.getY()) {
                        System.out.println(person.getToken() + ":\n"
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

    public boolean checkPosition(Person person) {
        for (char[] chars : map) {
            for (char aChar : chars) {
                if (aChar == person.getToken()) {
                    if (aChar == map[person.getX()][person.getY()]) {
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

    public void setPlayersInMap(ArrayList<Person> persons) {
        StringBuilder map = new StringBuilder();
        for (char[] chars : this.map)
            for (char aChar : chars) map.append(aChar);

        for (Person person : persons) {
            boolean isValid = true;
            while (isValid) {
                int point = (int) (Math.random() * (Math.pow(size, 2)));
                if (!pointIsValid(map.toString(), point, person.getToken())) {
                    person.setX(point / size);
                    person.setY(point % size);
                    map.deleteCharAt(point);
                    map.insert(point, person.getToken());
                    isValid = false;
                }
            }
        }
        this.map = nestingIntoAnArray(map.toString());
        setPersons(persons);
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

    public ArrayList<Person> getPersons() {
        return persons;
    }

    public void setPersons(ArrayList<Person> persons) {
        this.persons = persons;
    }

    public Person getPerson(int x, int y) {
        for (Person person : persons)
            if (person.getX() == x && person.getY() == y) return person;
        return null;
    }

    public void deletePerson(Person person) {
        map[person.getX()][person.getX()] = '-';
        persons.remove(person);
    }
}
