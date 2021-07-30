package somePackages;

public interface Search {
    default int find(Map map, char token) {
        return -1;
    }
}
