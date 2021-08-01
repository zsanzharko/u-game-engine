package players;

import Map.Map;
import Map.Search;

import java.util.ArrayList;
import java.util.List;

public class Person implements IPerson, Search {
    private float health;
    private Map map;
    private int x;
    private int y;
    private List<ArrayList<String>> data;

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

    public void damage(float damage) {
        if (health - damage > 0)
            health -= damage;
        else health = -1f;
    }

    /**
     * Method find, finding a token in some point, that defined Math.random
     * @param token this finding.
     *              Example: Token 'P' = Princess
     * */
    @Override
    public boolean find(char token) {
        boolean findIt = false;
        int vector, point;
        while (!findIt) {
            point = (int) (getVision() - (Math.random() * (getVision() * 2)));
            vector = (int) (Math.random() * 6);
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
            if (point  + y >= map.getSize())
                point %= map.getSize() + y;
            else if (point + y< 0)
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
        return 1.5f;
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
}
