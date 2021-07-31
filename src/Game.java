import players.Hero;
import players.Princess;
import somePackages.Map;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Sanzhar Zhanibekov
 * @version 1.0
 */

public class Game {
    private static String inputsData = readInputs();
    private static int size;

    public static void main(String[] args) {
        long timeStart = System.currentTimeMillis();
//        List<Character> players = new ArrayList<>();
//        players.add('H');
//        players.add('P');
//        int size = 5;
//        setInputsData(generateMap(size));
//        setInputsData(setPlayers(players, getInputsData()));
        Map map = new Map(size, nestingIntoAnArray());
        Princess princess = new Princess(map);
        Hero hero = new Hero(map);

        map.checkPosition(princess, hero);
        boolean find = hero.find(map, princess.getToken());
        long timeEnd = System.currentTimeMillis();
//        System.out.println(find ? "I found u" : "I dont found u");
        System.out.println((timeEnd - timeStart) + " ms");
//        DbHandler dbHandler = null;
//
//        try {
//            dbHandler = DbHandler.getInstance();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        boolean find = hero.find(map, princess.getToken());
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

    private static String generateMap(int size) {
        StringBuilder map = new StringBuilder();
        setSize(size);
        map.append("-".repeat(size).repeat(size));
        return map.toString();
    }

    private static String setPlayers(List<Character> players, String map) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(map);

        for (Character player : players) {
            stringBuilder.insert((int) (Math.random() * (Math.pow(size, 2))), player);
        }
        return stringBuilder.toString();
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
