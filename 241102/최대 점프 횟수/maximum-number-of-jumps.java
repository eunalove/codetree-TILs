import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n= Integer.parseInt(br.readLine());

        StringTokenizer st= new StringTokenizer(br.readLine());
        int[] arr= new int[n];

        for(int i=0; i<n; i++)
            arr[i]= Integer.parseInt(st.nextToken());

        int[] dp= new int[1001];
        for(int i=1; i<n; i++)
            dp[i]= -1;

        for (int i = 0; i < n; i++) {
            if (dp[i] == -1) continue;
            for (int j = 1; j <= arr[i] && i + j < n; j++) {
                dp[i + j] = Math.max(dp[i + j], dp[i] + 1);
            }
        }
        
        int ans= 0;
        for(int i=0; i<n; i++)
            ans= ans> dp[i]? ans: dp[i];

        System.out.print(ans);
    }
}