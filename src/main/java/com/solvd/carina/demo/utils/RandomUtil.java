package com.solvd.carina.demo.utils;

import java.util.Random;

public class RandomUtil {

    public String getRandomNumber(int numDigits) {
        if (numDigits < 1) {
            throw new IllegalArgumentException("Number of digits must be at least 1.");
        }
        int min = (int) Math.pow(10, numDigits - 1);
        int max = (int) Math.pow(10, numDigits) - 1;
        int result = (int) (Math.random() * (max - min + 1) + min);
        return String.valueOf(result);
    }

    public String getRandomString(int length) {
        final String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            char randomChar = characters.charAt(index);
            sb.append(randomChar);
        }

        return sb.toString();
    }
}
