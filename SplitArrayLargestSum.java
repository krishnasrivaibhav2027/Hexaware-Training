public class SplitArrayLargestSum {
    public static void main(String[] args) {
        int start=0,end=0,mid,k,s,c;
        int[] arr={7,2,5,10,8};
        k=2;
        for (int j : arr) {
            start = Math.max(start, j);
            end += j;
        }
        while(start<end){
            mid=start+(end-start)/2;
            c=1;
            s=0;
            for(int num:arr){
                if(s+num>mid){
                    s=num;
                    c+=1;
                }
                else{
                    s+=num;
                }
            }
            if(c>k){
                start=mid+1;
            }
            else{
                end=mid;
            }
        }
        System.out.println(end);
    }
}
