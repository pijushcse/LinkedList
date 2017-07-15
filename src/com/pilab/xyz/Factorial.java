package com.pilab.xyz;

public class Factorial {

    static int[] arr;

    public static void main(String[] args) {
        int n = 7;
        arr = new int[50];
        arr[0] = 1;
        arr[1] = 1;

        System.out.println("15! =" + fact(15));
        System.out.println("10! =" + fact(10));
        System.out.println(n + "! =" + fact(n));
    }

    public static int fact(int n) {
        if (arr[n] != 0) {
            return arr[n];
        }
        return arr[n] = n * fact(n - 1);
    }
}
