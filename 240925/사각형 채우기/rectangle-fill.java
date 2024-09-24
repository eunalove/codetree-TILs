import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n= Integer.parseInt(br.readLine());

        int[] dp= new int[n];

        if(n==1) System.out.print(1);
        else{
            dp[0]= 1;
            dp[1]= 2;
            
            for(int i=2; i<n; i++)
                dp[i]= dp[i-1]+ dp[i-2];

            System.out.print(dp[n-1]);
        }
    }
}