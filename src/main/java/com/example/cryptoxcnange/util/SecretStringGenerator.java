package com.example.cryptoxcnange.util;

import java.util.Random;

public class SecretStringGenerator {
    public static String generateRandomString( ){
        int length = 16;
        Random random = new Random();
        StringBuffer buffer = new StringBuffer();
        while (buffer.length() < length){
            buffer.append(Integer.toHexString(random.nextInt()));
        }
        return buffer.toString().substring(0,length);
    }
}
