package com.java_parabank_demo.helpers;

import java.util.UUID;

public class RandomGenerator {

    public static String GetRandom() {
        String random = UUID.randomUUID().toString().replace("-", "");
        return random.substring(0, 6);
    }
}
