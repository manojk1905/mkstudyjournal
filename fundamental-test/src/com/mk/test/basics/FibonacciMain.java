package com.mk.test.basics;

import java.util.Scanner;

public class FibonacciMain {

    public static void main(String[] args) {
        System.out.println("Enter number...");
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        System.out.println("Print fibonacci using loop...");
        printFibonacciUsingLoop(num);
        System.out.println("");
        System.out.println("Print fibonacci using recursion...");
        printFibonacciUsingRecursion(num, 0, 1);
    }

    public static void printFibonacciUsingLoop(int num) {
        int fibNumOne = 0;
        int fibNumTwo = 1;
        for (int count = 0; count < num; count++) {
            System.out.print(fibNumOne+ " ");
            int sum = fibNumOne + fibNumTwo;
            fibNumOne = fibNumTwo;
            fibNumTwo = sum;
        }
    }

    public static void printFibonacciUsingRecursion(int num, int fibNumOne, int fibNumTwo) {
        if (num > 0) {
            System.out.print(fibNumOne+ " ");
            int sum = fibNumOne + fibNumTwo;
            fibNumOne = fibNumTwo;
            fibNumTwo = sum;
            printFibonacciUsingRecursion(--num, fibNumOne, fibNumTwo);
        }
    }

}
