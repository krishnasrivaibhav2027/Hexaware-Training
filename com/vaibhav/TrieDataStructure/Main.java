package com.vaibhav.TrieDataStructure;

import static com.vaibhav.TrieDataStructure.Tries.*;
public class Main {
    public static void main(String[] args) {
        String[] arr = {"the","a","there","their","any","thee"};
        for(String word: arr){
            insert(word);
            System.out.println("Inserted "+word);
        }
        System.out.println(search("their"));
    }
}
