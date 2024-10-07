import java.util.Arrays;

public class MergeSortInPlace {
    public static void main(String[] args) {
        int[] arr={3,1,4,5,2};
        ;
        divideArray(arr,0,arr.length);
        System.out.println(Arrays.toString(arr));
    }
    static void divideArray(int[] arr, int start, int end){
        if(end-start==1){
            return;
        }
        int mid=start+(end-start)/2;
        divideArray(arr,start,mid);
        divideArray(arr,mid,end);

        mergeInPlace(arr,start,mid,end);
    }
    static void mergeInPlace(int[] arr, int start, int mid, int end){
        int[] mix=new int[end-start];
        int i=start;
        int j=mid;
        int k=0;
        while(i<mid && j<end){
            if(arr[i]<arr[j]){
                mix[k]=arr[i];
                i++;
            }
            else{
                mix[k]=arr[j];
                j++;
            }
            k++;
        }
        while(i<mid){
            mix[k]=arr[i];
            i++;
            k++;
        }
        while(j<end){
            mix[k]=arr[j];
            j++;
            k++;
        }
        for(int l=0;l<mix.length;l++){
            arr[start+l]=mix[l];
        }
    }
}
