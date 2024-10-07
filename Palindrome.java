import java.util.Scanner;
class Palindrome 
{
    public static void main(String[] args)
    {
         int t,rev=0,d;
         Scanner s= new Scanner(System.in);
         System.out.println("enter a number: ");
         int n= s.nextInt();
         t=n;
         while(n>0)
         {
             d=n%10;
             rev=rev*10+d;
             n=n/10;
         }
         if(t==rev)
         System.out.println("the given number is palindrome");
         else
         System.out.println("the given number is not a palindrome");

    }
}
