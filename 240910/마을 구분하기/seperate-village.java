//n과 m
import java.util.*;
import java.io.*;

public class Main {

    static int[] dx= {-1, 1, 0, 0};
    static int[] dy= {0, 0, -1, 1};

    static int ans= 0;

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
        List<Integer> list= new ArrayList<>();
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(vis[i][j] || map[i][j] == 0) continue;
                ans= 0;
                dfs(i, j, n, vis, map);
                list.add(ans);
                
            }
        }

        StringBuilder sb= new StringBuilder();
        sb.append(list.size()).append("\n");

        Collections.sort(list);

        for(int l: list)
            sb.append(l).append("\n");

        System.out.print(sb);
    }

    static void dfs(int x, int y, int n, boolean[][] vis, int[][] map){

        vis[x][y]= true;
        ans++;
        
        for(int i=0; i<4; i++){
            int nx= x+ dx[i];
            int ny= y+ dy[i];

            if(nx < 0 || ny <0 || nx>=n || ny>=n || map[nx][ny] == 0 || vis[nx][ny]) continue;
            
            dfs(nx, ny, n, vis, map);
               
        }
    }
}