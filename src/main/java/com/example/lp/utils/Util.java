package com.example.lp.utils;

public class Util {
    public static boolean isValidString(String input) {
        if (input == null) {
            return false;
        }

        if (input.trim().isEmpty()) {
            return false;
        }

        return input.matches(".*\\w.*");
    }
}
