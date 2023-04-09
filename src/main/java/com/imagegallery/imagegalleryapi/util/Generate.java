package com.imagegallery.imagegalleryapi.util;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class Generate {

    private static String letters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static String numbers = "1234567890";

    public String generateId(int prefixLength, int IdLength){
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < IdLength; i++) {
            builder.append(numbers.charAt(new Random().nextInt(numbers.length()-1)));
        }
        String generatedNumbers = builder.toString();
        String generatedPrefix = generatePrefix(prefixLength);

        return generatedPrefix + "-" + generatedNumbers;
    }

    private String generatePrefix(int prefixLength){
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < prefixLength; i++) {
            builder.append(letters.charAt(new Random().nextInt(letters.length()-1)));
        }

        return builder.toString();
    }
}
