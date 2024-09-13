package com.base.map;

import java.util.concurrent.ConcurrentHashMap;

public class Map {
    public static void main(String[] args) {
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>(64, 0.75f, 4);
        map.put("", "");


        final int HASH_BITS = 0x7fffffff;

        int h = 213132;
        System.out.println((h ^ (h >>> 16)) & HASH_BITS);
    }
}
