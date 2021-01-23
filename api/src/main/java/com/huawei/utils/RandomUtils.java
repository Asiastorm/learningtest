package com.huawei.utils;


import java.util.UUID;

public class RandomUtils {

    public static String getRandomUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
