//n과 m
import java.util.*;
import java.io.*;

public class Main {
    static int[] dx= {-1, 1, 0, 0};
    static int[] dy= {0, 0, -1, 1};
    static int ans= 0;

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

        Queue<int[]> q= new ArrayDeque();
        q.add(new int[]{0,0});

        boolean[][] vis= new boolean[n][m];

        while(!q.isEmpty()){

            int[] cur= q.poll();

            if(cur[0] == n-1 && cur[1] == m-1){
                ans= 1;
                break;
            }

            vis[cur[0]][cur[1]]= true;

            for(int i=0; i<4; i++){

                int nx= cur[0] + dx[i];
                int ny= cur[1] + dy[i];

                if(nx <0 || ny<0 || nx>=n || ny>=m || map[nx][ny] == 0 || vis[nx][ny]) continue;

                q.add(new int[]{nx, ny});
            }
        }

        System.out.print(ans);

    }
}