import java.util.*;

public class Pattern8 {
    public static void main(String[] args) {
        int i, j, n, num = 1;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number");
        n = sc.nextInt();
        for (i = 1; i <= n; i++) {
            for (j = 1; j <= i; j++) {
                System.out.print(num + " ");
                num++;
            }
            System.out.println();
        }
    }
}
