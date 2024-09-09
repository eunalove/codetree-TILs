//n과 m
import java.util.*;
import java.io.*;

public class Main {

    static int ans= 0;
    static int[] dx= {-1, 1, 0, 0};
    static int[] dy= {0, 0, -1, 1};

    public static void main(String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        int n= Integer.parseInt(st.nextToken());
        int m= Integer.parseInt(st.nextToken());

        int[][] map= new int[n][m];
        int max= -1;
        for(int i=0; i<n; i++){
            st= new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                map[i][j]= Integer.parseInt(st.nextToken());
                max= max> map[i][j]? max: map[i][j];
            }
        }

        boolean[][] vis;
        int maxK =1;

        for(int k=1; k<=max; k++){
            vis= new boolean[n][m];
            int cnt= 0;
            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    if(map[i][j] <=k || vis[i][j]) continue;
                    cnt++;
                    dfs(i, j, n, m, k, vis, map);
                }
            }
            if(cnt > ans){
                maxK= k;
                ans= cnt;
            }
        }

        System.out.print(maxK+" "+ans);
        
    }

    static void dfs(int x, int y, int n, int m, int k, boolean[][] vis, int[][] map){

        vis[x][y]= true;

        for(int i=0; i<4; i++){
            int nx= x+ dx[i];
            int ny= y+ dy[i];

            if(nx <0 || ny<0 || nx>= n || ny>= m || map[nx][ny]<= k || vis[nx][ny]) continue;
            
            dfs(nx, ny, n, m, k, vis, map);
        }
    }
}