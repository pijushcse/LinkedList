package com.pilab.xyz.heap;

public class BinaryHeap {

    public static void main(String[] args) {
        HeapNode heap = new HeapNode(5);
 
    }

    public void buildHeap(HeapNode heap, int[] A) {
        for (int i = 0; i < A.length; i++) {
            heap.arr[i] = A[i] ;
        }
        heap.count = A.length;
        
        for (int i = (A.length-1)/2; i>=0; i--) {
            percolateDown(heap, i);
        }
    }
    
    public static void percolateDown(HeapNode heap, int i) {
        int l, r, max, temp;
        l = leftChildIndex(heap, i);
        r = rightChildIndex(heap, i);
        if(l!=-1 && heap.arr[l] > heap.arr[i]) {
            max =l;
        } else {
            max = i;
        }
        
        if(r!=-1 && heap.arr[r] > heap.arr[i]) {
            max =r;
        }
    }
    
    private static int getTop(HeapNode heap) {
        if (heap != null && heap.count > 0) {
            return heap.arr[0];
        }
        return -1;
    }

    private static int rightChildIndex(HeapNode heap, int childIndex) {
        int right = (2 * childIndex + 2);
        if (right >= heap.count) {
            return -1;
        }
        return right;
    }

    private static int leftChildIndex(HeapNode heap, int childIndex) {
        int left = (2 * childIndex + 1);
        if (left >= heap.count) {
            return -1;
        }
        return left;
    }

    public static int parentNodeIndex(HeapNode heap, int childIndex) {
        if (heap == null || childIndex <= 0 || childIndex >= heap.count) {
            return -1;
        }
        return (childIndex - 1) / 2;
    }
}

class HeapNode {

    public int[] arr;
    public int capacity;
    public int count;

    public HeapNode(int size) {
        this.capacity = size;
        arr = new int[size];
    }
}
