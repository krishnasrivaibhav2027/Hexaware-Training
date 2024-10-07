import java.util.Arrays;

public class BSearchMatrix {
    public static void main(String[] args) {
        int [][] arr={
                {15,18,20,30},
                {25,50,55,60},
                {30,62,72,82},
                {35,80,100,120}
        };
        int target=35;
        System.out.println(Arrays.toString(twoDimSearch(arr,target)));
    }
    static int[] twoDimSearch(int[][] arr, int target){
        int r=0,c=arr.length-1;
        while(r<arr.length && c>=0){
            if(arr[r][c]==target){
                return new int[]{r,c};
            }
            if(arr[r][c]>target){
                c--;
            }
            else{
                r++;
            }
        }
        return new int[]{-1,-1};
    }
}
