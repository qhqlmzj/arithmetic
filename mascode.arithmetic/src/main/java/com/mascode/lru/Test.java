package com.mascode.lru;

import java.util.Map;

public class Test {
    public static void main(String args[]) {
        JDK();
        local();
    }

    public static void JDK() {
        System.out.println("********** JDK **********");
        LRUCache<String, Integer> lruCache = new LinkedHashMapLRU() {
            @Override
            public boolean isClearEldest(Map.Entry entry) {
                if (this.size() > 3) {
                    return true;
                }
                return false;
            }
        };
        lruCache.put("1", 1);
        System.out.println(lruCache);

        lruCache.put("2", 2);
        System.out.println(lruCache);

        lruCache.put("3", 3);
        System.out.println(lruCache);

        lruCache.put("4", 4);
        System.out.println(lruCache);

        lruCache.put("5", 5);
        System.out.println(lruCache);

        lruCache.put("6", 6);
        System.out.println(lruCache);

        lruCache.put("7", 7);
        System.out.println(lruCache);
        System.out.println("********** JDK **********");
    }

    public static void local() {
        System.out.println("********** local **********");
        LRUCache<String, Integer> lruCache = new LinkedMapLRU() {
            @Override
            public boolean isClearEldest(Map.Entry entry) {
                if (this.size() > 3) {
                    return true;
                }
                return false;
            }
        };
        lruCache.put("1", 1);
        System.out.println(lruCache);

        lruCache.put("2", 2);
        System.out.println(lruCache);

        lruCache.put("3", 3);
        System.out.println(lruCache);

        lruCache.put("4", 4);
        System.out.println(lruCache);

        lruCache.put("5", 5);
        System.out.println(lruCache);

        lruCache.put("6", 6);
        System.out.println(lruCache);

        lruCache.put("7", 7);
        System.out.println(lruCache);
        System.out.println("********** local **********");
    }
}
