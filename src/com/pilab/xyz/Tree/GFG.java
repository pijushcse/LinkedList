package com.pilab.xyz.Tree;

import java.util.Scanner;

class GFG {

    public static void main(String[] args) {                
        
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for (int i = 0; i < test; i++) {
            int input = sc.nextInt();
            int t = input & (input>>1);
            if (t != 0) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
