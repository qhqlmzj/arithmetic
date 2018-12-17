package com.mascode.lru;

public interface Cache<K, V> {

    V get(K key);

    void put(K key, V value);

    boolean remove(K key);

    long size();
}