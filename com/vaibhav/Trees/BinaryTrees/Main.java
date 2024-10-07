package com.vaibhav.Trees.BinaryTrees;
import java.util.*;
public class Main {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        BinaryTree tree = new BinaryTree();
//        tree.populate(scanner);
//        tree.display();
//        BinarySearchTree bst = new BinarySearchTree();
//          AVLTrees tree = new AVLTrees();
//        int[] arr = {3,4,5,1,2};
//        SegmentTrees ST = new SegmentTrees(arr);
//        ST.display();
//        System.out.println(ST.query(0,4));
//
//        //tree.populateSorted(arr);
//        tree.populate(arr);
//        bst.populate(arr);
//        tree.display();
//        System.out.println("Height: "+(tree.height(tree.root)));
//        System.out.println(tree.balanced());
//        System.out.println(bst.balanced());
//        System.out.println(tree.height(tree.root));
//        System.out.println(bst.height(bst.root));
          int[] arr = {1,2,3,4,5,6,7,8,9,10};
          BreadthFirstSearch bfs = new BreadthFirstSearch();
          bfs.populateSorted(arr);
          bfs.display();
          bfs.displayBFS();
    }
}
