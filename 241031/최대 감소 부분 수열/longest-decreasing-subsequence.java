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
            for(int j=i-1; j>=0; j--)
                if(arr[i] < arr[j]) dp[i]= Math.max(dp[i], dp[j]+1);
            
        int ans= 0;
        for(int i=0; i<n; i++)
            ans= ans> dp[i]? ans: dp[i];

        System.out.print(ans+1);
    }
}