package players;

import somePackages.Map;
import somePackages.Search;

public class Hero extends Player {

    public Hero() {

    }

    public Hero(Map map) {
        super(map);
    }

    public Hero(int x, int y, Map map) {
        super(x, y, map);
    }

    public char getToken() {
        return 'H';
    }
}
