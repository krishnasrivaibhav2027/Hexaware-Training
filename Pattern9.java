import java.util.*;

public class Pattern9 {
    public static void main(String[] args) {
        int i, j, n;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        n = sc.nextInt();
        for (i = 1; i <= n; i++) {
            for (j = 1; j <= i; j++) {
                if (i % 2 == 0) {
                    System.out.print((j + 1) % 2 + " ");
                } else {
                    System.out.print(j % 2 + " ");
                }
            }
            System.out.println();
        }
    }
}
