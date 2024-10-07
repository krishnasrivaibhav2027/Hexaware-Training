package com.vaibhav.Trees.BinaryTrees;

public class BinarySearchTree {
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

    public BinarySearchTree() {
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
        return node;
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
    public void preOrder(){
        preOrder(this.root);
    }
    private void preOrder(Node node){
        if(node == null){return;}
        System.out.print(node.val+"-->");
        preOrder(node.left);
        preOrder(node.right);
    }
    public void inOrder(){
        inOrder(this.root);
    }
    private void inOrder(Node node){
        if(node == null){return;}
        inOrder(node.left);
        System.out.print(node.val+"-->");
        inOrder(node.right);
    }
    public void postOrder(){
        postOrder(this.root);
    }
    private void postOrder(Node node){
        if(node==null){return;}
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.val+"-->");
    }
}
