package com.pilab.xyz;

import java.util.ArrayList;
import java.util.List;

public class ContigiousSum {

    public static void main(String[] args) {
        System.out.println(contigiousSumDP(new int[]{-2, 11, -20, 50, 2, -80,3,5}));
    }

    public static int contigiousSumDP(int[] a) {
        int[] M = new int[a.length];
        if (a[0] > 0) {
            M[0] = a[0];
        }
        int maxSoFar = 0;

        for (int i = 1; i < a.length; i++) {
            if (M[i - 1] + a[i] > 0) {
                M[i] = M[i - 1] + a[i];
                if(M[i] > maxSoFar) {
                    maxSoFar = M[i];                
                }
            } else {
                M[i] = 0;
            }
        }
        
        return maxSoFar;
    }

    public static int contigiousSum(int[] a) {
        int sumSoFar = 0, sumEnding = 0;

        for (int i = 0; i < a.length; i++) {
            sumEnding += a[i];
            if (sumEnding < 0) {
                sumEnding = 0;
                continue;
            }
            if (sumSoFar < sumEnding) {
                sumSoFar = sumEnding;
            }
        }
        return sumSoFar;
    }
}
