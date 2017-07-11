/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pilab.xyz;

public class FindDuplicates {

    void printRepeating(int arr[], int size) {
        int i;
        System.out.println("The repeating elements are : ");

        for (i = 0; i < size; i++) {
            if (arr[Math.abs(arr[i])] >= 0) {
                arr[Math.abs(arr[i])] = -arr[Math.abs(arr[i])];
            } else {
                System.out.print(Math.abs(arr[i]) + " ");
            }
        }
    }

    /* Driver program to test the above function */
    public static void main(String[] args) {
        
        System.out.println(4 & -4);
        
        
        int x =0;
        for (int i = 1; i <= 4; i++) {
            x^=i;
        }
        
        
        
        System.out.println("X is: "+x);
        x ^= (1^2^4);
        System.out.println("Missing x: "+x);
        
        FindDuplicates duplicate = new FindDuplicates();
        int arr[] = {4, 2, 4, 500, 2, 3, 1};
        int arr_size = arr.length;
        duplicate.printRepeating(arr, arr_size);
    }
}
 
// This code has been contributed by Mayank Jaiswal
