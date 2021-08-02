package scince;

public class Algorithms {

    public Algorithms() {}

    public static int convertFloatToInt(float number) {
        if (number % 1 >= 0.5f) return (int) (number) + 1;
        return (int) number;
    }
}
