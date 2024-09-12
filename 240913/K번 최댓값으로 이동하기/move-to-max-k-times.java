//n과 m
import java.util.*;
import java.io.*;

public class Main {

    static int[] dx= {-1, 1, 0, 0}; //상하좌우
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

        st= new StringTokenizer(br.readLine());
        int x= Integer.parseInt(st.nextToken()) -1;
        int y= Integer.parseInt(st.nextToken()) -1;

        boolean[][] vis;
        int[] cur= new int[]{x, y};

        for(int i=0; i<k; i++) cur= bfs(cur[0], cur[1], n, map);
        

        cur[0]++;
        cur[1]++;

        System.out.print(cur[0]+" "+cur[1]);

    }

    static int[] bfs(int x, int y, int n, int[][] map){

        Queue<int[]> q= new ArrayDeque();
        q.add(new int[]{x, y});

        boolean[][] vis= new boolean[n][n];
        vis[x][y]= true;
        int ex= x; int ey= y;
        int max= -1;

        while(!q.isEmpty()){

            int[] cur= q.poll();

            for(int i=0; i<4; i++){
                int nx= cur[0]+ dx[i];
                int ny= cur[1]+ dy[i];

                if(nx<0 || ny<0 || nx>=n || ny>=n || vis[nx][ny] || map[nx][ny] >= map[x][y]) continue;

                max= max > map[nx][ny]? max: map[nx][ny];
                vis[nx][ny]= true;
                q.add(new int[]{nx, ny});

            }
        }

        Loop: for(int i=0; i<n; i++){
            for(int j=0; j<n; j++)
                if(map[i][j] == max){
                    ex= i;
                    ey= j;
                    break Loop;
                } 
        }

        return new int[]{ex, ey};

    }
}