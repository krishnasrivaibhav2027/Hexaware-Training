package com.vaibhav.LinkedLists;

public class CustomLL {
    private Node head;
    private Node tail;
    private int size;

    public CustomLL() {
        this.size = 0;
    }
    private static class Node{
        private int val;
        private Node next;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    public void insertFirst(int val){
        Node node = new Node(val);
        node.next = head;
        head = node;
        if(tail==null){
            tail = head;
        }
        size++;
    }

    public void insertLast(int val){
        if(tail==null){
            insertFirst(val);
            return;
        }
        Node node = new Node(val);
        tail.next = node;
        tail = node;
        size++;
    }

    public void insert(int val,int index){
        if(index == 0){
            insertFirst(val);
            return;
        }
        if(index == size){
            insertLast(val);
            return;
        }
        Node temp = head;
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }
        temp.next = new Node(val, temp.next);
        size++;
    }
    public void insertRec(int val,int index){
        head = insertRec(val,index,head);
    }
    private Node insertRec(int val, int index, Node node){
        if(index==0){
            Node temp = new Node(val,node);
            size++;
            return temp;
        }
        node.next = insertRec(val,index-1,node.next);
        return node;
    }

    public void display(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.val + "--> ");
            temp = temp.next;
        }
        System.out.println("End");
    }

    public int deleteFirst(){
        int val = head.val;
        head = head.next;
        if(head == null){
            tail = null;
        }
        size--;
        return val;
    }

    public int deleteLast(){
        if(size<=1){
            return deleteFirst();
        }
        int index = size-2;
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        int val = tail.val;
        tail = node;
        tail.next = null;
        return val;
    }

    public int delete(int val, int index){
        if(index==0){
            return deleteFirst();
        }
        if(index==size-1){
            return deleteLast();
        }
        Node node = head;
        for (int i = 0; i < index-1; i++) {
            node = node.next;
        }
        int val1 = node.next.val;
        node.next = node.next.next;
        return val1;
    }

     public Node find(int val){
        Node node = head;
        while(node!=null){
            if(node.val==val){
                return node;
            }
            node = node.next;
        }
        return null;
    }



}
