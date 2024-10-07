package com.vaibhav.LinkedLists;

public class CustomCL {
    private Node head;
    private Node tail;
    private int size;

    public CustomCL() {
        this.size = 0;
    }

    private static class Node {
        private Node next;
        private Node prev;
        private int val;

        public Node(int val) {
            this.val = val;
        }

        public Node(Node next, Node prev, int val) {
            this.next = next;
            this.prev = prev;
            this.val = val;
        }
    }

    public void insert(int val, boolean insertAtFirst) {
        Node node = new Node(val);

        if (head == null) {
            head = tail = node;
            node.next = node.prev = node;
        } else {
            node.next = head;
            node.prev = tail;
            head.prev = tail.next = node;

            if (insertAtFirst) {
                head = node;
            } else {
                tail = node;
            }
        }
        size++;
    }

    public void add(int val, int index){
        if(index<0 || index>size){
            throw new IndexOutOfBoundsException("Invalid index");
        }
        if(index==0){
            insert(val,true);
            return;
        }
        if(index==size){
            insert(val,false);
            return;
        }
        Node before = get(index-1);
        Node node = new Node(val);
        node.next = before.next;
        node.next.prev = node;
        node.prev = before;
        before.next = node;
        size++;
    }

    public Node get(int index){
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    public void deleteFirst(){
        if(head==null) {
            System.out.println("No items to delete");
        }
        if(head == tail) head = tail = null;
        int val = head.val;
        tail.next = head.next;
        head=head.next;
        head.prev = tail;
        size--;
        System.out.println(val+" is deleted");
    }

    public void deleteLast(){
        if(head==null) {
            System.out.println("No items to delete");
        }
        if(head == tail) head = tail = null;
        int val = tail.val;
        tail = tail.prev;
        tail.next = head;
        head.prev = tail;
        size--;
        System.out.println(val+" is deleted");
    }

    public Node find(int val){
        Node node = head;
        while(node!=null){
            if(node.val==val) return node;
            node = node.next;
        }
        return null;
    }
    public void delete(int val){
        Node node = find(val);
        if(node==head){
            deleteFirst();
            return;
        }
        if(node==tail){
            deleteLast();
            return;
        }

        if(node==null){
            System.out.println("no items to delete!");
            return;
        }

        node.prev.next= node.next;
        node.next.prev = node.prev;
        size--;
        System.out.println(val+" deleted");
    }

    public void display() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node current = head;

        do {
            System.out.print(current.val);

            if (current.next != head) {
                System.out.print(" --> ");
            }

            current = current.next;
        } while (current != head);

        System.out.println(" --> " + head.val);
        System.out.println();
    }


}

