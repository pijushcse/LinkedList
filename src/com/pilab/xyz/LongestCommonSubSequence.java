package com.pilab.xyz;

import java.util.HashMap;
import java.util.Map;

public class LongestCommonSubSequence {

    public static void main(String[] args) {
        String s1 = "ABCDAF";
        String s2 = "ACBCT";

        int size = s1.length() > s2.length() ? s1.length() : s2.length();

        int[][] arr = new int[s2.length() + 1][s1.length() + 1];
        System.out.println(arr.length);

        Map<Integer, Boolean> m = new HashMap<>();
        
        for (int i = 1; i <= s2.length(); i++) {
            char c = s2.charAt(i - 1);
             for (int j = 1; j <= s1.length(); j++) {
                if (c == s1.charAt(j - 1)) {
                    arr[i][j] = 1 + arr[i - 1][j - 1];
                } else {
                    arr[i][j] = Math.max(arr[i][j - 1], arr[i - 1][j]);
                }
            }
        }

//        for (int i = arr.length - 1; i > 0; i--) {
//            int[] is = arr[i];
//            for (int j = is.length - 1; j > 0; j--) {
//                if( is[j] != arr[i-1][j-1] && is[j-1] == arr[i-1][j] ) {
//                    System.out.println(s2.charAt(i));
//                    
//                }
//            }
//            System.out.println();
//        }


        
    }
}
