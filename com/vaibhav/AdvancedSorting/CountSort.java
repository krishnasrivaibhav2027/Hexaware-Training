package com.vaibhav.AdvancedSorting;

import java.util.Arrays;

public class CountSort {
    public static void countSort(int[] arr){
        if(arr == null && arr.length <= 1) return;

        int max = arr[0];
        for(int num: arr){
            if(num > max) max = num;
        }

        int[] freqArr = new int[max+1];
        for(int num: arr){
            freqArr[num]++;
        }
        int index = 0;
        for(int i = 0; i <= max; i++){
            while(freqArr[i] > 0){
                arr[index++] = i;
                freqArr[i]--;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {20,5,8,2,1,2,5,47,23};
        countSort(arr);
        System.out.println("Sorted array = "+ Arrays.toString(arr));
    }
}
