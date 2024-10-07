public class SquareRoot {
    public static void main(String[] args) {
        int n=40;
        int p=2;
        System.out.printf("%.3f",findSqrRoot(n,p));
    }
    static double findSqrRoot(int n, int p){
        int start=0;
        double root =0.0;
        int end=n;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(mid*mid==n){
                return mid;
            }
            else if(mid*mid>n){
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }
        double decimal=0.1;
        for(int i=0;i<p;i++) {
            while (root*root <= n) {
                root += decimal;
            }
            root-=decimal;
            decimal/=10;
        }
        return root;
    }
}
