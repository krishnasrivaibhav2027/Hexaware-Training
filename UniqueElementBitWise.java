public class UniqueElementBitWise {
    public static void main(String[] args) {
        int[]arr={5,6,5,3,3,2,1,7,1,2,6};
        int unique=0;
        for(int i:arr){
            unique^=i;
        }
        System.out.println(unique);
    }
}
