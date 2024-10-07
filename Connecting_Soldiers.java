import java.util.*;
class Connecting_Soldiers
{
    
    public static void main(String[] args)
    {
        Scanner s= new Scanner(System.in);
        int i,j,n;
        int c=0;
        int a[][]=new int[10][10];
        n=s.nextInt();
        for(i=0;i<n;i++)
        {
            for(j=0;j<i;j++)
            {
                a[i][j]=s.nextInt();
            }
        }
        System.out.println("testing"+c);

    }
}