import java.util.Scanner;
class box
{
   int l,b;
   int h;
   int area()
   {
       return l*b;
   }
   int perimeter()
   {
       return (2*(l+b));
   }
   float vol()
   {
       return l*b*h;
   }
}
class Rectangle
{
    public static void main(String[] args)
    {
        box b=new box();
        Scanner s= new Scanner(System.in);
        System.out.println("enter the parameters for the rectangle:- ");
        b.l=s.nextInt();
        b.b=s.nextInt();
        b.h=s.nextInt();
        System.out.println("area is:- "+ b.area());
        System.out.println("perimeter is:- " + b.perimeter());
        System.out.println("volume is:- " + b.vol());
    }
}
