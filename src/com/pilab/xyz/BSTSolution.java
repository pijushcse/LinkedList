package com.pilab.xyz;

import com.pilab.xyz.Tree.TreeNode;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class BSTSolution {

    public static void main(String[] args) {
        int[] arr = {5, 7, 9, 11, 15, 17, 18, 22, 25, 28, 30, 50, 60, 70, 80};
        TreeNode root = sortedArrayToBST(arr, 0, arr.length - 1);
        levelOrderPrint(root);
        VerticalSum(root);

//        System.out.println("Left Max: " + FindMax(root.left));

    }

    public static void inOrderTraversal(TreeNode root) {
//        System.out.println("In Order Recursive Traversal");
//        inOrderTraversalRecursive(root);
//        System.out.println("\nIn Order Iterative Traversal");
        inOrderTraversalIterative(root);
     }

    private static void inOrderTraversalIterative(TreeNode root) {
        Map<Integer, Integer> m = new HashMap();
        int[] hdArr = new int[12];
        
        Stack<TreeNode> s = new Stack<>();
        s.add(root);

        int hd = 0, i =0;
        m.put(hd, root.val);

        while (!s.isEmpty()) {
            TreeNode r = s.peek();
            if(r == root) {
                 hd = 0;
            }
            if (r.left != null) {
                hd--;
                hdArr[i++] = hd;
                if (m.containsKey(hd)) {
                    m.put(hd, m.get(hd) + r.left.val);
                } else {
                    m.put(hd, r.left.val);
                }
                s.add(r.left);
                r.left = null;
            } else {
                TreeNode t = s.pop();
                 if (t.right != null) {
                    s.add(t.right);
                    hd++;
                    if(i > 0)
                        hdArr[--i] = hd;
                    else 
                        hdArr[0] = hd;
                    if (m.containsKey(hd)) {
                        m.put(hd, m.get(hd) + t.right.val);
                    } else {
                        m.put(hd, t.right.val);
                    }
                } else {
                    hd = hdArr[i];
                }
            }

        }
        
        if (m != null) {
            System.out.println("Vertical Sum Iterative: ");
            System.out.println(m.entrySet());
            m.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(e -> {
                System.out.print(e.getValue() + ", ");
            });
            System.out.println("");
        }        
    }

    private static void inOrderTraversalRecursive(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrderTraversalRecursive(root.left);
        System.out.print(root.val + ", ");
        inOrderTraversalRecursive(root.right);
    }

    private static void VerticalSum(TreeNode root) {
        if (root == null) {
            return;
        }

        Map<Integer, Integer> hM = new HashMap<Integer, Integer>();
        verticalSum(root, 0, hM);

        if (hM != null) {
            System.out.println("Vertical Sum: ");
            hM.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(e -> {
                System.out.print(e.getValue() + ", ");
            });
            System.out.println("");
        }
    }

    private static void verticalSum(TreeNode root, int hD, Map<Integer, Integer> hM) {
        if (root == null) {
            return;
        }
        verticalSum(root.left, hD - 1, hM);
        if (hM.containsKey(hD)) {
            hM.put(hD, hM.get(hD) + root.val);
        } else {
            hM.put(hD, root.val);
        }
        verticalSum(root.right, hD + 1, hM);
    }

    public static Integer FindMax(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.right != null) {
            return FindMax(root.right);
        } else {
            return root.val;
        }
    }

    public static void levelOrderPrint(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> temp = new ArrayList<>();
        q.add(root);
        q.add(null);

        int level = 0;
        while (!q.isEmpty()) {
            TreeNode t = q.poll();
            if (t == null) {
                System.out.println("Level {" + level + "}: ");
                temp.forEach(e -> {
                    System.out.print(e + ", ");
                });
                level++;
                temp.clear();
                System.out.println("");
                if (!q.isEmpty()) {
                    q.add(null);
                }
            } else {
                temp.add(t.val);
                if (t.left != null) {
                    q.add(t.left);
                }
                if (t.right != null) {
                    q.add(t.right);
                }
            }
        }
    }

    public static TreeNode sortedArrayToBST(int[] arr, int low, int high) {
        if (low > high) {
            return null;
        }
        int mid = (low + high) / 2;
        TreeNode root = new TreeNode(arr[mid]);
        root.left = sortedArrayToBST(arr, low, mid - 1);
        root.right = sortedArrayToBST(arr, mid + 1, high);
        return root;
    }
}
