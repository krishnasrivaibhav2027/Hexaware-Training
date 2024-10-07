
/**
 * Pattern1
 */
import java.util.*;

public class Pattern1 {
    public static void main(String[] args) {
        int i, j, m, n;
        System.out.println("Enter the rows and columns");
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        for (i = 0; i < m; i++) {
            for (j = 0; j < n; j++) {
                System.out.print("*");
            }
            System.out.print("\n");
        }
    }
}