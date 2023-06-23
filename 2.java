import java.util.*;
import java.lang.Math;
public class go
{
    public static Scanner scn=new Scanner (System.in);
        public static void main(String [] args)
    {
        int arms=scn.nextInt();
        int days=scn.nextInt();
        double data[][] = new double[arms][days];
        for(int i=0; i<arms; i++)
        {
            for(int j=0; j<days; j++)
            {
                data[i][j]=Math.random();
            }
        }
        double rew[] = new double[arms];
        int pulls[] = new int[arms];
        double ucb[] = new double[arms];
        int maxipul=0;
        int maxipulind=0;
        for(int i=0; i<days; i++)
        {
            if(i<arms)
            {
                rew[i]+=data[i][i];
                pulls[i]++;
            }
            else
            {
                double maxi=0;
                int ind=0;
                for(int j=0; j<arms; j++)
                {
                    if(i==days-1)
                    {
                        if(pulls[j]>maxipul)
                        {
                            maxipul=pulls[j];
                            maxipulind=j;
                        }
                    }
                    else
                    {
                        ucb[j]=((rew[j]/pulls[j])+Math.sqrt(2*Math.log(i)/pulls[j]));
                        if(ucb[j]>maxi)
                        {
                            maxi=ucb[j];
                            ind=j;
                        }
                    }
                }
                rew[ind]+=data[ind][i];
                pulls[ind]++;
            }
        }
        System.out.println("Here we get"+maxipul+" "+maxipulind);
        for(int i=0; i<arms; i++)
        {
            System.out.println(rew[i]+" "+pulls[i]);
        }
    }
}