package com.mascode.lru;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LinkedMapLRU<K, V> implements LRUCache<K, V> {
    private Map<K, V> map = new HashMap<>();
    private LinkedList<Map.Entry<K, V>> linked = new LinkedList<>();


    @Override
    public Map.Entry<K, V> getSeq(Integer order) {
        int index = 0;
        for (Map.Entry<K, V> entry : map.entrySet()) {
            if (index++ == order) {
                return entry;
            }
        }
        return null;
    }

    @Override
    public Map.Entry<K, V> getEldest() {
        return linked.getLast();
    }

    @Override
    public boolean isClearEldest(Map.Entry<K, V> entry) {
        return false;
    }

    @Override
    public V get(K key) {
        return null;
    }

    @Override
    public void put(K key, V value) {
        Map.Entry<K, V> entry = getEldest();
        if (isClearEldest(entry)) {
            map.remove(entry.getKey());
            linked.remove(entry);
        }
        map.put(key, value);
        linked.add(new Map.Entry<K, V>() {
            @Override
            public K getKey() {
                return key;
            }

            @Override
            public V getValue() {
                return value;
            }

            @Override
            public V setValue(V value) {
                return value;
            }
        });
    }

    @Override
    public boolean remove(K key) {
        V v = map.remove(key);
        linked.remove(v);
        return v != null;
    }

    @Override
    public long size() {
        return map.size();
    }
}
