//n과 m
import java.util.*;
import java.io.*;

public class Main {

    static int[] dx= {-1, 1, 0, 0};
    static int[] dy= {0, 0, -1, 1};

    public static void main(String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        int n= Integer.parseInt(st.nextToken());
        int k= Integer.parseInt(st.nextToken());

        int[][] map= new int[n][n];

        for(int i=0; i<n; i++){
            st= new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                map[i][j]= Integer.parseInt(st.nextToken());
            }
        }

        boolean[][] vis= new boolean[n][n];

        for(int i=0; i<k; i++){
            st= new StringTokenizer(br.readLine());
            int x= Integer.parseInt(st.nextToken()) -1;
            int y= Integer.parseInt(st.nextToken()) -1;
            bfs(x, y, n, map, vis);
        }

        int ans= 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++)
                if(vis[i][j]) ans++;

        }
        
        System.out.print(ans);

    }

    static void bfs(int x, int y, int n, int[][] map, boolean[][] vis){
        
        Queue<int[]> q= new ArrayDeque();
        q.add(new int[]{x,y});

        while(!q.isEmpty()){

            int[] cur= q.poll();

            for(int i=0; i<4; i++){
                int nx= cur[0] + dx[i];
                int ny= cur[1] + dy[i];

                if(nx<0 || ny<0 || nx>=n || ny>=n || map[nx][ny] == 1 || vis[nx][ny]) continue;

                vis[nx][ny]= true;
                q.add(new int[]{nx, ny});
                
            }
        }
    }
}