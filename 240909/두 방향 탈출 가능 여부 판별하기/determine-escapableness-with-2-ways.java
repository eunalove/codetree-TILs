//n과 m
import java.util.*;
import java.io.*;

public class Main {
    static int ans= 0;

    static int[] dx= {1, 0};
    static int[] dy= {0, 1};
    public static void main(String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        int n= Integer.parseInt(st.nextToken());
        int m= Integer.parseInt(st.nextToken());

        int[][] map= new int[n][m];

        for(int i=0; i<n; i++){
            st= new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                map[i][j]= Integer.parseInt(st.nextToken());
            }
        }

        boolean[][] vis= new boolean[n][m];
        vis[0][0]= true;
        
        dfs(0, 0, n, m, vis, map);

        System.out.print(ans);
    }

    static void dfs(int x, int y, int n, int m, boolean[][] vis, int[][] map){

        if(ans == 1) return;

        if(x == n-1 && y == m-1){
            ans= 1;
            return;
         }

        for(int i=0; i<2; i++){
            int nx= x+ dx[i];
            int ny= y+ dy[i];

            if(nx < 0 || ny <0 || nx>=n || ny>=m || map[nx][ny] == 0 || vis[nx][ny]) continue;
                    
            vis[nx][ny]= true;
            dfs(nx, ny, n, m, vis, map);
            vis[nx][ny]= false;
                
            
        }
    }
}