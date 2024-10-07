package com.vaibhav.CompareObjects;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student(11, 85.7f);
        Student s2 = new Student(21, 99.5f);
        Student[] list = {s1,s2};
        if(s1.compareTo(s2)<0){
            System.out.println("s2 got more marks");
        }
        Arrays.sort(list);
        System.out.println(Arrays.toString(list));
        Arrays.sort(list, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return -(int)(o1.marks-o2.marks);
            }
        });
        System.out.println(Arrays.toString(list));
        // Using Lambda functions
        Arrays.sort(list,(o1,o2) -> (int)(o1.marks-o2.marks));
        System.out.println(Arrays.toString(list));
    }
}
