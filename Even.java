import java.util.Scanner;
class Even
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        System.out.println("enter a number: ");
        int n=s.nextInt();
        if(n%2==0)
        {
            System.out.println("the given number is an even number");
        }
        else{
            System.out.println("the given number is an odd number");
        }
    }
}