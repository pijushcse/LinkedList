package com.pilab.xyz;

public class SubsetSum {
    public static void main(String[] args) {
        int[] a = {2,3,7,8,10};
        subsetSum(a, 10); 
    }
    
    public static void subsetSum(int[] a, int T) {
        boolean[][] M = new boolean[a.length][T+1];

        for (int i = 0; i < M.length; i++) {
            M[i][0] = true;
        }
        
        for (int i = 0; i < a.length; i++) {
            for (int j = 1; j <= T; j++) {
                if(i==0) {
                    M[i][j] = a[i] == j;
                } else  {
                    if( j >= a[i] ) {
                        M[i][j] = M[i-1][j] || M[i-1][j-a[i]];
                    } else {
                        M[i][j] = M[i-1][j];
                    }
                }
            }            
        }
        
        int j = T;
        if (M[a.length - 1][T] == true) {
            for (int i = a.length - 1; i >= 0; i--) {
                for (;j > 0; j--) {
                    if (M[i][j] == true && M[i - 1][j] == true) {
                        break;
                        
                    } else if (M[i][j] == true && M[i - 1][j] == false) {
                        System.out.print(a[i] + ", ");
                        j = j-8;
                        break;
                    }
                }
            }
        }
        
    }
}
