// java program to find the product of elements in the array
import java.util.*;
public class Productarr 
{
    public static void main(String[] args)
    {
        int p=1;
        Scanner s=new Scanner(System.in);
        System.out.printf("enter the number of elements in array: \n");
        int n=s.nextInt();
        int a[]=new int[n];
        System.out.printf("enter the elements to the array: \n");
        for(int i=0;i<n;i++)
        {
            a[i]=s.nextInt();
        }
        for(int i=0;i<n;i++)
        {
            p*=a[i];
        }
        System.out.printf("the product of the elements in the array is: "+p);
        
    }
}
