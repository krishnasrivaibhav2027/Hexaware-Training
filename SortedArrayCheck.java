public class SortedArrayCheck {
    public static void main(String[] args) {
        int[] arr={1,2,3,7,8,10,20};
        if(isSorted(arr,0)){
            System.out.println("It's sorted");
        }
        else{
            System.out.println("It's not sorted");
        }
    }
    static Boolean isSorted(int[] arr,int n){
        if(n==arr.length-1){
            return true;
        }
        return arr[n]<arr[n+1] && isSorted(arr,n+1);
    }
}
