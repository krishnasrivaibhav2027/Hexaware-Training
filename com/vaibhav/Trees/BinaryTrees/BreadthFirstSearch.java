package com.vaibhav.Trees.BinaryTrees;
import java.util.*;
public class BreadthFirstSearch {
    public BreadthFirstSearch() {
    }

    public class Node{
        private int val;
        private int height;
        private Node left;
        private Node right;

        public Node(int val) {
            this.val = val;
        }
    }
    private Node root;
    public void populate(int[] arr) {
        for(int j:arr){
            this.insert(j);
        }
    }
    private void insert(int val){
        root = insert(val,root);
    }
    private Node insert(int val,Node node){
        if(node==null){
            return new Node(val);
        }
        if(val< node.val){
            node.left = insert(val,node.left);
        }
        if(val>node.val){
            node.right = insert(val,node.right);
        }
        node.height = Math.max(height(node.left),height(node.right))+1;
        return node;
    }
    public int height(Node node){
        if(node==null){
            return -1;
        }
        return node.height;
    }
    public boolean isEmpty() {
        return root == null;
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
    public void displayBFS(){
        if(root == null){
            System.out.println("Tree is empty");
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node curr = queue.poll();
            System.out.print(curr.val+"-->");
            if(curr.left!=null){
                queue.add(curr.left);
            }
            if(curr.right!=null){
                queue.add(curr.right);
            }
        }
        System.out.println();
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
