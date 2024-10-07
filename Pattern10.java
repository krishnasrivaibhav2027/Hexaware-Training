import java.util.*;

public class Pattern10 {
    public static void main(String[] args) {
        int i, j, n, spaces;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        n = sc.nextInt();
        for (i = 1; i <= n; i++) {
            for (j = 1; j <= i; j++) {
                System.out.print("*");
            }
            spaces = 2 * (n - i);
            for (j = 1; j <= spaces; j++) {
                System.out.print(" ");
            }
            for (int k = 1; k <= i; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (i = n; i >= 1; i--) {
            for (j = 1; j <= i; j++) {
                System.out.print("*");
            }
            spaces = 2 * (n - i);
            for (j = 1; j <= spaces; j++) {
                System.out.print(" ");
            }
            for (int k = 1; k <= i; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
