import java.util.ArrayList;
import java.util.Scanner;

public class BSearchFloor {
    static int floorValue(int[] arr, int target) {
        int start = 0, end = arr.length - 1, mid;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (target < arr[mid]) {
                end = mid - 1;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else {
                return arr[mid];
            }
        }
        return arr[end];

    }

    public static void main(String[] args) {
        int target, result, n;
        ArrayList<Integer> arrayList = new ArrayList<>(10);
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of array: ");
        n = sc.nextInt();
        System.out.println("Enter the elements to the array: ");
        for (int i = 0; i < n; i++) {
            arrayList.add(sc.nextInt());
        }
        int[] arr = new int[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            arr[i] = arrayList.get(i);
        }
        System.out.println("Enter the target element: ");
        target = sc.nextInt();
        result = floorValue(arr, target);
        System.out.println("The greatest element which is smaller than target is: " + result);
    }
}
