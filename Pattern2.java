import java.util.*;

public class Pattern2 {
    public static void main(String[] args) {
        int i, j, m, n;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of rows:- ");
        m = sc.nextInt();
        System.out.println("Enter the number of columns:-");
        n = sc.nextInt();
        for (i = 0; i < m; i++) {
            for (j = 0; j < n; j++) {
                if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {

                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.print("\n");
        }
    }
}
