import java.util.Arrays;
import java.util.Scanner;

public class Bubblesort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the no.of elements: ");
        int n = sc.nextInt();
        int[] a = new int[n];
        System.out.println();
        System.out.println("Enter the elements to the array: ");
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
        System.out.println("The elements after sorting are: " + Arrays.toString(a));
    }
}
