import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n= Integer.parseInt(br.readLine());
        if(n==2) System.out.print(1);
        else{
            int[] dp= new int[n];
            dp[0]= 0;
            dp[1]= 1;
            dp[2]= 1;

            for(int i=3; i<n; i++)
                dp[i]= dp[i-2]%10007+ dp[i-3]%10007;

            System.out.print(dp[n-1]%10007);
        }
    }
}