import java.util.Arrays;

public class TwoSumII {
    public static void main(String[] args) {
        int[] arr={2,3,4};
        int target=6        ,start=0,end=arr.length-1;
        while(start<end){
            int sum=arr[start]+arr[end];
            if(sum==target){
                System.out.println(Arrays.toString(new int[]{start + 1, end + 1}));
                break;
            }
            else if(sum<target){
                start++;
            }
            else{
                end--;
            }
        }

    }

}
