package com.pilab.xyz;

public class PrintCircularLinkedList {

    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(5);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(7);
        head.next.next.next.next = new ListNode(8);
        head.next.next.next.next.next = new ListNode(9);
        head.next.next.next.next.next.next = new ListNode(10);
        head.next.next.next.next.next.next.next = new ListNode(11);
        head.next.next.next.next.next.next.next.next = head;

        ListNode main = new ListNode(1);
        main.next = new ListNode(2);
        main.next.next = new ListNode(3);
        main.next.next.next = head;

        print(main);
    }

    public static ListNode removeLoop(ListNode head) {
        ListNode loopNode = findLoopNode(head);
        int c = 0;
        ListNode node = head;
        while (node != null) {
            if (node == loopNode) {
                c++;
            }
            if (node.next == loopNode && c > 1) {
                node.next = null;
            } else {
                node = node.next;
            }
        }
        return head;
    }

    public static ListNode findLoopNode(ListNode node) {
        ListNode slow = node, fast = node;
        boolean loopExists = false;
        while (fast != null && fast.next != null && slow != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                loopExists = true;
                break;
            }
        }
        if (loopExists) {
            slow = node;
            while (slow != fast) {
                fast = fast.next;
                slow = slow.next;
            }
        }
        return slow;
    }

    public static boolean isLoopExists(ListNode node) {
        ListNode slow = node, fast = node;
        boolean loopExists = false;
        while (fast != null && fast.next != null && slow != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                loopExists = true;
                break;
            }
        }
        return loopExists;
    }

    public static void print(ListNode head1) {
        ListNode head = null;
        if (isLoopExists(head1)) {
            head = removeLoop(head1);
        } else {
            head = head1;
        }
        System.out.print("Printing>_ ");
        while (head != null) {
            int eData = head.data;
            head = head.next;
            if (head != null) {
                System.out.print(eData + ", ");
            } else {
                System.out.println(eData);
            }
        }
    }
}
