package com.vaibhav.TrieDataStructure;

public class Tries {
    static class Node{
        Node[] children = new Node[26];
        boolean eow;

        public Node() {

        }
    }

    public static Node root = new Node();
        
    public static void insert(String word){
        int level = 0;
        int length = word.length();
        int idx = 0;

        Node curr = root;
        while(level < length){
            idx = word.charAt(level)-'a';
            if(curr.children[idx] == null) curr.children[idx] = new Node();
            curr = curr.children[idx];
            level++;
        }
        curr.eow = true;
    }

    public static boolean search(String word){
        if(root == null) return false;
        int level = 0;
        int length = word.length();
        int idx = 0;

        Node curr = root;
        while(level < length){
            idx = word.charAt(level)-'a';
            if(curr.children[idx] == null) return false;
            curr = curr.children[idx];
            level++;
        }
        return curr.eow;
    }
}
