package com.vaibhav.LinkedLists;

public class CustomDL {
    private Node head;
    private Node tail;
    private int size;

    public CustomDL() {
        this.size = 0;
    }

    private static class Node{
        private int val;
        private Node next;
        private Node prev;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node next, Node prev) {
            this.val = val;
            this.next = next;
            this.prev = prev;
        }
    }

    public void insertFirst(int val){
        Node node = new Node(val);
        node.next = head;
        node.prev = null;
        if(head!=null){
            head.prev = node;
        }
        head = node;
        size++;
    }

    public void insertLast(int val){
        Node node = new Node(val);
        tail = head;
        node.next = null;

        if(head == null){
            node.prev = null;
            head = node;
            return;
        }

        while(tail.next!=null){
            tail = tail.next;
        }
        tail.next = node;
        node.prev = tail;
        size++;
    }

    public void insert(int val, int index){

        Node before = get(index-1);
        if (before == null){
            System.out.println("doesnt exist");
            return;
        }
        Node node = new Node(val);
        node.next = before.next;
        before.next = node;
        node.prev = before;
        if(node.next!=null) {
            node.next.prev = node;
        }
        size++;
    }

    public Node find(int val){
        Node node = head;
        while(node!=null){
            if(node.val == val){
                return node;
            }
            node = node.next;
        }
        return null;
    }

    public Node get(int index){
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }
    public void display(){
        Node node = head;
        tail = null;
        while(node!=null){
            System.out.print(node.val+" --> ");
            tail = node;
            node = node.next;
        }
        System.out.println("End");
        System.out.println("Reverse Doubly Linked list");
        while(tail!=null){
            System.out.print(tail.val + " --> ");
            tail = tail.prev;
        }
        System.out.println("Start");
    }
}
