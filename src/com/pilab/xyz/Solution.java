package com.pilab.xyz;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Solution {

    public static void main(String[] args) {
        //System.out.println(1 + (6 ^ (~6)));

        System.out.println(checkAnagramV2("adbc", "dcab"));
        System.out.println(checkAnagramV3("adbe", "deab"));

        int[] firstArray = {1, 2, 33, 4};
        int[] secondArray = {2, 1,0, 4};
        int[] thirdArray ={1,3,2,4,2,1};
        System.out.println(findMissingNumber(firstArray, secondArray));
        System.out.println(getMissingNo(secondArray, secondArray.length)); 
        printRepeatatingArray(thirdArray);
        
        System.out.println("p12p".hashCode()% 16);
    }

    public static void printRepeatatingArray(int a[]) {
        for (int i = 0; i < a.length; i++) {
            if(a[Math.abs(a[i])] >0) {
                a[Math.abs(a[i])] = -a[Math.abs(a[i])];
            } else {
                System.out.println("First repeatating: "+Math.abs(a[i]));
                
            }
            
        }
    }
    
    public static int getMissingNo(int a[], int n) {
        int i, total;
        total = ((n ) * (n + 1)) / 2;
        for (i = 0; i < n; i++) {
            total -= a[i];
        }
        return total;
    }

    public static int findMissingNumber(int[] firstArray, int[] secondArray) {
        int val = 0;
        for (int i = 0; i < secondArray.length; i++) {
            val ^= firstArray[i] ^ secondArray[i];
        }
        return val;
    }

    public static boolean checkAnagramV3(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        } else {
            Integer val1 = 0 ;
            for (int i = 0; i < str1.length(); i++) {
                val1 ^= str1.charAt(i) ^ str2.charAt(i) ; 
            }
            return Objects.equals(val1, 0);
        }
    }
    
    public static boolean checkAnagramV2(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        } else {
            Integer val1 = 0, val2 = 0;
            for (int i = 0; i < str1.length(); i++) {
                val1 = (str1.charAt(i)) ^ val1;
                val2 = (str2.charAt(i)) ^ val2;
            }
            return Objects.equals(val1, val2);
        }
    }
}
