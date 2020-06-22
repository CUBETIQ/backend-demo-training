package com.cubetiqs.demo.util;

public final class StringUtils {
    public static String stringQuery(String q) {
        return "%" + q.toLowerCase() + "%";
    }
}

