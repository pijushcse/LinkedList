package com.pilab.xyz.graph;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;

public class Dfs {
    public static void main(String[] args) {
        String[] a = {"aa", "bb", "cc"};
        String[] b = {"bb", "aa", "cc"};
        
        System.out.println(Arrays.toString(b));
        Arrays.sort(b, (s1, s2)->s1.compareTo(s2));
        System.out.println(Arrays.toString(b));
        
        
        
        System.out.println(Arrays.deepEquals(a, b));
        
        int val = 0;
        for (int i = 0; i < b.length; i++) {
            
            //val ^= a[i] ^ b[i];
        }
        
    }
}
