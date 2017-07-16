package com.pilab.xyz.cpu;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    private final CustomizedDLL list = new CustomizedDLL();
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public void put(int key, int value) {
        if (list.search(key)) {
            list.removeFromlist(key);
            list.insertInList(key, value);
        } else {
            if (list.size() >= capacity) {
                list.removeFromlist(list.head.key);
            }
            list.insertInList(key, value);
        }
    }

    public int get(int key) {
        if (list.search(key)) {
            int value = list.getData(key);
            list.removeFromlist(key);
            list.insertInList(key, value);
            return value;
        } else {
            System.out.println("Key not found.");
        }
        return -1;
    }

    public void printCache() {
        list.printReverse();
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        LRUCache ob = new LRUCache(3);
        ob.put(7, 9);
        ob.put(0, -6);
        System.out.println("Searching for key '9'? " + ob.get(9));
        ob.put(1, 1);
        ob.put(2, 2);
        ob.put(0, 0);
        ob.put(3, 3);
        ob.put(0, 0);
        ob.put(4, 4);
        ob.put(2, 2);
        ob.put(3, 3);
        ob.put(0, 0);
        ob.put(3, 3);
        ob.put(2, 2);
        ob.put(1, 1);
        ob.put(2, 2);
        ob.printCache();

    }

    // 7 0 1 2 0 3
}

class CustomizedDLL {

    DLLNode head = null, tail = null;

    Map<Integer, DLLNode> map = new HashMap<>();
    int count;

    public void printReverse() {
        DLLNode temp = tail;
        while (temp != null) {
            System.out.print(temp.key + " ");
            temp = temp.prev;
        }
        System.out.println();
    }

    public void insertInList(int key, int value) {
        insert(key, value);
        count++;
        map.put(key, tail);
    }

    public void removeFromlist(int key) {
        remove(map.get(key));
        map.remove(key);
        count--;
    }

    public boolean search(int key) {
        return map.containsKey(key);
    }

    public int getData(int key) {
        return map.get(key).value;
    }

    public int size() {
        return count;
    }

    private void insert(int key, int value) {
        DLLNode nn = new DLLNode(key, value);
        if (null == head) {
            head = nn;
            tail = nn;
        } else {
            tail.next = nn;
            nn.prev = tail;
            tail = tail.next;
        }
    }

    private void remove(DLLNode node) {
        if (node == head) {
            head = head.next;
            if (null != head) {
                head.prev = null;
            }
        } else if (node == tail) {
            tail = tail.prev;
            if (null != tail) {
                tail.next = null;
            }
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
    }
}

class DLLNode {

    int key;
    int value;
    DLLNode next;
    DLLNode prev;

    public DLLNode(int key, int value) {
        this.key = key;
        this.value = value;
        this.next = null;
        this.prev = null;
    }

}
