package players;

import somePackages.Map;
import somePackages.Search;

import java.util.ArrayList;
import java.util.List;

public class Player implements Person, Search {
    private int x;
    private int y;
    private boolean isStanding;
    private List<ArrayList<String>> data;

    public Player() {

    }

    public Player(int x, int y) {
        this.x = x;
        this.y = y;
        isStanding = true;
        data = new ArrayList<>();
    }

    @Override
    public int move(char coordinate, int speed) {
        isStanding = false;
        if (coordinate == 'x') {
            setX(x + speed);
            isStanding = true;
            return getX();
        } else {
            setY(y + speed);
            isStanding = true;
            return getY();
        }

    }

    @Override
    public int find(Map map, char token) {
        long startTime = System.currentTimeMillis();
        boolean findIt = false;
        while (!findIt) {
            double num = (Math.random() * getVision());
            int vectorX, vectorY;
            vectorX = 1 - (int) (Math.random() + 3);
            vectorY = 1 - (int) (Math.random() + 3);
            for (int i = x; !findIt ;) {

                for (int k = y; !findIt;) {


                    if (map.getPoint(i, k) == token)
                        findIt = true;
                }
            }
        }
        System.out.println(System.currentTimeMillis() - startTime);
        return 1;
    }

    @Override
    public boolean isStanding() {
        return isStanding;
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
        return 2.5f;
    }
}
