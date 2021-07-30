package players;

import somePackages.Search;

public class Hero extends Player {

    public Hero() {

    }

    public Hero(int x, int y) {
        super(x, y);
    }

    public char getToken() {
        return 'S';
    }
}
