import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n= Integer.parseInt(br.readLine());
        
        int[] dp= new int[1000];

        dp[0]= 1;
        dp[1]= 3;
        dp[2]= 5;

        for(int i=3; i<n; i++)
            dp[i]= (dp[i-1] + dp[i-2]+ dp[i-3])%10007;

        if(n <= 3) System.out.print(dp[n-1]);
        else System.out.print(dp[n-1]+1);

    }
}