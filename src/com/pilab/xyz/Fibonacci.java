package com.pilab.xyz;

import java.util.stream.Stream;

public class Fibonacci {
    public static void main(String[] args) {
        
        int[] F=new int[10] ;
        F[0] = 0;
        F[1] = 1;
        
        for (int i = 2; i < F.length; i++) {
            F[i] = F[i-1] + F[i-2]; 
        }
        
        for (int i = 0; i < F.length; i++) {
            System.out.println(F[i]);
            
        }
    }
}
