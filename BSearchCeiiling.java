import java.util.ArrayList;
import java.util.Scanner;

public class BSearchCeiiling {
    static int ceilValue(int[] arr, int target) {
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
        return arr[start];
    }

    public static void main(String[] args) {
        int target, result;
        ArrayList<Integer> arrayList = new ArrayList<>(10);
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of array: ");
        int n = sc.nextInt();
        System.out.println();
        System.out.print("Enter the elements to the array: ");
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            arrayList.add(num);
        }
        int[] arr = new int[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            arr[i] = arrayList.get(i);
        }
        System.out.println();
        System.out.print("Enter a target element: ");
        target = sc.nextInt();
        result = ceilValue(arr, target);
        System.out.println("The smallest number which is greater than the target number is " + result);
    }
}
