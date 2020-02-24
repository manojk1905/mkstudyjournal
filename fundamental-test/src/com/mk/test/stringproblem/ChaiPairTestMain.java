package com.mk.test.stringproblem;

public class ChaiPairTestMain {
    public static boolean charPairTest(String input){
        if (input.length() < 2)
            return false;
        else {
            boolean pairFlag = input.charAt(0) == input.charAt(1) ? true : false;
            if(!input.substring(2).isEmpty()) {
                return pairFlag && charPairTest(input.substring(2));
            } else {
                return pairFlag;
            }
        }
    }

    public static void main(String[] args){
        System.out.println(charPairTest("aabbcc"));
        System.out.println(charPairTest(""));
        System.out.println(charPairTest("aabcdd"));
    }

}
