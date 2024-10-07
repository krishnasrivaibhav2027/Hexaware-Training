public class SumOfDigits {
    public static void main(String[] args) {
        int n=3412;
        System.out.println(digitSum(n));
    }
    static int digitSum(int n){
        if(n<1){
            return 0;
        }
        return n%10+digitSum(n/10);
    }
}
