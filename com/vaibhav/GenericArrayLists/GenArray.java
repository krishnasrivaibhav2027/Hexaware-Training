package com.vaibhav.GenericArrayLists;

import java.util.Arrays;

public class GenArray<T> {
    private Object[] arr;
    private static int DEFAULT_SIZE = 10;

    private int size = 0;

    public GenArray(){
        arr = new Object[DEFAULT_SIZE];
    }

    public void add(T val){
        if(isFull()){
            resize();
        }
        arr[size++] = val;
    }

    public void resize(){
        Object[] temp = new Object[size*2];
        for (int i = 0; i < arr.length; i++) {
            temp[i] = arr[i];
        }
        arr = temp;
    }

    private boolean isFull(){
        return size == arr.length;
    }

    public T get(int index){
        return (T)arr[index];
    }

    public int size(){
        return arr.length;
    }

    public void set(int index, T value){
        arr[index] = value;
    }

    public T remove(){
       return (T)(arr[--size]);
    }

    @Override
    public String toString() {
        return "CustomGenericArrayList {"+
                "arr = " + Arrays.toString(arr) + ", size = "+size+"}";
    }

    public static void main(String[] args) {
        GenArray<Integer> list = new GenArray<>();
        for (int i = 0; i < 14; i++) {
            list.add(2*i);
        }
        System.out.println(list);
        System.out.println(list.get(5));

        GenArray<String> list1 = new GenArray<>();
        list1.add("Vaibhav");
        list1.add("Akshika");
        list1.add("Prahas");
        list1.add("Spandana");
        list1.add("Viswa");
        System.out.println(list1);
        System.out.println(list1.remove());
    }
}
