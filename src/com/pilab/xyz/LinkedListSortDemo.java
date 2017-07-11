package com.pilab.xyz;

public class LinkedListSortDemo {

    public static void main(String[] args) {

        ListNode head = new ListNode(20);
        head.next = new ListNode(14);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(87);
        head.next.next.next.next = new ListNode(37);
        head.next.next.next.next.next = new ListNode(8);
        head.next.next.next.next.next.next = new ListNode(26);

        ListNode sorted = sort(head);
        sorted.print();

//        ListNode head1 = new ListNode(2);
//        head1.next = new ListNode(4);
//        head1.next.next = new ListNode(12);
//        
//        ListNode head2 = new ListNode(3);
//        head2.next = new ListNode(6);
//        head2.next.next = new ListNode(16);
//        head2.next.next = new ListNode(26);
//        System.out.println(findMiddle(head2).data);

//        
//        ListNode merged = mergeSortedRecursive(head1, head2);
//        merged.print();
    }

    public static ListNode mergeSortedRecursive(ListNode a, ListNode b) {
        ListNode sorted = null;
        if (a == null) {
            return b;
        }

        if (b == null) {
            return a;
        }

        if (a.data <= b.data) {
            sorted = a;
            sorted.next = mergeSortedRecursive(a.next, b);
        } else {
            sorted = b;
            sorted.next = mergeSortedRecursive(a, b.next);
        }
        return sorted;
    }

    public static ListNode mergeSorted(ListNode a, ListNode b) {

        ListNode sortedNode = new ListNode(0);
        ListNode p = sortedNode;
        while (a != null && b != null) {
            if (a.data < b.data) {
                p.next = a;
                a = a.next;
            } else {
                p.next = b;
                b = b.next;
            }
            p = p.next;
        }

        if (a != null) {
            p.next = a;
        }

        if (b != null) {
            p.next = b;
        }
        return sortedNode.next;
    }

    public static ListNode findMiddle(ListNode node) {
        if (node == null) {
            return node;
        }
        ListNode s = node, f = node.next;
        while (f != null) {
            f = f.next;
            if (f != null) {
                s = s.next;
                f = f.next;
            }
        }
        return s;
    }

    public static ListNode sort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode middle = findMiddle(head);
        ListNode middleNext = null;
        if (middle != null) {
            middleNext = middle.next;
            middle.next = null;
        }

        ListNode left = sort(head);
        ListNode right = sort(middleNext);

        return mergeSortedRecursive(left, right);
    }
}
