package org.example.map;

public interface Map<K, V> {
    int size();
    boolean isEmpty();
    void add(K key, V value);
    V remove(K key);
    boolean contains(K key);
    V get(K key);
    void set(K key, V newValue);
}
