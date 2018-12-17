package com.mascode.lru;


import java.util.Map;

public interface LRUCache<K, V> extends Cache<K, V> {

    Map.Entry getSeq(Integer order);

    Map.Entry<K,V> getEldest();

    boolean isClearEldest(Map.Entry<K,V> entry);
}
