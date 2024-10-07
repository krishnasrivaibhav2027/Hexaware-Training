package com.vaibhav.Trees.BinaryTrees;
import java.util.*;
public class BinaryTree {
    public BinaryTree(){
    }
    private static class Node{
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }
    private Node root;
    public void populate(Scanner sc){
        System.out.println("Enter the root node: ");
        int val = sc.nextInt();
        root = new Node(val);
        populate(sc,root);
    }
    private void populate(Scanner sc, Node node){
        System.out.println("Do you want to enter the left of "+node.val);
        boolean left = sc.nextBoolean();
        if(left){
            System.out.println("Enter the value of the left of "+node.val);
            int val = sc.nextInt();
            node.left = new Node(val);
            populate(sc,node.left);
        }
        System.out.println("Do you want to enter the right of "+node.val);
        boolean right = sc.nextBoolean();
        if(right){
            System.out.println("Enter the value of the right of "+node.val);
            int val = sc.nextInt();
            node.right = new Node(val);
            populate(sc,node.right);
        }
    }
    public void display(){
        display(this.root,0);
    }
    private void display(Node node, int level){
        if(node==null) return;
        display(node.right,level+1);
        if(level!=0){
            for(int i=0;i<level-1;i++){
                System.out.print("|\t\t");
            }
            System.out.print("|------->" + node.val);
        }else{
            System.out.println(node.val);
        }
        display(node.left,level+1);
    }
}
