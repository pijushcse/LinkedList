package com.pilab.xyz;

import java.util.Arrays;

public class ThreeSum {

    public static void main(String[] args) {
        int[] a = {-3, -2, 5, 7, 10, 19, 21};
        threeSum(a, 0);
    }

    public static void threeSum(int[] a, int s) {
        Arrays.sort(a);
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1, k = a.length - 1; j < k;) {
                if (a[i] + a[j] + a[k] == s) {
                    System.out.println(a[i] + ", " + a[j] + ", " + a[k]);
                    return;
                } else if (a[i] + a[j] + a[k] < s) {
                    j++;
                } else {
                    k--;
                }
            }
        }
    }
}
