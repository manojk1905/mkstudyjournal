package com.mk.test.stringproblem;

public class Main {

    public static int countLetter(String input, String letter) {
        if (input.length() == 0) {
            return 0;
        }
        if (String.valueOf(input.charAt(0)).equals(letter)) {
            return 1 + countLetter(input.substring(1, (input.length())), letter);
        } else {
            return countLetter(input.substring(1, (input.length())), letter);
        }
    }

    public static void main(String[] args) {
        System.out.println(countLetter("abc", "z"));
        System.out.println(countLetter("abcabcd", "d"));
        System.out.println(countLetter("abcabcd", "a"));
    }
}
