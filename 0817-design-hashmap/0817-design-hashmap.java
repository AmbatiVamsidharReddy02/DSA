import java.util.TreeMap;

class MyHashMap {
    private final int SIZE = 1000;
    private TreeMap<Integer, Integer>[] map;

    public MyHashMap() {
        map = new TreeMap[SIZE];
    }

    private int getIndex(int key) {
        return Integer.hashCode(key) % SIZE;
    }

    public void put(int key, int value) {
        int index = getIndex(key);
        if (map[index] == null) {
            map[index] = new TreeMap<>();
        }
        map[index].put(key, value);
    }

    public int get(int key) {
        int index = getIndex(key);
        return map[index] != null ? map[index].getOrDefault(key, -1) : -1;
    }

    public void remove(int key) {
        int index = getIndex(key);
        if (map[index] != null) {
            map[index].remove(key);
        }
    }
}