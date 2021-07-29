package players;

public class Player implements Person {
    private int x;
    private int y;

    public Player() {

    }

    public Player(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int move(char coordinate, int speed) {
        if (coordinate == 'x') {
            setX(x + speed);
            return getX();
        } else {
            setY(y + speed);
            return getY();
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
}
