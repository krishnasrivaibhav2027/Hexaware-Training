public class construct_2 
{
 int l,b;
 construct_2(int u, int v)
 {
     l=u;
     b=v;
 }
 int area()
 {
    return l*b;
 }

}
class Demo1
{
    public static void main(String[] args)
    {
        construct_2 d= new construct_2(10,200);
        int p=d.area();
        System.out.println("The area is:- "+p);
    }
}
