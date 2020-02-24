package com.mk.test.palindrome;

public class Main {

    public static boolean palindrome(String input) {
        if (input.length() == 0 || input.length() == 1) {
            return true;
        }
        if (input.charAt(0) != input.charAt(input.length() - 1)) {
            return false;
        }
        return palindrome(input.substring(1, input.length() - 1));
    }

    public static void main(String[] args) {
        System.out.println(palindrome("abcba"));
        System.out.println(palindrome("abcd"));
        System.out.println(palindrome(" "));
        System.out.println(palindrome(" 12"));
    }
}
