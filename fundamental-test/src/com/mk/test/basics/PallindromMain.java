package com.mk.test.basics;

public class PallindromMain {
    public static void main(String[] args) {
        pallindromNumber(121);
        pallindromNumber(1213);
        if(121 == pallindromNumberRecursion(121, 0, 0)) {
            System.out.println("121 is Pallindrom number");
        }
        if(1213 != pallindromNumberRecursion(1213, 0, 0)) {
            System.out.println("1213 is Not pallindrom number");
        }

    }

    public static void pallindromNumber(int num){
        int temp = num;
        int reverse = 0;
        while(temp > 0) {
            int remain = temp % 10;
            reverse = (reverse * 10) + remain;
            temp = temp/10;
        }

        if(reverse == num) {
            System.out.println(num + " is Pallindrom number");
        } else {
            System.out.println(num + " is Not pallindrom number");
        }
    }

    public static int pallindromNumberRecursion(int temp, int reverse, int remain){
        if(temp > 0) {
            remain = temp % 10;
            temp = temp/10;
            reverse = (reverse * 10) + remain;
            return pallindromNumberRecursion(temp, reverse, remain);
        } else {
            return reverse;
        }
    }
}
