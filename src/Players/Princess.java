package Players;

import Map.Map;

public class Princess extends Person {

    public Princess () {

    }

    public Princess (Map map) {
        super(map);
    }

    public Princess(int x, int y, Map map) {
        super(x, y, map);
    }

    public char getToken() {
        return 'P';
    }
}
