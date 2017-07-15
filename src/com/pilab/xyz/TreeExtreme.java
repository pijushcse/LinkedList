package com.pilab.xyz;

import java.util.Random;

public class TreeExtreme {

    Node root;
    int nodeCounter = 0;

    public static void main(String[] args) {
        TreeExtreme h = new TreeExtreme();
        Random r = new Random();
        for (int i = 0; i <= 7; i++) {
            int n = r.nextInt(500);
            h.addEndRecursive(n);
        }
        h.displayFromFirst();
        //h.reverse2();
        //h.pairWiseSwap2();
         //h.findMiddle();
         h.findNthNodeFromEnd(3);

         
    }
    

    private void pairWiseSwap2() {        
        pairWiseSwap(root);
    }

    void pairWiseSwap(Node node) {
        if (node != null && node.next != null) {
            swap(node);
            pairWiseSwap(node.next.next);
        }
    }

    void pairWiseSwap() {
        Node temp = root;
        while (temp != null && temp.next != null) {
            swap(temp);
            temp = temp.next.next;
        }
    }

    private void swap(Node temp) {
        //int k = temp.data;
        temp.data ^= temp.next.data;
        temp.next.data ^= temp.data;
        temp.data ^= temp.next.data;
    }

    public void findNthNodeFromEnd(int n) {
        Node ptemp = root;
        Node nthNode = root;
        int count = 0;
        while (ptemp != null) {
            count++;
            if (count > n) {
                nthNode = nthNode.next;
            }
            ptemp = ptemp.next;
        }

        if (count >= n) {
            System.out.println("Nth node: " + nthNode.data);
        }
    }
    public void findMiddle() {
        Node s, f;
        s = f = root;

        while (f != null && f.next != null) {
            s = s.next;
            f = f.next.next;
        }
        System.out.println("Middle node is: " + s.data);
    }

    public void reverse2() {
        Node previous = null;
        Node current = root;

        while (current != null) {
            Node next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        root = previous;
    }

    public void reverse() {
        if (root == null) {
            return;
        }
        if (root.next == null) {
            return;
        }

        Node newRoot = null;
        while (root != null) {
            if (newRoot == null) {
                newRoot = root;
                root = root.next;
                newRoot.next = null;
            } else {
                Node n = root;
                root = root.next;
                n.next = newRoot;
                newRoot = n;
            }
        }
        root = newRoot;
    }

    private void addEnd(int data) {
        Node newNode = new Node(data);
        if (root == null) {
            root = newNode;
            return;
        } else if (root.next == null) {
            root.next = newNode;
            return;
        }
        Node n = root;
        while (n.next != null) {
            n = n.next;
        }
        n.next = newNode;
    }

    private void addEndRecursive(int data) {
        if (root == null) {
            root = new Node(data);
            nodeCounter++;
        } else {
            addEndRecursive(root, data);
        }
    }

    private void addEndRecursive(Node node, int data) {
        if (node.next == null) {
            node.next = new Node(data);
        } else {
            addEndRecursive(node.next, data);
        }
    }

    private void addFirst(int data) {
        Node newNode = new Node(data);
        if (root == null) {
            root = newNode;
        } else {
            newNode.next = root;
            root = newNode;
        }
    }

    private void displayRecursive() {
        if (root == null) {
            return;
        } else {
            displayRecursive(root);
        }
        System.out.println("");
    }

    private void displayRecursive(Node node) {
        if (node == null) {
        } else {
            displayRecursive(node.next);
            System.out.print(" " + node.data);
        }
    }

    private void displayFromFirst() {
        if (root == null) {
            return;
        }
        System.out.println("printing..");

        Node n = root;
        while (n != null) {
            System.out.println(n.data);
            n = n.next;
        }
    }
}

class Node {

    public int data;
    public Node next;

    public Node() {
    }

    public Node(int data) {
        this.data = data;
    }

}
