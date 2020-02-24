package com.mk.test.stringproblem;

import java.util.Scanner;

public class AllPermutationMain {
    public static void allIntegers(String numbers, String result)
    {
        if (numbers.isEmpty()) {
            System.out.println(result);
            return;
        }

        for (int i = 0; i < numbers.length(); i++) {
            char ch = numbers.charAt(i);
            String ros = numbers.substring(0, i) +numbers.substring(i + 1);
            allIntegers(ros, result + ch);
        }
    }


    public static void main( String[] args ){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter an integer.");
        int val = sc.nextInt();
        allIntegers( Integer.toString( val ), "" );
    }

}