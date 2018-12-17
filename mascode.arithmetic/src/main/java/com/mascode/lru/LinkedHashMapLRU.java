package com.mascode.lru;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapLRU<K, V> implements LRUCache<K, V> {
    private LinkedHashMap<K, V> linkedHashMap = null;

    public LinkedHashMapLRU() {
        linkedHashMap = new LinkedHashMap(16, .75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return isClearEldest(eldest);
            }
        };
    }

    @Override
    public Map.Entry getSeq(Integer order) {
        int index = 0;
        for (Map.Entry<K, V> entry : linkedHashMap.entrySet()) {
            if (index++ == order) {
                return entry;
            }
        }
        return null;
    }

    @Override
    public Map.Entry getEldest() {
        int order = linkedHashMap.size();
        return getSeq(order);
    }

    @Override
    public boolean isClearEldest(Map.Entry entry) {
        return false;
    }

    @Override
    public V get(K key) {
        return linkedHashMap.get(key);
    }

    @Override
    public void put(K key, V value) {
        linkedHashMap.put(key, value);
    }

    @Override
    public boolean remove(K key) {
        return linkedHashMap.remove(key) != null;
    }

    @Override
    public long size() {
        return linkedHashMap.size();
    }
}
