import players.*;
import Map.Map;

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
    static ArrayList<Person> persons = new ArrayList<>();

    public static void main(String[] args) {
        Map map = new Map(10);
        map.generateMap();

        createPerson(1, PersonType.PRINCESS, map);
        createPerson(2, PersonType.HERO, map);
        createPerson(10, PersonType.ENEMY, map);

        map.setPlayersInMap(persons);

        int count = 0;
        for(Person person : persons) {
            System.out.println(count++);
            map.showPosition(person);
            System.out.println(map.checkPosition(person));
        }
    }

    private static void createPerson(int count, PersonType type, Map map) {
        for (int i = 0; i < count; ++i) {
            persons.add(new PersonFactory().createPlayer(type, map));
        }
    }

    static String readInputs() {
        Scanner inputs = null;
        StringBuilder string = new StringBuilder();
        try {
            inputs = new Scanner(
                    new File("C:\\Users\\Legion\\IdeaProjects\\Map Game\\src\\INPUTS.txt"));
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
