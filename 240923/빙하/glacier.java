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
        int m= Integer.parseInt(st.nextToken());

        int[][] map= new int[n][m];

        for(int i=0; i<n; i++){
            st= new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                map[i][j]= Integer.parseInt(st.nextToken());
            }
        }

        int[] cnt={-1, -1}; 
        int ans= 0;

        while(cnt[1] != 0){
            ans++;
            cnt= bfs(n, m, map);
        }

        System.out.print(ans+" "+cnt[0]);

    }

    static int[] bfs(int n, int m, int[][] map){

        int tmp= 0;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++)
                tmp+= map[i][j];
        }

        Queue<int[]> q= new ArrayDeque<>();
        boolean[][] vis= new boolean[n][m];

        q.add(new int[]{0,0});
        vis[0][0]= true;

        while(!q.isEmpty()){

            int[] cur= q.poll();

            for(int i=0; i<4; i++){

                int nx= cur[0]+ dx[i];
                int ny= cur[1]+ dy[i];

                if(nx<0 || ny<0 || nx>=n || ny>=m || vis[nx][ny]) continue;

                vis[nx][ny]= true;

                if(map[nx][ny] == 0) q.add(new int[]{nx, ny});
                else map[nx][ny]= 0;
            }
        }

        int cnt= 0;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++)
                cnt += map[i][j];
        }

        return new int[]{tmp, cnt};
    }
}