//n과 m
import java.util.*;
import java.io.*;

public class Main {

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
        int h= Integer.parseInt(st.nextToken());
        int m= Integer.parseInt(st.nextToken());

        int[][] map= new int[n][n];

        for(int i=0; i<n; i++){
            st= new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                map[i][j]= Integer.parseInt(st.nextToken());
            }
        }

        int[][] ans= new int[n][n];

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++)
                if(map[i][j] == 2) bfs(i, j, n, map, ans);
            
        }

        StringBuilder sb= new StringBuilder();

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++)
                sb.append(ans[i][j]).append(" ");
            
            sb.append("\n");
        }

        System.out.print(sb);

    }

    static void bfs(int sx, int sy, int n, int[][] map, int[][] ans){

        Queue<Node> q= new ArrayDeque<>();
        boolean[][] vis= new boolean[n][n];

        boolean flag= false;

        q.add(new Node(sx, sy, 0));
        vis[sx][sy]= true;

        while(!q.isEmpty()){

            Node cur= q.poll();

            if(map[cur.x][cur.y] == 3){
                ans[sx][sy]= cur.dis;
                flag= true;
                break;
            }

            for(int i=0; i<4; i++){

                int nx= cur.x+ dx[i];
                int ny= cur.y+ dy[i];

                if(nx<0 || ny<0 || nx>=n || ny>=n || vis[nx][ny] || map[nx][ny] == 1) continue;

                vis[nx][ny]= true;
                q.add(new Node(nx, ny, cur.dis+1));

            }
        }

        if(!flag) ans[sx][sy]= -1;
    }
}