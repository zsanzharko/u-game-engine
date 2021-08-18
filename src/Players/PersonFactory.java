package Players;

import Map.Map2D;

public class PersonFactory {
    public Character createPlayer(PersonType type, Map2D map2D) {
        Character character = null;
        switch (type) {
            case HERO -> character = new Hero(map2D);
            case ENEMY -> character = new Enemy(map2D);
            case PRINCESS -> character = new Princess(map2D);
        }
        return character;
    }
}
