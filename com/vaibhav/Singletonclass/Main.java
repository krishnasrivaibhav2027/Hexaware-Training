package com.vaibhav.Singletonclass;

public class Main {
    public static void main(String[] args) {
        Singleton obj1 = new Singleton();
        Singleton obj2 = new Singleton();
        Singleton obj3 = new Singleton();
        obj1.getInstance();
        obj2.getInstance();
        obj3.getInstance();
    }
}
