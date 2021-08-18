package Map;

public abstract class Map {
    private int size;

    public Map() {}

    public Map(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
