import java.util.*;

public class Pattern12 {
    public static void main(String[] args) {
        int i, j, n;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        n = sc.nextInt();
        for (i = 1; i <= n; i++) {
            for (j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            for (j = 1; j <= n; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}