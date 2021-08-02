package Players;

import Map.Map;
import Map.Search;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.*;
import static scince.Algorithms.*;

public class Person implements IPerson, Search {
    private float health;
    private Map map;
    private int x;
    private int y;
    private List<ArrayList<String>> data;
    private boolean live;

    public Person() {

    }

    public Person(Map map) {
        this.map = map;
    }

    public Person(int x, int y, Map map) {
        this.x = x;
        this.y = y;
        this.map = map;
        data = new ArrayList<>();
    }

    public void vision() {
        int vision = convertFloatToInt(getVision());
        int centerX = getX() - vision + 1;
        int centerY = getY() - vision + 1;
        for (int x = centerX; x < getX() + vision; ++x) {
            for (int y = centerY; y < getY() + vision; ++y) {
                int convertX = map.convertMap(x), convertY = map.convertMap(y);
                System.out.print(map.point(convertX, convertY) + " ");
                if (!(x == getX() && y == getY()))
                    checkPerson(convertX, convertY);
            }
            System.out.println();
        }
    }

    private void checkPerson(int x, int y) {
        switch (map.point(x, y)) {
            case 'E' -> {
                if (!damage(2f, map.getPerson(x, y))) {
                    map.deletePerson(map.getPerson(x, y));
                }
            }
            case 'P' -> {
                System.out.println("Heroes won!");
                System.exit(10);
            }
        }
    }

    public boolean damage(float damage, Person person) {
        if (person.health >= damage) {
            person.health -= damage;
            return true;
        } else {
            person.live = true;
            return false;
        }
    }

    public boolean damage(float valueDamage) {
        return false;
    }


    /**
     * Method find, finding a token in some point, that defined Algorithms.random
     *
     * @param token this finding.
     *              Example: Token 'P' = Princess
     */
    @Override
    public boolean find(char token) {
        boolean findIt = false;
        int vector, point;
        while (!findIt) {
            point = (int) (getVision() - (random() * (getVision() * 2)));
            vector = (int) (random() * 6);
            if (vector >= 3) findIt = findToX(token, point);
            else findIt = findToY(token, point);
        }
        return true;
    }

    private boolean findToX(char token, int point) {
        if (point + x < 0)
            point += map.getSize() - 1 + x;
        else if (point + x >= map.getSize())
            point %= map.getSize() - 1 + x;
        else point += x;

        if (map.getPoint(point, y) == token) {
            move('x', point);
            return true;
        }
        move('x', point);
        return false;
    }

    private boolean findToY(char token, int point) {
        if (point + y < 0)
            point += map.getSize() - 1 + y;
        else if (point + y >= map.getSize())
            point %= map.getSize() - 1 + y;
        else point += y;
        if (map.getPoint(x, point) == token) {
            move('y', point);
            return true;
        }
        move('y', point);
        return false;
    }

    /**
     * @param coordinate is X, Y coordinate
     * @param point      is point when it going
     */
    @Override
    public void move(char coordinate, int point) {
        if (coordinate == 'x') {
            if (point + x >= map.getSize())
                point %= map.getSize() + x;
            else if (point + x < 0)
                point += map.getSize() + x;
            else point += x;
            map.setPoint(getToken(), x, y, point, y);
            setX(point);
        } else {
            if (point + y >= map.getSize())
                point %= map.getSize() + y;
            else if (point + y < 0)
                point += map.getSize() + y;
            else point += y;
            map.setPoint(getToken(), x, y, x, point);
            setY(point);
        }
    }


    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public List<ArrayList<String>> getData() {
        return data;
    }

    public void setData(List<ArrayList<String>> data) {
        this.data = data;
    }

    public float getVision() {
        return 2.6f;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public char getToken() {
        return 'A';
    }

    public boolean isLive() {
        return live;
    }

    public void setLive(boolean live) {
        this.live = live;
    }
}
