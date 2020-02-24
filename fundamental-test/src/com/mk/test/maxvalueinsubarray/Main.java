package com.mk.test.maxvalueinsubarray;

import java.util.Arrays;

public class Main {
    public static int maxValue(int[] list, int n){
        if(n == 1) {
            return list[0];
        } else {
            int[] subArray = Arrays.copyOfRange(list, 0, n + 1);
            return Math.max(list[n-1], maxValue(subArray, n-1));
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {2};
        System.out.println(maxValue(arr1, 1));
        int[] arr2 = {2,5,3,8,1,9,3,4,5,6,6,9,10,34,23,99,1,1,1};
        System.out.println(maxValue(arr2, 14));
    }
}
