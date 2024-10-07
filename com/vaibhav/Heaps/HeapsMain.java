package com.vaibhav.Heaps;
import java.util.*;
public class HeapsMain {
    public static void main(String[] args) throws Exception{
        Heap<Integer> heap = new Heap<>();
        heap.insert(10);
        heap.insert(2);
        heap.insert(55);
        heap.insert(5);
        heap.insert(45);
        heap.insert(15);

        ArrayList<Integer> list = heap.heapSort();
        System.out.println(list);
    }
}
