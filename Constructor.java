import java.util.*;
class boxs
{
    float l,b,h;
    boxs()
    {
        l=10;b=20;h=5;
    }
    boxs(float p, float q, float r)
    {
       l=p;b=q;h=r;
    }
    void boxval()
    {
        System.out.println("length:- "+l+"breadth:- "+"height:- "+h);
    }
    float area()
    {
        return l*b;
    }
    float peri()
    {
        return 2*(l+b);

    }
    float vol()
    {
        return l*b*h;
    }
    
}
class Constructor
{
    public static void main(String[] args)
    {
        boxs b=new boxs();
        b.boxval();
        boxs b1=new boxs(2,3,4);
        b1.boxval();
        System.out.println("b area=" +b.area()+"b perimeter= "+b.peri()+"b vol= " +b.vol());
        System.out.println("b1 area= "+b1.area()+"b perimeter= "+b1.peri()+"b vol= "+b1.vol());
        Scanner s=new Scanner(System.in);
        System.out.println("enter length breadth and height");
        b.l=s.nextFloat();
        b.b=s.nextFloat();
        b.h=s.nextFloat();
        float m=b.area();
        float n=b.peri();
        float o=b.vol();
        System.out.println("area of rect:- "+m+"perimeter of rect:- "+n+"volume of rect= "+o);

    }
}
