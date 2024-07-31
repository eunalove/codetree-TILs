import java.util.*;
import java.io.*;

public class Main {

    static int[] dx= {-1, -1, 1, 1, 0};
    static int[] dy= {1, -1, -1, 1, 0};
    static int ans;

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

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++)
                dfs(0, 0, i, j, i, j, n, map);
        }
        
        System.out.print(ans);

    }

    static void dfs(int sum, int dir, int x, int y, int original_x, int original_y, int n, int[][] map){

        if(dir>3 || x <0 || y<0 || x>=n || y>=n) return;

        if(dir==3 && x==original_x && y==original_y){
            ans= ans > sum? ans: sum;
            return;
        }

        dfs(sum+map[x][y], dir, x+dx[dir], y+dy[dir], original_x, original_y, n, map);
        dfs(sum+map[x][y], dir+1, x+dx[dir+1], y+dy[dir+1], original_x, original_y, n, map);
    }
}