//n과 m
import java.util.*;
import java.io.*;

public class Main {

    static int ans= -1;
    static int[] dx= {-1, 1, 0, 0};
    static int[] dy= {0, 0, -1, 1};

    static class Node{
        int x; int y; int dis;

        public Node(int x, int y, int dis){
            this.x= x;
            this.y= y;
            this.dis= dis;
        }
    }

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

        bfs(n, m, map);

        System.out.print(ans);

    }

    static void bfs(int n, int m, int[][] map){

        Queue<Node> q= new ArrayDeque<>();
        boolean[][] vis= new boolean[n][m];

        q.add(new Node(0, 0, 0));
        vis[0][0]= true;

        while(!q.isEmpty()){

            Node cur= q.poll();

            if(cur.x == n-1 && cur.y == m-1){
                ans= cur.dis;
                break;
            }

            for(int i=0; i<4; i++){

                int nx= cur.x+ dx[i];
                int ny= cur.y+ dy[i];

                if(nx<0 || ny<0 || nx>=n || ny>=m || vis[nx][ny] || map[nx][ny] == 0) continue;

                vis[nx][ny]= true;
                q.add(new Node(nx, ny, cur.dis+1));

            }
        }
    }
}