package com.mk.test.basics;

import java.util.Scanner;

public class ArmstrongNumberMain {
    public static void main(String[] args) {
        System.out.println("Enter number..");
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        armstrongNum(num);
        if(num == armstrongNumRecursion(num, 0, num)) {
            System.out.println(num + " is Armstrong number");
        } else {
            System.out.println(num + " is Not Armstrong number");
        }

    }

    public static void armstrongNum(int num){
        int temp = num;
        int sum = 0;
        while(temp > 0) {
            int remain = temp % 10;
            sum = sum + remain*remain*remain;
            temp = temp/10;
        }
        if(sum == num) {
            System.out.println(num + " is Armstrong number");
        } else {
            System.out.println(num + " is Not Armstrong number");
        }
    }

    public static int armstrongNumRecursion(int num, int sum, int temp){
        if (temp > 0) {
            int remain = temp % 10;
            sum = sum + remain*remain*remain;
            temp = temp/10;
            return armstrongNumRecursion(num, sum, temp);
        } else {
            return sum;
        }
    }
}
