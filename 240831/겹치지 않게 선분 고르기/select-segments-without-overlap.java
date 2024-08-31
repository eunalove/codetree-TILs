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
        dfs(0, n, vis, map, -1);

        System.out.print(ans);

    }

    static void dfs(int cnt, int n, boolean[] vis, int[][] map, int lastEnd){
        
        ans= ans> cnt? ans: cnt;

        for(int i=0; i<n; i++){
            if(vis[i]) continue;
            
            vis[i]= true;
            // 이전에 선택한 선분과 겹치지 않는지 확인
            if (lastEnd != -1 && map[i][0] <= lastEnd) {
                continue;
            }
            dfs(cnt+1, n, vis, map, map[i][1]);
            vis[i]= false;
        }
    }
}