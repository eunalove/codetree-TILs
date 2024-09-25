import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n= Integer.parseInt(br.readLine());
        
        int[] dp= new int[n+1];
        if(n==1) System.out.print(2);
        else if(n==2) System.out.print(7);
        else{
            
            dp[1]= 2;
            dp[2]= 7;

            for(int i=3; i<=n; i++)
                dp[i]= (dp[i-1]*4 - dp[i-2]*3)%1000000007;


            System.out.print(dp[n]);
        }
    }
}