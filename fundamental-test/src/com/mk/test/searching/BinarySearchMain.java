package com.mk.test.searching;

public class BinarySearchMain {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        int element = 6;
        System.out.println(binarySearch(arr, 0, arr.length -1, element));
    }

    public static int binarySearch(int[] arr, int startIndex, int endIndex, int element) {
        if(endIndex >= 1) {
            int middle = startIndex + (endIndex - 1) / 2 ;
            if(arr[middle] == element) {
                return  middle;
            } else if (arr[middle] > element) {
                return binarySearch(arr, 1, middle - 1, element);
            } else {
                return binarySearch(arr, middle + 1, endIndex, element);
            }
        }
        return -1;
    }

}
