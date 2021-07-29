package players;

public class Princess extends Player {

    public Princess () {

    }

    public Princess(int x, int y) {
        super(x, y);
    }

    public char getToken() {
        return 'P';
    }
}
