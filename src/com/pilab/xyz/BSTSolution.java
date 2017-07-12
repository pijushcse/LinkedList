package com.pilab.xyz;

import com.pilab.xyz.Tree.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BSTSolution {
    public static void main(String[] args) {
        int[] arr = {5,7,9,11,15,17,18,22,25,28,30,50};
        TreeNode root = sortedArrayToBST(arr, 0, arr.length-1);
        print(root);
    }
    
    public static Integer FindMax(TreeNode root) {
        
        if(root==null) {
            return null;
        } 
        
        if(root.right !=null) {
            return FindMax(root.right); 
        }        
        else 
            return root.val;
    }
    
    public static void print(TreeNode root) {          
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> temp = new ArrayList<>();
        q.add(root);
        q.add(null);
        
        int level = 0;        
        while(!q.isEmpty()) {
            TreeNode t = q.poll();
            if(t == null) {
                System.out.println("Level {"+level+"}: ");
                temp.forEach(e-> {System.out.print(e+", ");} );
                level ++;
                temp.clear();
                System.out.println("");
                if(!q.isEmpty()) {
                    q.add(null);
                }
            } else {
                temp.add(t.val);
                if(t.left !=null) {
                    q.add(t.left);
                }
                if(t.right !=null) {
                    q.add(t.right);
                }
            }
        }        
    }

    public static TreeNode sortedArrayToBST(int[] arr, int low, int high) {
        if(low> high) {
            return null;
        }        
        int mid = (low+high) /2;
        TreeNode root = new TreeNode(arr[mid]);
        root.left = sortedArrayToBST(arr, low, mid-1);
        root.right = sortedArrayToBST(arr, mid+1, high);
        return root;
    }
}
