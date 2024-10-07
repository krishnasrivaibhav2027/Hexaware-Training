import java.util.*;
import java.lang.*;
public class MountainArray {
    public static void main(String[] args){
        int[] arr={7,8,9,10,5,4,3,2,1,0};
        System.out.println(peakIndexInMountainArray(arr));
    }
    static int peakIndexInMountainArray(int[] arr){
        int start=0,end=arr.length-1,mid;
        while(start<end){
            mid=start+(end-start)/2;
            if(arr[mid]>arr[mid+1]){
                end=mid;
            }
            else{
                start=mid+1;
            }
        }
        return start;
    }
}
