package com.vaibhav.Sqrt_Decomposition;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        int[] arr = {1,3,5,6,7,12,15,20,50};
        int n = arr.length;

        int sqrt = (int) Math.sqrt(n);

        int block_idx = -1;

        int[] block = new int[sqrt+1];

        for(int i = 0; i < n; i++){
            if(i%sqrt == 0) block_idx++;
            block[block_idx] += arr[i];
        }

        System.out.println(computeAns(block,arr,2,7,sqrt));
    }
    private static int computeAns(int[] block, int[] arr, int left, int right, int sqrt){
        int ans = 0;

        while(left%sqrt!=0 && left < right && left!=0){
            ans += arr[left];
            left++;
        }

        while(left + sqrt <= right){
            ans += block[left/sqrt];
            left += sqrt;
        }

        while(left <= right){
            ans += arr[left];
            left++;
        }

        return ans;
    }
}
