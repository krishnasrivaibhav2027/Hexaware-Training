public class MinimumRotatedArray {
    public static void main(String[] args) {
        int[] arr={2,2,2,0,1};
        System.out.println(findMin(arr));
    }
    static int findMin(int[] arr){
        int start=0,end=arr.length-1,mid;
        while(start<end){
            mid=start+(end-start)/2;
            if(arr[mid]<arr[end]){
                end=mid;
            }
            else if(arr[mid]>arr[end]){
                start=mid+1;
            }
            else{
                start++;
            }
        }
        return arr[end];
    }
}
