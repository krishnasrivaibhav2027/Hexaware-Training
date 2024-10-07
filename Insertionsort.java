import java.util.Arrays;
import java.util.Scanner;

public class Insertionsort {
    public static void main(String[] args) {
        int i, j, n, curr;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no.of elements: ");
        n = sc.nextInt();
        int[] a = new int[n];
        System.out.println("Enter the elements to the array: ");
        for (i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        for (i = 1; i < n; i++) {
            curr = a[i];
            j = i - 1;
            while (j >= 0 && curr < a[j]) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = curr;
        }
        System.out.println("elements after sorting are: "+ Arrays.toString(a));

    }
}
