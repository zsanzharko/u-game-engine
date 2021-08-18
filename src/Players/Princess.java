package Players;

import Map.Map2D;

public class Princess extends Character {

    public Princess () {

    }

    public Princess (Map2D map2D) {
        super(map2D);
    }

    public Princess(int x, int y, Map2D map2D) {
        super(x, y, map2D);
    }

    public char getToken() {
        return 'P';
    }
}
