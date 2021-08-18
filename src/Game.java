import Players.*;
import Map.Map2D;
import Players.Character;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Sanzhar Zhanibekov
 * @version 1.0
 */

public class Game {
    private static String inputsData = readInputs();
    private static int size;
    static ArrayList<Character> characters = new ArrayList<>();

    public static void main(String[] args) {
        Map2D map = new Map2D(20);
        map.generateMap();

        createPerson(1, PersonType.PRINCESS, map);
        createPerson(1, PersonType.HERO, map);
        createPerson(30, PersonType.ENEMY, map);

        map.setPlayersInMap(characters);
        for (Character character : characters) {
            map.checkPosition(character);
            map.showPosition(character);
        }
    }

    private static void createPerson(int count, PersonType type, Map2D map2D) {
        for (int i = 0; i < count; ++i) {
            characters.add(new PersonFactory().createPlayer(type, map2D));
        }
    }

    static String readInputs() {
        Scanner inputs = null;
        StringBuilder string = new StringBuilder();
        try {
            inputs = new Scanner(
                    new File("C:\\Users\\Legion\\IdeaProjects\\u-game-engine\\src\\INPUTS.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if (inputs != null) {
            size = Integer.parseInt(inputs.next());
            while (inputs.hasNext()) {
                string.append(inputs.next());
            }
        }
        return string.toString();
    }

    private void DBConnection() {
        DbHandler dbHandler = null;
        try {
            dbHandler = DbHandler.getInstance();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static String getInputsData() {
        return inputsData;
    }

    public static void setInputsData(String inputsData) {
        Game.inputsData = inputsData;
    }

    public static int getSize() {
        return size;
    }

    public static void setSize(int size) {
        Game.size = size;
    }
}
