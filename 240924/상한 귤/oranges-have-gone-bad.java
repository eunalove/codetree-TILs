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
        int k= Integer.parseInt(st.nextToken());

        int[][] map= new int[n][n];

        for(int i=0; i<n; i++){
            st= new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                map[i][j]= Integer.parseInt(st.nextToken());
            }
        }

        int[][] ans= bfs(n, map);

        StringBuilder sb= new StringBuilder();
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++)
                sb.append(ans[i][j]).append(" ");

            sb.append("\n");
        }

        System.out.print(sb);

    }

    static int[][] bfs(int n, int[][] map){

        Queue<Node> q= new ArrayDeque<>();
        boolean[][] vis= new boolean[n][n];

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++)
                if(map[i][j] == 2){
                    q.add(new Node(i, j, 0));
                    vis[i][j]= true;
                }
        }

        int[][] copy= new int[n][n];

        while(!q.isEmpty()){

            Node cur= q.poll();
            copy[cur.x][cur.y]= cur.dis;

            for(int i=0; i<4; i++){

                int nx= cur.x+ dx[i];
                int ny= cur.y+ dy[i];

                if(nx<0 || ny<0 || nx>=n || ny>=n || vis[nx][ny] || map[nx][ny] == 0) continue;
                vis[nx][ny]= true;
                q.add(new Node(nx, ny, cur.dis+1));

            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(map[i][j] == 0) copy[i][j]= -1;
                else if(!vis[i][j]) copy[i][j]= -2;
            }
        }

        return copy;

    }
}