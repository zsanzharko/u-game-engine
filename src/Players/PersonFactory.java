package Players;

import Map.Map;

public class PersonFactory {
    public Person createPlayer(PersonType type, Map map) {
        Person person = null;
        switch (type) {
            case HERO -> person = new Hero(map);
            case ENEMY -> person = new Enemy(map);
            case PRINCESS -> person = new Princess(map);
        }
        return person;
    }
}
