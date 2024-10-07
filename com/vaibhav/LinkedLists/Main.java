package com.vaibhav.LinkedLists;

public class Main {
    public static void main(String[] args) {

        CustomLL list = new CustomLL();
        System.out.println("-----------Singly Linked list-----------");
        System.out.println();
        list.insertFirst(2);
        list.insertLast(3);
        list.insertLast(5);
        list.insertLast(7);
        list.insertLast(11);
        list.display();
        list.insertRec(9,4);
        list.display();

//        list.display();
//        list.insert(9,4);
//        list.display();
//        System.out.println(list.deleteFirst());
//        list.display();
//        System.out.println(list.deleteLast());
//        list.display();
//        System.out.println(list.delete(7,2));
//        list.display();
//        System.out.println(list.find(5));
//        System.out.println();
//
//        CustomDL list1 = new CustomDL();
//        System.out.println("------------Doubly Linked lists-------------");
//        System.out.println();
//        list1.insertFirst(2);
//        list1.insertLast(3);
//        list1.insertLast(5);
//        list1.insertLast(7);
//        list1.insertLast(11);
//        list1.display();
//        list1.insert(9,4);
//        list1.display();
//
//        System.out.println("----------Circular Doubly Linked lists------------");
//        CustomCL list2  = new CustomCL();
//        list2.insert(2,true);
//        list2.insert(3,false);
//        list2.insert(5,false);
//        list2.insert(7,false);
//        list2.insert(11,false);
//        list2.display();
//
//        list2.add(9,4);
//
//        list2.display();
//
//        list2.deleteFirst();
//        list2.display();
//
//        list2.deleteLast();
//        list2.display();
//
//        list2.delete(5);
//        list2.display();
    }
}
