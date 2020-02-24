package com.mk.test.stringproblem;

public class PairExchangeMain {
    public static String exchangePairs(String input){
        if (input.length() < 2)
            return input;
        else {
            String swappedPair = ""+input.charAt(1) + input.charAt(0);
            return swappedPair+exchangePairs(input.substring(2));
        }
    }

    public static void main(String[] args){
        System.out.println(exchangePairs("abcdefghi"));
        System.out.println(exchangePairs(""));
    }

}
