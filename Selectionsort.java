import java.util.Arrays;
import java.util.Scanner;

public class Selectionsort {
    public static void main(String[] args) {
        int i, j, n, small;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the no.of elements: ");
        n = sc.nextInt();
        int a[] = new int[n];
        System.out.println("Enter the elements to the array: ");
        for (i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        for (i = 0; i < n - 1; i++) {
            small = i;
            for (j = i + 1; j < n; j++) {
                if (a[small] > a[j]) {
                    small = j;
                }
            }
            int temp = a[small];
            a[small] = a[i];
            a[i] = temp;
        }
        System.out.println("Elements after sorting are: " + Arrays.toString(a));
    }
}