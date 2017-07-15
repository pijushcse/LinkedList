package com.pilab.xyz;

public class BasePower {

    static int[] arr = null;

    public static void main(String[] args) {
        int base = 4;
        int power = 2;
        arr = new int[10 + 1];
        System.out.println(power(4, 6));
        System.out.println(pow(4, 6));
    }

    static long pow(long base, int power) {
        long result = base;
        while (power > 0) {
            if ((power & 1) == 0) {
                result *= base;
            }
            power >>= 1;
            base *= base;
        }
        return result;
    }

    public static int power(int base, int power) {
        if (power == 0) {
            return 1;
        }
        if (power == 1) {
            return base;
        }

        if (arr[power] != 0) {
            System.out.println("hit");
            return arr[power];
        }

        return arr[power] = base * power(base, power - 1);
    }
}
