import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n= Integer.parseInt(br.readLine());

        int[] dp= new int[1001];
        dp[2]= 1;
        dp[3]= 1;

        for(int i=4; i<=n; i++)
            dp[i]= (dp[i-2]+ dp[i-3])%100007;

        System.out.print(dp[n]);

    }
}