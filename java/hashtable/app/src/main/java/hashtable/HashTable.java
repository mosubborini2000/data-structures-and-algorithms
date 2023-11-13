package hashtable;

import java.util.ArrayList;
import java.util.HashMap;
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

    public String hashmapRepeatedWord(String sentence) {
        HashMap<String, Integer> hashMap = new HashMap<>();

        for (String word : sentence.split(" ")) {
            if (word.endsWith(",")) {
                word = removeLastChar(word);
            }
            int count = hashMap.get(word.toLowerCase()) != null ? hashMap.get(word) : 0;
            if (count == 1) {
                return word;
            }
            hashMap.put(word.toLowerCase(), count + 1);
        }

        return null;
    }

    public String removeLastChar(String s) {
        return (s == null || s.length() == 0)
                ? null
                : (s.substring(0, s.length() - 1));
    }


    public static List<List<String>> leftJoin(HashTable<String, String> synonyms, HashTable<String, String> antonyms) {
        List<List<String>> results = new ArrayList<>();

        for (String key : synonyms.keys()) {
            List<String> row = new ArrayList<>();
            row.add(key);
            String synonym = synonyms.get(key);
            if (synonym != null) {
                row.add(synonym);
            } else {row.add(null);}
            String antonym = antonyms.get(key);
            if (antonym != null) {
                row.add(antonym);
            } else {row.add(null);
            }
            results.add(row);
        }

        return results;
    }


}


