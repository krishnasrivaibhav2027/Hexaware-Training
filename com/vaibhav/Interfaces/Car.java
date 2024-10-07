package com.vaibhav.Interfaces;

public class Car extends CarTemplate implements Brand,FuelCapacity{
    String brand_name;
    int num;
    public void printColor() {
        System.out.println("The car color is " + COLOR);
    }
    public Car(String brand_name, int num) {
        this.brand_name = brand_name;
        this.num=num;
    }

    @Override
    public void brand() {
        System.out.println("The car brand is "+this.brand_name);
    }

    @Override
    public void capacity() {
        System.out.println("The car fuel capacity is "+this.num);
    }

}
