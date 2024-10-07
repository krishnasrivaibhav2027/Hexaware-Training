public class Towerofhanoi {
    public static void towers(int n, String src, String helper, String dest) {
        if (n == 1) {
            System.out.println("Transfer disk " + n + " from " + src + " to " + dest);
            return;
        }
        towers(n - 1, src, dest, helper);
        System.out.println("Transfer disk " + n + " from " + src + " to " + dest);
        towers(n - 1, helper, src, dest);
    }

    public static void main(String[] args) {
        int n = 3;
        towers(n, "S", "H", "D");
    }
}
