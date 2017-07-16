package com.pilab.xyz.heap;

import java.util.Arrays;
import java.util.stream.Stream;

public class BinaryHeap {

    public static void main(String[] args) {
//        int[] A = {2,3,4,5,6,7,8,9,19,20,21};
//        HeapNode heap = new HeapNode(A.length);
//        buildHeap(heap, A);
        
        int[] t = {12, 11, 13, 5, 6, 7};
        HeapNode heap1 = new HeapNode(t.length);
       // buildHeap(heap1, t);
        heapSort(heap1, t);
    }

    public static void heapSort(int[] T) {
        for (int i = T.length/2-1; i >=0; i--) {
            percolateDown(T,T.length, i);
        }
        for (int i = 0; i < T.length; i++) {
            int j = T[i];
            System.out.print(j+" ");
        }
        
        for (int i =  T.length-1; i>=0;  i--) {
            int t = T[0];
            T[0] = T[i];
            T[i] = t;
            percolateDown(T, i, 0);
        }
        System.out.println("");
        for (int i = 0; i < T.length; i++) {
            int j = T[i];
            System.out.print(j+" ");
        }
 
    }
    
    private static void heapSort(HeapNode heap, int[] T) {
        buildHeap(heap, T);
        int oldSize= heap.count;
         for (int i = T.length-1; i> 0 ; i--) {
            int t = heap.arr[0];
            heap.arr[0] = heap.arr[heap.count -1];
            heap.arr[0] = t;
            heap.count -- ;
            percolateDown(heap, i-1);
        }
        heap.count = oldSize;
        display(heap);
    }
    
    private static void display(HeapNode heap) {
        for (int i = 0; i < heap.arr.length; i++) {
            int j = heap.arr[i];
            System.out.print(j + ", ");
        }
        System.out.println();
    }

    private static void buildHeap(HeapNode heap, int[] A) {
        for (int i = 0; i < A.length; i++) {
            heap.arr[i] = A[i];
        }
        heap.count = A.length;
        for (int i = (heap.count) / 2 -1; i >= 0; i--) {
            percolateDown(heap, i);
        }
        display(heap);
    }

     private static void percolateDown(int[] A, int n, int i) {
        int l, r, max=i;
        l = 2*i +1;
        r = 2*i + 1;
        if (l <n && A[l] > A[i]) {
            max = l;
        } 
        
        if (r<n && A[r] > A[i]) {
            max = r;
        }
        if (max != i) {
           int temp = A[i];
            A[i] = A[max];
            A[max] = temp;
            percolateDown(A,n, max);
        }
    }

    
    private static void percolateDown(HeapNode heap, int i) {
        int l, r, largest=i;
        l = leftChildIndex(heap, i);
        r = rightChildIndex(heap, i);
        if (l != -1 && heap.arr[l] > heap.arr[largest]) {
            largest = l;
        } 
        
        if (r != -1 && heap.arr[r] > heap.arr[largest]) {
            largest = r;
        }
        if (largest != i) {
           int temp = heap.arr[i];
            heap.arr[i] = heap.arr[largest];
            heap.arr[largest] = temp;
            percolateDown(heap, largest);
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
