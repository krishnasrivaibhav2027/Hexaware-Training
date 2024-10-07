
import java.util.Arrays;

public class BinarySearchMatrix {
    public static void main(String[] args) {
        int[][] arr={
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}
        };
        int target=5;
        System.out.println(Arrays.toString(twoDimSearch(arr,target)));
    }
    static int[] binarySearch(int[][] arr, int target, int row,int cstart, int cend){
        while(cstart<cend){
            int mid=cstart+(cend-cstart)/2;
            if(arr[row][mid]==target){
                return new int[]{row,mid};
            }
            else if(arr[row][mid]<target){
                cstart=mid+1;
            }
            else{
                cend=mid-1;
            }
        }
        return new int[]{-1,-1};
    }

    static int[] twoDimSearch(int[][] arr, int target){
        int rows=arr.length;
        int cols=arr[0].length;

        if(rows==1){//if there is a single dimensional array
            return binarySearch(arr,target,rows,0,cols-1);
        }

        //now let's go for checking multi dimensional array
        int rstart=0;
        int rend=rows-1;
        int cmid=cols/2; // for finding the middle element in the given column

        //Loop runs until there are 2 rows left
        while(rstart<=(rend-1)){
            int mid=rstart+(rend-rstart)/2;
            if(arr[mid][cmid]==target){
                return new int[]{mid,cmid};
            }
            if(arr[mid][cmid]<target){
                rstart=mid;
            }
            else{
                rend=mid;
            }

            //if the element is not found above and still there are 2 rows left
            // first check if the element can be found in the cols
            if(arr[rstart][cmid]==target){
                return new int[]{rstart,cmid};
            }
            if(arr[rstart+1][cmid]==target){
                return new int[]{rstart+1,cmid};
            }
            // if the element is not found in the cols , then we must look into the 4 cases and apply
            //binary search accordingly
            if(target<=arr[rstart][cmid-1]){ // searching in first half
                return binarySearch(arr,target,rstart,0,cmid-1);

            }
            if(target>=arr[rstart][cmid+1]){ //searching in the second half
                return binarySearch(arr,target,rstart,cmid+1,cols-1);
            }

            if(target<=arr[rstart+1][cmid-1]){ // searching in the third half
                return binarySearch(arr,target,rstart+1,0,cmid-1);
            }

       
        }
        return binarySearch(arr,target,rstart+1,cmid+1,cols-1);
    }
}
