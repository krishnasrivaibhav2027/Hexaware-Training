import java.util.Arrays;

public class BubbleSortRecursion {
    public static void main(String[] args) {
        int[] arr={7,3,8,1,2};
        sortArray(arr, arr.length - 1, 0);
        System.out.println("sorted array is "+ Arrays.toString(arr));
    }
    static void sortArray(int[] arr, int r, int c){
        if(r==0){
            return;
        }
        if(c<r){
            if(arr[c]>arr[c+1]){
                int temp=arr[c];
                arr[c]=arr[c+1];
                arr[c+1]=temp;
            }
            sortArray(arr,r,c+1);
        }
        else {
            sortArray(arr, r - 1, 0);
        }
    }
}
