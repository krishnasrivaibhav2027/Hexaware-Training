import java.util.*;

public class Pattern3 {
    public static void main(String[] args) {
        int i, j, n;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        n = sc.nextInt();
        System.out.print("\n");
        for (i = 0; i < n; i++) {
            for (j = 0; j <= i; j++) {
                System.out.print("*");
            }
            System.out.print("\n");
        }
    }
}
