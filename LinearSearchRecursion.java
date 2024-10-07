public class LinearSearchRecursion {
    public static void main(String[] args) {
        int[] arr = {7, 3, 8, 1, 2, 18, 50};
        int target = 50;
        if (searchTarget(arr, 0,target)) {
            System.out.println("Target found!"+" at index "+findIndex(arr,0,target));
        } else {
            System.out.println("Target not found...!");
        }
    }

    static Boolean searchTarget(int[] arr, int n, int target){
        if(n==arr.length){
            return false;
        }
        return arr[n]==target || searchTarget(arr,n+1,target);
    }
    static int findIndex(int[] arr, int n, int target){
        if(n==arr.length){
            return -1;
        }
        if(arr[n]==target){
            return n;
        }
        else{
            return findIndex(arr,n+1,target);
        }
    }
}
