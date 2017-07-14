package com.pilab.xyz;

public class DutchFlag {

    public static void main(String[] args) {
        int[] arr = {1, 1, 0, 0, 2, 2, 1, 0, 1, 0, 1, 2, 1, 2, 2, 0};
        sort(arr);
        print(arr);
    }

    static void sort(int[] arr) {
        int low = 0, mid = 0, high = arr.length - 1;
         while (mid <= high) {
            switch (arr[mid]) {
                case 0:
                    swap(arr, low, mid);
                    low++;
                    mid++;
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    swap(arr, mid, high);
                    high--;
                    break;
            }
        }
    }

    public static void print(int[] a) {
        for (int j = 0; j < a.length; j++) {
            System.out.print(a[j] + ",");
        }
        System.out.println("");
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
