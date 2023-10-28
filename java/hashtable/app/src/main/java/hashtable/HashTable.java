package hashtable;

import java.util.ArrayList;
import java.util.List;

public class HashTable<K, V> {
    private static final int DEFAULT_CAPACITY = 16;
    private List<List<KeyValue<K, V>>> table;
    private int size;

    public HashTable() {
        table = new ArrayList<>(DEFAULT_CAPACITY);
        for (int i = 0; i < DEFAULT_CAPACITY; i++) {
            table.add(new ArrayList<>());
        }
        size = 0;
    }

    public void set(K key, V value) {
        int index = hash(key);
        List<KeyValue<K, V>> bucket = table.get(index);

        for (KeyValue<K, V> kv : bucket) {
            if (kv.key.equals(key)) {
                kv.value = value;
                return;
            }
        }

        bucket.add(new KeyValue<>(key, value));
        size++;


        if (size >= table.size()) {
            resize();
        }
    }

    private int hash(K key) {
        return key.hashCode() % table.size();
    }

    private void resize() {
        List<List<KeyValue<K, V>>> newTable = new ArrayList<>(table.size() * 2);
        for (int i = 0; i < table.size() * 2; i++) {
            newTable.add(new ArrayList<>());
        }

        for (List<KeyValue<K, V>> bucket : table) {
            for (KeyValue<K, V> kv : bucket) {
                int newIndex = kv.key.hashCode() % newTable.size();
                newTable.get(newIndex).add(kv);
            }
        }

        table = newTable;
    }

    public V get(K key) {
        int index = hash(key);
        List<KeyValue<K, V>> bucket = table.get(index);

        for (KeyValue<K, V> kv : bucket) {
            if (kv.key.equals(key)) {
                return kv.value;
            }
        }

        return null;
    }

    public boolean has(K key) {
        int index = hash(key);
        List<KeyValue<K, V>> bucket = table.get(index);

        for (KeyValue<K, V> kv : bucket) {
            if (kv.key.equals(key)) {
                return true;
            }
        }

        return false;
    }

    public List<K> keys() {
        List<K> keys = new ArrayList<>();
        for (List<KeyValue<K, V>> bucket : table) {
            for (KeyValue<K, V> kv : bucket) {
                keys.add(kv.key);
            }
        }
        return keys;
    }
}
