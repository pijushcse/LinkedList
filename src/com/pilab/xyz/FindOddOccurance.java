package com.pilab.xyz;

public class FindOddOccurance {

    public static void main(String[] args) {

        int[] arr = {5,5, 7, 5};
        int[] count = new int[32];
        int maxBit = 0;

        for (int i = 0; i < arr.length; i++) {
            int n = arr[i];
            int p = 31;
            while (n > 0) {
                count[p] += n & 1;
                n >>= 1;
                p--;
            }
            if (p > maxBit) {
                maxBit = p;
            }
        }
        int occurance = 0;
        int i = 0;
        for (int j = count.length - 1; j > maxBit; j--) {
            int t = count[j] % 3;
            occurance += t * Math.pow(2, i++);
        }
        System.out.println(occurance);
    }
}
