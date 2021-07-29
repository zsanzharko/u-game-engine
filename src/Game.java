import players.Hero;
import players.Princess;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author Sanzhar Zhanibekov
 * @version 1.0
 */

public class Game {
    private static String inputsData = readInputs();
    static int size;

    public static void main(String[] args) {
        Map map = new Map(size, nestingIntoAnArray());

        Princess princess = new Princess();
        Hero hero = new Hero();

//        map.checkPosition(princess, hero);
    }

    public static void moveToFind(Princess princess, Hero hero, Map map) {
        char[][] currentMap = map.getMap();
        boolean findIt = false;
    }

    static String readInputs() {
        Scanner inputs = null;
        StringBuilder string = new StringBuilder();
        try {
            inputs = new Scanner(
                    new File("C:\\Users\\Legion\\IdeaProjects\\Map Game\\src\\mapGame\\INPUTS.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if (inputs != null) {
            while (inputs.hasNext()) {
                string.append(inputs.next());
            }
            size = Integer.parseInt(String.valueOf(string.charAt(0)));
            string.delete(0, 1);
        }
        return string.toString();
    }

    public static char[][] nestingIntoAnArray() {
        char[][] c = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int k = 0; k < size; k++) {
                c[i][k] = getInputsData().charAt(k);
            }
            setInputsData(getInputsData().substring(size));
        }
        return c;
    }

    public static String getInputsData() {
        return inputsData;
    }

    public static void setInputsData(String inputsData) {
        Game.inputsData = inputsData;
    }
}
