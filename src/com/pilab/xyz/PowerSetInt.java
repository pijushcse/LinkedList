package com.pilab.xyz;

import java.util.Arrays;

public class PowerSetInt {

    public static void main(String[] args) {
        int[] arr = {4, 55, 6, 7};
        permute(arr, 0, arr.length - 1);
    }

    public static void permute(int[] arr, int low, int high) {
        if (low == high) {
            System.out.println(Arrays.toString(arr));
        } else {
            for (int i = low; i <= high; i++) {
                swap(arr, low, i);
                permute(arr, low + 1, high);
                swap(arr, low, i);
            }
        }
    }

    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j]; 
        a[j] = temp;
    }

}
