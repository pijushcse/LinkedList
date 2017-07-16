package com.pilab.xyz.Tree;

public class TrieDemo {

    public static void main(String[] args) {
        TrieNode root = new TrieNode();
        insert(root, "cat");
        insert(root, "catter");
        insert(root, "cold");
        System.out.println("");
        System.out.println(searchWord(root, "catter"));
    }
    
    public static boolean searchWord(TrieNode root, String word) {
        TrieNode t = root;
        for (int i = 0; i < word.length(); i++) {        
            char c = word.charAt(i);
            int index = c -'a';
            if(t.children[index] !=null) {
                t = t.children[index];
            } else {
                return false;
            }
        }        
        return t.isLeaf;
    }
    
    public static void display(TrieNode root) {
        if(root !=null){
            TrieNode[] childrens = root.children;
            System.out.print(root.data+" ");
            for (TrieNode children : childrens) {
                display(children);
            }
            System.out.println();
        }
    }

    private static void insert(TrieNode root, String word) {
        TrieNode temp = root;
        int lastCharIndex = word.length() - 1;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'a';
            if (temp.children[index] == null) {
                temp.children[index] = new TrieNode(c);
                temp = temp.children[index];
            } else {
                temp = temp.children[index];
            }
            if (i == lastCharIndex) {
                temp.isLeaf = true;
            }
        }
    }
}

class TrieNode {

    public char data;
    public TrieNode[] children = new TrieNode[26];
    public boolean isLeaf;

    public TrieNode(char data) {
        this.data = data;
    }

    public TrieNode() {
    }
}
