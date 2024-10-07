import java.util.*;

public class Pattern5 {
    public static void main(String[] args) {
        int i, j, k, n;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        n = sc.nextInt();
        for (i = 0; i < n; i++) {
            for (j = 0; j <= n - i; j++) {
                System.out.print(" ");
            }
            for (k = 0; k <= i; k++) {
                System.out.print("*");
            }
            System.out.print("\n");
        }
    }
}
