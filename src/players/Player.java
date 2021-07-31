package players;

import somePackages.Map;
import somePackages.Search;

import java.util.ArrayList;
import java.util.List;

public class Player implements Person, Search {
    private Map map;
    private int x;
    private int y;
    private List<ArrayList<String>> data;

    public Player() {

    }

    public Player(Map map) {
        this.map = map;
    }

    public Player(int x, int y, Map map) {
        this.x = x;
        this.y = y;
        this.map = map;
        data = new ArrayList<>();
    }

    @Override
    public boolean find(Map map, char token) {
        boolean findIt = false;
        int num, point;
        while (!findIt) {
            point = (int) (getVision() - (Math.random() * (getVision() * 2)));
            num = (int) (Math.random() * 6);
            if (num >= 3)
                findIt = findToX(token, point);
            else
                findIt = findToY(token, point);
//            map.showMap();
//            try {
//                Thread.sleep(1000);
//            } catch (Exception e) {
//                System.out.println(e.getMessage());
//            }
//            System.out.println("\n");
        }
        return true;
    }

    private boolean findToX(char token, int point) {
        boolean find;
        point += x;
        if (point < 0)
            point += map.getSize() - 1;
        else if (point >= map.getSize())
            point %= map.getSize() - 1;

        if (map.getPoint(point, y) == token)
            return true;
        else move('x', point);
        return false;
    }

    private boolean findToY(char token, int point) {
        point += y;
        if (point < 0)
            point += map.getSize() - 1;
        else if (point >= map.getSize())
            point %= map.getSize() - 1;

        if (map.getPoint(x, point) == token)
            return true;
        else move('y', point);
        return false;
    }

    /**
     * @param coordinate is X, Y coordinate
     * @param point      is point when it going
     */
    @Override
    public void move(char coordinate, int point) {
        if (coordinate == 'x') {
            point += x;
            if (point >= map.getSize())
                point %= map.getSize();
            else if (point < 0)
                point += map.getSize();
            map.setPoint(getToken(), x, y, point, y);
            setX(point);
        } else {
            point += y;
            if (point >= map.getSize())
                point %= map.getSize();
            else if (point < 0)
                point += map.getSize();
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
