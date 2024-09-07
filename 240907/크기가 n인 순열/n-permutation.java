import java.util.*;
import java.io.*;

public class Main {

    static StringBuilder sb= new StringBuilder();
    public static void main(String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n= Integer.parseInt(br.readLine());

        boolean[] vis= new boolean[n];
        int[] ans= new int[n];

        dfs(0, n, ans, vis);

        System.out.print(sb);

    }

    static void dfs(int cur, int n, int[] ans, boolean[] vis){

        if(cur == n){
            for(int a: ans)
                sb.append(a).append(" ");

            sb.append("\n");
            return;
        }

        for(int i=0; i<n; i++){
            if(vis[i]) continue;

            vis[i]= true;
            ans[cur]= i+1;
            dfs(cur+1, n, ans, vis);
            vis[i]= false;
            
        }
    }
}