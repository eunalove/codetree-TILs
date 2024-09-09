//n과 m
import java.util.*;
import java.io.*;

public class Main {

    static int[] dx= {-1, 1, 0, 0};
    static int[] dy= {0, 0, -1, 1};

    static int bombTmp= 0;

    public static void main(String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n= Integer.parseInt(br.readLine());

        StringTokenizer st;

        int[][] map= new int[n][n];

        for(int i=0; i<n; i++){
            st= new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                map[i][j]= Integer.parseInt(st.nextToken());
            }
        }

        boolean[][] vis= new boolean[n][n];

        int bombCnt= 0;
        int bombMax= 0;

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(vis[i][j]) continue;
                
                bombTmp= 0;

                dfs(map[i][j], i, j, n, vis, map);
                
                if(bombTmp >=4) bombCnt++;
                
                bombMax= bombMax> bombTmp? bombMax: bombTmp;
            }
        }

        System.out.print(bombCnt+" "+bombMax);
    }

    static void dfs(int cur, int x, int y, int n, boolean[][] vis, int[][] map){

        vis[x][y]= true;
        bombTmp++;
        
        for(int i=0; i<4; i++){
            int nx= x+ dx[i];
            int ny= y+ dy[i];

            if(nx < 0 || ny <0 || nx>=n || ny>=n || map[nx][ny] != cur || vis[nx][ny]) continue;
            
            dfs(cur, nx, ny, n, vis, map);
               
        }
    }
}