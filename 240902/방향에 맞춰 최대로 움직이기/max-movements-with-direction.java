import java.util.*;
import java.io.*;

public class Main {
    static int ans= 0;
    static int[] dx= {-1, -1, 0,  1, 1, 1,    0,-1};
    static int[] dy= {0, 1, 1,    1, 0, -1,  -1,-1};

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

        int[][] dir= new int[n][n];
        for(int i=0; i<n; i++){
            st= new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                dir[i][j]= Integer.parseInt(st.nextToken()) -1;
            }
        }

        st= new StringTokenizer(br.readLine());
        int sx= Integer.parseInt(st.nextToken()) -1;
        int sy= Integer.parseInt(st.nextToken()) -1;

        dfs(0, sx, sy, 0, 0, n, map, dir);

        System.out.print(ans);
    }

    static void dfs(int cnt, int x, int y, int bx, int by, int n, int[][] map, int[][] dir){

        if(x<0 || y<0 || x>=n || y>=n) return;

        if(cnt >0  && map[x][y] <= map[bx][by]) return;

        ans= ans> cnt? ans: cnt;

        for(int i=1; i<n; i++){
            int nx= x+ i*dx[dir[x][y]];
            int ny= y+ i*dy[dir[x][y]];

            dfs(cnt+1, nx, ny, x, y, n, map, dir);
        }
    }

}