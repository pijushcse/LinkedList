package com.pilab.xyz.heap;

public class BinaryHeap {

    public static void main(String[] args) {
        int[] A = {16,14,10,8,7,9,3,2,1,4};
        HeapNode heap = new HeapNode(A.length);
        buildHeap(heap, A);
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
        display(heap);
        for (int i = (A.length - 1) / 2; i >= 0; i--) {
            percolateDown(heap, i);
        }
        display(heap);
    }

    private static void percolateDown(HeapNode heap, int i) {
        int l, r, max, temp;
        l = leftChildIndex(heap, i);
        r = rightChildIndex(heap, i);
        if (l != -1 && heap.arr[l] > heap.arr[i]) {
            max = l;
        } else {
            max = i;
        }

        if (r != -1 && heap.arr[r] > heap.arr[i]) {
            max = r;
        }
        if (max != i) {
            heap.arr[i] ^= heap.arr[max];
            heap.arr[max] ^= heap.arr[i];
            heap.arr[i] ^= heap.arr[max];
            percolateDown(heap, max);
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
