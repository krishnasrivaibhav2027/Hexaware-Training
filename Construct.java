//implementing constructor without passing any parameters
public class Construct 
{
    int l,b;
    Construct()
    {
        l=10;
        b=20;
    }
    int area()
    {
        return l*b;
    }
    
}
class Demo
{
    public static void main(String[] args)
    {
        Construct a= new Construct();
        int r=a.area();
        System.out.println("the area is:- "+r);
    }
}
