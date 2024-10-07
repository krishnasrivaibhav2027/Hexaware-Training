import java.lang.Math;
import java.util.Scanner;
class Distance
{
    public static void main(String[] args)
    {
        Scanner s= new Scanner(System.in);
        System.out.println("enter x1: ");
        int a=s.nextInt();
        System.out.println("enter x2: ");
        int b=s.nextInt();
        System.out.println("enter y1: ");
        int c=s.nextInt();
        System.out.println("enter y2: ");
        int d=s.nextInt();
        
        double e=Math.sqrt(Math.pow(b-a,2)+ Math.pow(d-c,2));



        System.out.println("the distance between 2 points is: "+ e);
    }
}