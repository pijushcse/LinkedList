package com.pilab.xyz;

/**
 *
 * @author pijus
 */
public class SubsetSumRevisited {

    public static void main(String[] args) {
        int[] arr = {2, 3, 7, 8, 10};
        subSetSum(arr, 10);
    }

    public static void subSetSum(int[] a, int sum) {
        boolean[][] table = new boolean[a.length][sum + 1];
        for (int i = 0; i < table.length; i++) {
            table[i][0] = true;
        }
        for (int i = 1; i < table[0].length; i++) {
            table[0][i] = (a[0] == i);
        }

        for (int i = 1; i < table.length; i++) {
            for (int j = 1; j < table[0].length; j++) {
                if (a[i] > j) {
                    table[i][j] = table[i - 1][j];
                } else {
                    table[i][j] = table[i-1][j] || table[i - 1][j - a[i]];
                }
            }
        }
        int j = sum;
        for (int i = table.length -1 ; i >=0; i--) {
            for (;j >0; j--) {
                if( table[i][j] == true && table[i-1][j] == true) {
                    break;
                }
                else if( table[i][j] == true && table[i-1][j-a[i]] == true) {
                    System.out.print(a[i]+", ");
                    j = j - a[i];
                    break;
                }
            }
         }
    }
}
