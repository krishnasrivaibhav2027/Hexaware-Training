package com.vaibhav.Interfaces;

public class Main {
    public static void main(String[] args) {
        Car car1 = new Car("toyota",100000);
        Car car2 = new Car("Audi",200000);
        Car car3 = new Car("Bentley",500000);
//        Car.color();
        car1.printColor();
        car1.brand();
        car1.capacity();
        car2.printColor();
        car2.brand();
        car2.capacity();
        car3.printColor();
        car3.brand();
        car3.capacity();
    }
}
