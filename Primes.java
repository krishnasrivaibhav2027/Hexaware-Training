import java.util.*;
class Primes
{
    public static void main(String[] args)
    {
        int i,c=0,d,j;
        Scanner s= new Scanner(System.in);
        System.out.println("enter the range of prime numbers: ");
        int n=s.nextInt();
        i=2;
        System.out.printf("the prime numbers between the range %d and %d are: \n",i,n);
        while(c<=n)
        {
            d=0;
            for(j=2;j<=i/2;j++)
            {
                if(i%j==0)
                {
                    d+=1;
                    break;
                }
            }
            if(d==0)
            {
                System.out.printf(i+" ");
                c+=1;
            }
            i+=1;
        }
        
    }
}