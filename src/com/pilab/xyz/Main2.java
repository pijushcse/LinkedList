package com.pilab.xyz;


   public class Main2 {
        public static void main(String[] args) {
        
            Main2 m = new Main2();
            
            ListNode n = new ListNode(22);
            System.out.println(n.data);
            m.mm(n);
            System.out.println(n.data);
       }
        
        public void mm (ListNode n) {
            n= new ListNode(111);
        }
        
        
}
