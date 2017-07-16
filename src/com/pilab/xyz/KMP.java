package com.pilab.xyz;

public class KMP {

    public static void main(String[] args) {
        String s = "DEEDLKDEEDFLY";
        String p = "DEED";
        System.out.println(kmp(s, p));
    }

    static int kmp(String s, String pattern) {
        char[] ss = s.toCharArray();
        char[] pp = pattern.toCharArray();
        int[] prefixTable = prefixTable(pattern);

        int i = 0, j = 0, m = pp.length;
        while (i < s.length()) {
            if (ss[i] == pp[j]) {
                if (j == m - 1) {
                    System.out.println(i - j);
                    j = 0;
                }
                i++;
                j++;
            } else if (j > 0) {
                j = prefixTable[j - 1];
            } else {
                i++;
            }
        }
        return 0;
    }

    static int[] prefixTable(String p) {
        char[] P = p.toCharArray();
        int[] F = new int[p.length()];
        int i = 1, j = 0;

        while (i < p.length()) {
            if (P[i] == P[j]) {
                F[i] = j + 1;
                i++;
                j++;
            } else if (j > 0) {
                j = F[j - 1];
            } else {
                F[i] = 0;
                i++;
            }
        }
        return F;
    }
}
