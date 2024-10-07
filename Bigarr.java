import java.util.*;
class Bigarr
{
    public static void main(String[] args)
    {
        Scanner s=new Scanner(System.in);
        System.out.println("enter the number of elements to the array: ");
        int n=s.nextInt();
        int a[]=new int[n];
        System.out.println("enter the elements to the array: ");
        for(int i=0;i<n;i++)
        {
            a[i]=s.nextInt();
        }
        int max=a[0];
        //System.out.println("the elements in the array are: ");
        for(int i=1;i<n;i++)
        {
            if(a[i]>max)
            max=a[i];
        }
        System.out.println("the largest element in the array: "+max);

    }
}