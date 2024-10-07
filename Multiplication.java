import java.lang.String;
import java.util.Scanner;
class Multiplication
{
    public static void main(String[] args)
    {
        int i;
        Scanner s = new Scanner(System.in);
        System.out.println("enter a number: ");
        int a=s.nextInt();
        System.out.println("for how many numbers: ");
        int b=s.nextInt();
        System.out.println("thr multiplication table is: ");
        for(i=1;i<=b;i++)
        {
            System.out.printf("%d * %d =%d\n",a,i,a*i);
        }

    }
}