import java.lang.Math;
import java.util.Scanner;
 class Armstrong 
{
    public static void main(String[] args)
    {
        int t,c=0,a,d,sum=0;
        Scanner s= new Scanner(System.in);
        System.out.println("enter a number: ");
        int n=s.nextInt();
        a=t=n;
        while(n>0)
        {
            c+=1;
            n/=10;
        }
        while(t>0)
        {
            d=t%10;
            sum+=Math.pow(d,c);
            t/=10;

        }
        if(a==sum)
        System.out.println("the given number is an armstrong number");
        else
        System.out.println("the given number is not an armstrong number");
    }
}
    

