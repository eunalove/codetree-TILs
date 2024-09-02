import java.util.*;
import java.io.*;

public class Main {

    static int ans= Integer.MAX_VALUE;

    public static void main(String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n= Integer.parseInt(br.readLine());

        StringTokenizer st= new StringTokenizer(br.readLine());
        int[] jump= new int[n];
        for(int i=0; i<n; i++) jump[i]= Integer.parseInt(st.nextToken());
        
        dfs(0, 0, n, jump);

        if(ans == Integer.MAX_VALUE) System.out.print(-1);
        else System.out.print(ans);
    }

    static void dfs(int cnt, int loca, int n, int[] jump){

        if(cnt > n || loca >=n) return;

        if(loca == n-1){
            ans= ans > cnt? cnt: ans;
            return;
        }

        for(int i=1; i<=jump[loca]; i++)
            dfs(cnt+1, loca+i, n, jump);
        
    }
}