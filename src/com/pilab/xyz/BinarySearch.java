package com.pilab.xyz;

public class BinarySearch {

    public static void main(String[] args) {

        int[] ar = {2, 3, 7, 9, 77, 444};;
        System.out.println(binarySearchRecursive(ar, 0, ar.length - 1, 12));

    }

    public static int binarySearchRecursive(int[] arr, int l, int h, int k) {
        if (l < h) {
            int mid = (l + h) >> 1;
            if (arr[mid] == k) {
                return mid;
            }

            if (k < arr[mid]) {
                return binarySearchRecursive(arr, l, mid - 1, k);
            } else {
                return binarySearchRecursive(arr, mid + 1, h, k);
            }
        }
        return Integer.MIN_VALUE;
    }
}
