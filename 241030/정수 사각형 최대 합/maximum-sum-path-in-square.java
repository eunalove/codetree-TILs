import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n= Integer.parseInt(br.readLine());

        StringTokenizer st;
        int[][] map= new int[n][n];

        for(int i=0; i<n; i++){
            st= new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++)
                map[i][j]= Integer.parseInt(st.nextToken());
            
        }

        int[][] dp= new int[n][n];
        dp[0][0]= map[0][0];

        for(int i=1; i<n; i++)
            dp[0][i]= map[0][i]+ dp[0][i-1];

        for(int i=1; i<n; i++)
            dp[i][0]= map[i][0]+ dp[i-1][0];

        for(int i=1; i<n; i++){
            for(int j=1; j<n; j++)
                dp[i][j]= Math.max(dp[i-1][j], dp[i][j-1]) + map[i][j]; 
        }

        System.out.print(dp[n-1][n-1]);

    }
}