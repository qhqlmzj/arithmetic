package com.mascode.lru;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 实现2 借助Map数据结构和链表进行的实现
 *
 * @param <K>
 * @param <V>
 */
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
        if (linked.size() == 0) {
            return null;
        }
        return linked.getFirst();
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
        map.put(key, value);
        linked.add(new LRUEntry<>(key, value));
        Map.Entry<K, V> entry = getEldest();
        if (isClearEldest(entry)) {
            if (entry != null) {
                map.remove(entry.getKey());
                linked.remove(entry);
            }
        }
    }

    @Override
    public boolean remove(K key) {
        V v = map.remove(key);
        linked.remove(v);
        return v != null;
    }

    @Override
    public String toString() {
        return map.toString();
    }

    @Override
    public long size() {
        return map.size();
    }

    public static class LRUEntry<K, V> implements Map.Entry<K, V> {
        private K k;
        private V v;

        public LRUEntry(K k, V v) {
            this.k = k;
            this.v = v;
        }

        @Override
        public K getKey() {
            return this.k;
        }

        @Override
        public V getValue() {
            return this.v;
        }

        @Override
        public V setValue(V value) {
            this.v = value;
            return this.v;
        }
    }
}