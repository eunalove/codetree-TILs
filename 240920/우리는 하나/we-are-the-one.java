import java.util.*;
import java.io.*;

public class Main {

    static int[] dx={-1, 1, 0, 0};
    static int[] dy={0, 0, -1, 1};

    static int ans= 0;

    public static void main(String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        int n= Integer.parseInt(st.nextToken());
        int k= Integer.parseInt(st.nextToken());
        int u= Integer.parseInt(st.nextToken());
        int d= Integer.parseInt(st.nextToken());
        
        int[][] map= new int[n][n];

        for(int i=0; i<n; i++){
            st= new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                map[i][j]= Integer.parseInt(st.nextToken());
            }
        }
        
        int[] cities= new int[k];

        subSet(0, 0, n, k, u, d, cities, map);

        System.out.print(ans);

    }

    static void subSet(int cur, int idx, int n, int k, int u, int d, int[] cities, int[][] map){

        if(cur == k){
            bfs(n, u, d, cities, map);
            return;
        }

        if(idx == n*n) return;

        cities[cur]= idx;
        subSet(cur+1, idx+1, n, k, u, d, cities, map);
        subSet(cur, idx+1, n, k, u, d, cities, map);

    }

    static void bfs(int n, int u, int d, int[] cities, int[][] map){

        Queue<int[]> q= new ArrayDeque();
        boolean[][] vis= new boolean[n][n];

        for(int city: cities){
            int x= city/n;
            int y= city%n;

            q.add(new int[]{x, y});
            vis[x][y]= true;
        }

        while(!q.isEmpty()){

            int[] cur= q.poll();
            int val= map[cur[0]][cur[1]];

            for(int i=0; i<4; i++){
                int nx= cur[0]+ dx[i];
                int ny= cur[1]+ dy[i];

                if(nx<0 || ny<0 || nx>=n || ny>= n || vis[nx][ny] ||  Math.abs(map[nx][ny] - val) < u || Math.abs(map[nx][ny] - val) > d) continue;

                vis[nx][ny]= true;
                q.add(new int[]{nx, ny});
            }
        }

        int cnt= 0;

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++)
                if(vis[i][j]) cnt++;
        }

        ans= ans > cnt ? ans : cnt;
    }
}