package com.pilab.xyz.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        TreeNode root = null;
        root = insert2(root, 10);
        root = insert2(root, 12);
        root = insert2(root, 13);
        root = insert2(root, 11);
        root = insert2(root, 8);
        root = insert2(root, 4);
        root = insert2(root, 6);

//      print(root) ; 
//      preOrderRecursive(root);
//      preOrderIterative(root);
//      inOrderRecursive(root);
//      inOrderIterative(root);
//      searchIterative(root, 13);
        root = insert2(root, 5);
        //reverseLevelOrderPrint(root);
        //System.out.println(FindLevelWithMaxSum(root));
        printLevelWise(root);
    }

    public static void printLevelWise(TreeNode root) {
        List<Integer> tempList = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        int level = 0;
        while (!q.isEmpty()) {
            TreeNode temp = q.poll();

            if (temp == null) {
                System.out.println("Level {" + level + "} data: ");
                tempList.forEach(e -> {
                    System.out.print(e + " ");
                });
                level = -~level;
                tempList.clear();
                
                if(!q.isEmpty()) {
                    q.add(null);
                }
                System.out.println("");
            } else {
                tempList.add(temp.val);
                if (temp.left != null) {
                    q.add(temp.left);
                }
                if (temp.right != null) {
                    q.add(temp.right);
                }
            }
        }
    }

    public static int FindLevelWithMaxSum(TreeNode root) {
        int level = 0, maxLevel = 0;
        int currentSum = 0, maxSum = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while (!q.isEmpty()) {
            TreeNode temp = q.poll();
            if (temp == null) {
                if (currentSum > maxSum) {
                    maxSum = currentSum;
                    maxLevel = level;
                }

                currentSum = 0;
                if (!q.isEmpty()) {
                    q.add(null);
                }
                level++;
            } else {
                currentSum += temp.val;
                if (temp.left != null) {
                    q.add(temp.left);
                }
                if (temp.right != null) {
                    q.add(temp.right);
                }
            }
        }
        return maxLevel;
    }

    public static void reverseLevelOrderPrint(TreeNode root) {
        Stack<TreeNode> s = new Stack<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            TreeNode p = q.poll();
            if (p.right != null) {
                q.add(p.right);
            }

            if (p.left != null) {
                q.add(p.left);
            }

            s.add(p);
        }

        while (!s.isEmpty()) {
            System.out.println(s.pop().val);
        }
    }

    public static TreeNode insert2(TreeNode root, int data) {
        TreeNode newNode = new TreeNode(data);
        if (root == null) {
            return newNode;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode t = q.poll();
            if (t.left != null) {
                q.add(t.left);
            } else {
                t.left = newNode;
                break;
            }

            if (t.right != null) {
                q.add(t.right);
            } else {
                t.right = newNode;
                break;
            }

        }
        return root;
    }

    public static int searchIterative(TreeNode root, int data) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode n = queue.poll();
            if (n.val == data) {
                return n.val;
            }

            if (n.val > data) {
                queue.add(n.left);
            } else {
                queue.add(n.right);
            }
        }
        return Integer.MIN_VALUE;
    }

    public static int searchRecursion(TreeNode root, int data) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        if (root.val == data) {
            return root.val;
        } else {
            if (data < root.val) {
                return searchRecursion(root.left, data);
            } else {
                return searchRecursion(root.right, data);
            }
        }
    }

    public static void inOrderIterative(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode top = stack.peek();
            if (top.left != null) {
                stack.push(top.left);
                top.left = null;
            } else {
                TreeNode pop = stack.pop();
                System.out.println(pop.val);
                if (top.right != null) {
                    stack.push(top.right);
                }
            }
        }
    }

    public static void inOrderRecursive(TreeNode root) {
        if (root != null) {
            inOrderRecursive(root.left);
            System.out.println(root.val);
            inOrderRecursive(root.right);
        }
    }

    public static void preOrderIterative(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            System.out.println(node.val);
            if (node.right != null) {
                stack.add(node.right);
            }

            if (node.left != null) {
                stack.add(node.left);
            }
        }
    }

    public static void preOrderRecursive(TreeNode root) {
        if (root != null) {
            System.out.println(root.val);
            preOrderRecursive(root.left);
            preOrderRecursive(root.right);
        }
    }

    public static void print(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode top = queue.poll();
            System.out.println(top.val);

            if (top.left != null) {
                queue.add(top.left);
            }

            if (top.right != null) {
                queue.add(top.right);
            }
        }

    }
    public static TreeNode insert(TreeNode root, int data) {
        if (root == null) {
            return new TreeNode(data);
        }
        if (data < root.val) {
            root.left = insert(root.left, data);
        } else {
            root.right = insert(root.right, data);
        }
        return root;
    }
}
