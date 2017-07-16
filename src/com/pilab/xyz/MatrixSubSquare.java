package com.pilab.xyz;

public class MatrixSubSquare {
    public static void main(String[] args) {
        int[][] arr = 
        {
            {0,1,1,0,1},
            {1,1,0,1,0},
            {0,1,1,1,0},
            {1,1,1,1,0},
            {1,1,1,1,1},
            {0,0,0,0,0}
        };
        
        matricSubSquare(arr);
    }
    
    public static void matricSubSquare(int[][] arr) {
        int[][] L = new int[arr.length][arr[0].length];
        
        for (int i = 0; i < arr.length; i++) {          
            L[i][0] = arr[i][0];            
        } 
        
        for (int i = 0; i < arr[0].length; i++) {
            L[0][i] = arr[0][i];            
        }
        
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr[0].length; j++) {
                if(arr[i][j]== 1) {
                    L[i][j] = 1+ Math.min(Math.min(L[i][j-1], L[i-1][j]), L[i-1][j-1]) ;
                } else {
                    L[i][j] =0;
                }
            }
        }
        
        int maxs = 0 , maxi =0, maxj=0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if(L[i][j] > maxs) {
                    maxs = L[i][j];
                    maxi = i;
                    maxj= j;
                }
            }            
        }
        for (int i = maxi; i > maxi-maxs; i--) {
            for (int j = maxj; j > maxj-maxs; j--) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println("");
        }
        
        
    }
}
