import java.util.ArrayList;
import java.util.Arrays;

public class RemoveNegativesArray {
    public static void main(String[] args) {
        int[] arr= {10,20,-15,-30,35,45,-18,50};
        ArrayList<Integer> arr1 = new ArrayList<>();
        for (int j : arr) {
            if(j>=0) {
                arr1.add(j);
            }
        }
        System.out.println(arr1);

    }
}
