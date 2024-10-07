import java.util.Scanner;
public class prime 
{
    public static void main(String[] args)
    {
        int i,c=0;
        Scanner s=new Scanner(System.in);
        System.out.println("enter a number: ");
        int n=s.nextInt();
        i=2;
        while(i<=n/2)
        {
            if(n%i==0)
            {
                c+=1;
                break;
            }
            i+=1;
        }
        if(c==0)
        System.out.println("the given number is a prime number");
        else
        System.out.println("the given number is not a prime number");


    }
}
