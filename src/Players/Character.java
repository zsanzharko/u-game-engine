package Players;

import Map.Map2D;
import Map.Search;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.*;
import static scince.Algorithms.*;

public class Character implements ICharacter, Search {
    private float health;
    private Map2D map2D;
    private int x;
    private int y;
    private List<ArrayList<String>> data;
    private boolean live;

    public Character() {

    }

    public Character(Map2D map2D) {
        this.map2D = map2D;
    }

    public Character(int x, int y, Map2D map2D) {
        this.x = x;
        this.y = y;
        this.map2D = map2D;
        data = new ArrayList<>();
    }

    public void vision() {
        int vision = convertFloatToInt(getVision());
        int centerX = getX() - vision + 1;
        int centerY = getY() - vision + 1;
        for (int x = centerX; x < getX() + vision; ++x) {
            for (int y = centerY; y < getY() + vision; ++y) {
                int convertX = map2D.convertMap(x), convertY = map2D.convertMap(y);
                System.out.print(map2D.point(convertX, convertY) + " ");
                if (!(x == getX() && y == getY()))
                    checkPerson(convertX, convertY);
            }
            System.out.println();
        }
    }

    private void checkPerson(int x, int y) {
        switch (map2D.point(x, y)) {
            case 'E' -> {
                if (!damage(2f, map2D.getPerson(x, y))) {
                    map2D.deletePerson(map2D.getPerson(x, y));
                }
            }
            case 'P' -> {
                System.out.println("Heroes won!");
                System.exit(10);
            }
        }
    }

    public boolean damage(float damage, Character character) {
        if (character.health >= damage) {
            character.health -= damage;
            return true;
        } else {
            character.live = true;
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
            if (vector >= 3) findIt = findToCor(token, point, 'x');
            else findIt = findToCor(token, point, 'y');
        }
        return true;
    }

    private boolean findToCor(char token, int point, char coordinate) {
        int pointCoordinate;
        if (coordinate == 'x') {
            pointCoordinate = x;
        } else pointCoordinate = y;

        if (point + pointCoordinate < 0)
            point += map2D.getSize() - 1 + pointCoordinate;
        else if (point + pointCoordinate >= map2D.getSize())
            point %= map2D.getSize() - 1 + pointCoordinate;
        else point += pointCoordinate;
        if (map2D.getPoint(x, point) == token) {
            move(coordinate, point);
            return true;
        }
        move(coordinate, point);
        return false;
    }

    /**
     * @param coordinate is X, Y coordinate
     * @param point      is point when it going
     */
    @Override
    public void move(char coordinate, int point) {
        if (coordinate == 'x') {
            if (point + x >= map2D.getSize())
                point %= map2D.getSize() + x;
            else if (point + x < 0)
                point += map2D.getSize() + x;
            else point += x;
            map2D.setPoint(getToken(), x, y, point, y);
            setX(point);
        } else {
            if (point + y >= map2D.getSize())
                point %= map2D.getSize() + y;
            else if (point + y < 0)
                point += map2D.getSize() + y;
            else point += y;
            map2D.setPoint(getToken(), x, y, x, point);
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

    public Map2D getMap() {
        return map2D;
    }

    public void setMap(Map2D map2D) {
        this.map2D = map2D;
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
