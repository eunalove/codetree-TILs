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
        int k= Integer.parseInt(st.nextToken());
        int m= Integer.parseInt(st.nextToken());

        
        int[][] map= new int[n][n];

        ArrayList<int[]> stones= new ArrayList<>();

        for(int i=0; i<n; i++){
            st= new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                map[i][j]= Integer.parseInt(st.nextToken());
                if(map[i][j] == 1) stones.add(new int[]{i, j});
            }
        }

        int start[][]= new int[k][2];
        for(int i=0; i<k; i++){
            st= new StringTokenizer(br.readLine());
            int x= Integer.parseInt(st.nextToken()) -1;
            int y= Integer.parseInt(st.nextToken()) -1;
            start[i][0]= x;
            start[i][1]= y;
        }

        int len= stones.size();

        int choose[]= new int[m];
        subSet(0, 0, n, m, k, len, choose, start, map, stones);

        System.out.print(ans);

    }

    static void subSet(int cur, int idx, int n, int m, int k, int len, int[] choose, int[][] start, int[][] map, ArrayList<int[]> stones){
        if(cur == m){

            int[][] copy= new int[n][n];

            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++)
                    copy[i][j]= map[i][j];
            }

            for(int i=0; i<m; i++){
                int[] stone= stones.get(choose[i]);
                copy[stone[0]][stone[1]]= 0;
            }
            
            boolean[][] vis= new boolean[n][n];
            
            for(int i=0; i<k; i++)
                bfs(start[i][0], start[i][1], n, copy, vis);

            int cnt= 0;

            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++)
                    if(vis[i][j]) cnt++;
            }

            ans= ans> cnt? ans: cnt;

            return;
        }

        if(idx >= len) return;

        subSet(cur, idx+1, n, m, k, len, choose, start, map, stones);

        choose[cur] = idx;
        subSet(cur+1, idx+1, n, m, k, len, choose, start, map, stones);
        
    }

    static void bfs(int x, int y, int n, int[][] map, boolean[][] vis){


        Queue<int[]> q= new ArrayDeque<>();
        q.add(new int[]{x, y});

        vis[x][y]= true;

        while(!q.isEmpty()){

            int cur[]= q.poll();

            for(int i=0; i<4; i++){
                int nx= cur[0] + dx[i];
                int ny= cur[1] + dy[i];

                if(nx<0 || ny<0 || nx>=n || ny >= n || map[nx][ny] == 1 || vis[nx][ny]) continue;

                vis[nx][ny]= true;
                q.add(new int[]{nx, ny});
            }
        }
    }
}