public class NewtonSqrt {
    public static void main(String[] args) {
        int n=36;
        System.out.printf("%.3f",findSqrt(n));
    }
    static double findSqrt(int n){
        double x= n;
        double root;
        while(true){
            root = 0.5*(x+(n /x));
            if (Math.abs(root-x)<0.5){
                break;
            }
            x=root;
        }
        return root;
    }
}
