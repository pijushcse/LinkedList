 
package com.pilab.xyz;

 
public class ListNode {
   public int data;
   public ListNode next;

    public ListNode(int data) {
        this.data = data;
    }
    
    public void print() {
        System.out.print("Printing>_ ");
        ListNode head = this;
        while(head !=null) {
            int eData = head.data;
            head = head.next;
            if(head !=null) {
                System.out.print(eData+", ");
            } else {
                System.out.print(eData);
            }
        }
        System.out.println();
    }    
}
