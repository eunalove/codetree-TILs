import java.util.*;
import java.io.*;

public class Main {

    static int ans;
    public static void main(String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n= Integer.parseInt(br.readLine());

        StringTokenizer st;
        int[][] map= new int[n][2];

        for(int i=0; i<n; i++){
            st= new StringTokenizer(br.readLine());
            int x= Integer.parseInt(st.nextToken());
            int y= Integer.parseInt(st.nextToken());

            map[i][0]= x;
            map[i][1]= y;
        }

        boolean[] vis= new boolean[n];
        dfs(0, n, vis, map);

        System.out.print(ans);

    }

    static void dfs(int cnt, int n, boolean[] vis, int[][] map){
        
    if(cnt != 0){
        if(cnt == n || map[cnt-1][1] >= map[cnt][0]){
            ans= ans> cnt+1? ans: cnt+1;
            return;
        }
    }

        for(int i=0; i<n; i++){
            if(!vis[i]){
                vis[i]= true;
                dfs(cnt+1, n, vis, map);
                vis[i]= false;
            }
        }
    }
}