import java.util.Arrays;

/**
 * Dictionary
 * Created by Emil Gafiyatullin (Git:emilg1101)
 * on 21.02.18
 */

@SuppressWarnings("unchecked")
public class Dictionary<K, V> {

    private int DEFAULT_SIZE = 2;

    private K[] keys;
    private V[] values;

    private int count;
    private int size;
    private int cursor;

    public Dictionary() {
        cursor = 0;
        count = 0;
        size = DEFAULT_SIZE;
        keys = (K[]) new Object[DEFAULT_SIZE];
        values = (V[]) new Object[DEFAULT_SIZE];
    }

    public V get(Object key) {
        if (key == null) throw new NullPointerException();
        int keyIndex = _findKey(key);
        if (isEmpty() || keyIndex == size) return null;
        return values[keyIndex];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public K[] keys() {
        return keys;
    }

    public V[] elements() {
        return values;
    }

    public V put(K key, V value) {
        if (key == null || value == null) throw new NullPointerException();
        int keyIndex = _findKey(key);
        if (keyIndex == size) {
            size *= 2;
            keys = Arrays.copyOf(keys, size);
            values = Arrays.copyOf(values, size);
        }
        V prevValue = values[keyIndex];
        keys[keyIndex] = key;
        values[keyIndex] = value;
        if (keyIndex >= cursor) {
            count++;
            cursor++;
        }
        return prevValue;
    }

    public V remove(Object key) {
        if (key == null) throw new NullPointerException();
        int keyIndex = _findKey(key);
        if (keyIndex == size) return null;
        count--;
        V value = values[keyIndex];
        keys[keyIndex] = null;
        values[keyIndex] = null;
        return value;
    }

    public int size() {
        return count;
    }

    public void clear() {
        size = DEFAULT_SIZE;
        count = 0;
        cursor = 0;
        keys = (K[]) new Object[DEFAULT_SIZE];
        values = (V[]) new Object[DEFAULT_SIZE];
    }

    private int _findKey(Object key) {
        for (int i = 0; i < cursor; i++) {
            if (keys[i] != null && keys[i].equals(key)) {
                return i;
            }
        }
        return cursor;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int i = 0; i < cursor-1; i++) {
            if (keys[i] != null) {
                stringBuilder.append(keys[i]).append("=").append(values[i]).append(", ");
            }
        }
        if (count > 0) stringBuilder.append(keys[cursor - 1]).append("=").append(values[cursor - 1]);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
