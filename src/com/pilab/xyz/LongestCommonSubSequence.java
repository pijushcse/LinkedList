package com.pilab.xyz;

import java.util.HashMap;
import java.util.Map;

public class LongestCommonSubSequence {

    public static void main(String[] args) {
        String s1 = "ABCDAF";
        String s2 = "ACBCT";

        int size = s1.length() > s2.length() ? s1.length() : s2.length();

        int[][] T = new int[s2.length() + 1][s1.length() + 1];

        for (int i = 1; i <= s2.length(); i++) {
            char c = s2.charAt(i - 1);
            for (int j = 1; j <= s1.length(); j++) {
                if (c == s1.charAt(j - 1)) {
                    T[i][j] = 1 + T[i - 1][j - 1];
                } else {
                    T[i][j] = Math.max(T[i][j - 1], T[i - 1][j]);
                }
            }
        }

        int j = s1.length() ;
        for (int i = s2.length(); i > 0; i--) {
            while(j > 0) {
                if( ( T[i][j-1] == T[i][j]) && ( T[i][j-1] == T[i-1][j]) && ( T[i-1][j] == T[i-1][j-1])) {
                   break;
                } else if( (T[i][j] == 1+T[i-1][j-1]) && ( T[i][j-1] == T[i-1][j]) && ( T[i-1][j] == T[i-1][j-1])) {
                    j --;
                    System.out.print(s2.charAt(i)+", ");
                    break;
                } 
                if( T[i-1][j] >= T[i][j-1]) {
                    break;
                } else {
                    j--;
                }
            }
            
        }
        
    }
}
