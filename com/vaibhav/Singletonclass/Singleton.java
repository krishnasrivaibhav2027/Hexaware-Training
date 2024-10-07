package com.vaibhav.Singletonclass;

public class Singleton {
    private static Singleton instance;

    public static Singleton getInstance(){
        if(instance==null){
            instance = new Singleton();
            System.out.println("New object is created");
        }
        System.out.println("Now new Object created is being referenced");
        return instance;
    }

}
