package com.vaibhav.Trees.BinaryTrees;

public class SegmentTrees {
    private static class Node{
        int data;
        int start;
        int end;
        Node left;
        Node right;

        public Node(int start, int end){
            this.start = start;
            this.end = end;
        }
    }
    private Node root;
    public SegmentTrees(int[] arr){
        this.root = constructTree(arr,0,arr.length-1);
    }
    private Node constructTree(int[] arr, int start, int end){
        if(start==end){
            Node leaf = new Node(start,end);
            leaf.data = arr[start];
            return leaf;
        }
        int mid = start+(end-start)/2;
        Node node = new Node(start,end);
        node.left = constructTree(arr,start,mid);
        node.right = constructTree(arr,mid+1,end);
        node.data = node.left.data+node.right.data;
        return node;
    }
    public void display(){
        display(this.root);
    }
    public void display(Node node){
        String str="";
        if(node.left!=null) {
            str = str + "Interval = [" + node.left.start + "," + node.left.end + "] : " + node.left.data + " => ";
        }else{
            str = str + "No left child";
        }
        str = str + "Interval = [" + node.start + "," + node.end + "] : " + node.data + " => ";
        if(node.right!=null){
            str = str + "Interval = [" + node.right.start + "," + node.right.end + "] : " + node.right.data + " => ";
        }else{
            str = str + "No right child";
        }
        System.out.println(str);
        if(node.left!=null){
            display(node.left);
        }
        if(node.right!=null){
            display(node.right);
        }
    }
    public int query(int qsi, int qei){
        return query(this.root,qsi,qei);
    }
    private int query(Node node, int qsi, int qei){
        if(node.start>=qsi && node.end<=qei){
            return node.data;
        }else if(node.start>qei || node.end<qsi){
            return 0;
        }else{
            return query(node.left,qsi,qei)+query(node.right,qsi,qei);
        }
    }
    public void update(int index,int val){
        this.root.data = update(this.root,index,val);
    }
    public int update(Node node,int index, int val){
        if(index>=node.start && index<=node.end){
            if(index==node.start && index==node.end){
                node.data = val;
                return node.data;
            }else{
                update(node.left,index,val);
                update(node.right,index,val);
                node.data = node.left.data+node.right.data;
                return node.data;
            }
        }
        return node.data;
    }

}
