package com.vaibhav.Trees.BinaryTrees;

import java.util.*;

public class AVLTrees {

    public class Node{
        private int val;
        private int height;
        private Node left;
        private Node right;
        public Node(int val) {
            this.val = val;
        }
        public int getVal() {
            return val;
        }
    }
    public Node root;

    public AVLTrees() {

    }
    public int height(Node node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }
    public boolean isEmpty() {
        return root == null;
    }
    public void insert(int val){
        root = insert(val, root);
    }
    private Node insert(int val, Node node){
        if(node == null){
            return new Node(val);
        }
        if(val<node.val){
            node.left = insert(val,node.left);
        }
        if(val>node.val){
            node.right = insert(val,node.right);
        }
        node.height = Math.max(height(node.left),height(node.right))+1;
        return rotate(node);
    }
    private Node rotate(Node node){
        if(height(node.left)-height(node.right)>1){
            //left-heavy
            if(height(node.left.left)-height(node.left.right)>0){
                //left left case
                return rotateRight(node);
            }
            if(height(node.left.left)-height(node.left.right)<0){
                //left right case
                node.left = rotateLeft(node.left);
                return rotateRight(node);
            }
        }
        if(height(node.left)-height(node.right)<-1){
            //right heavy
            if(height(node.right.left)-height(node.right.right)<0){
                //right right case
                return rotateLeft(node);
            }
            if(height(node.right.left)-height(node.right.right)>0){
                //right left case
                node.right = rotateRight(node.right);
                return rotateLeft(node);
            }
        }
        return node;
    }
    private Node rotateRight(Node p){
        Node c = p.left;
        Node t = c.right;

        c.right = p;
        p.left = t;
        p.height = Math.max(height(p.left),height(p.right))+1;
        c.height = Math.max(height(c.left),height(c.right))+1;
        return c;
    }
    private Node rotateLeft(Node c){
        Node p = c.right;
        Node t = p.left;
        p.left = c;
        c.right = t;

        c.height = Math.max(height(c.left),height(c.right))+1;
        p.height = Math.max(height(p.left),height(p.right))+1;
        return p;
    }
    public boolean balanced(){
        return balanced(root);
    }
    private boolean balanced(Node node){
        if(node == null) {return true;}
        return Math.abs(height(node.left)-height(node.right))<=1 && balanced(node.left) && balanced(node.right);
    }
    public void populate(int[] arr){
        for (int j : arr) {
            this.insert(j);
        }
    }
    public void populateSorted(int[] arr){
        populateSorted(arr,0,arr.length);
    }
    private void populateSorted(int[] arr, int start, int end){
        if(start>=end){return;}
        int mid = start+(end-start)/2;
        this.insert(arr[mid]);
        populateSorted(arr,start,mid);
        populateSorted(arr,mid+1,end);
    }
    public void display(){
        display(this.root,"Root node: ");
    }
    private void display(Node node, String details){
        if(node == null) {return;}
        System.out.println(details+node.val);
        display(node.left,"Left of "+node.val+": ");
        display(node.right,"Right of "+node.val+": ");
    }
}
