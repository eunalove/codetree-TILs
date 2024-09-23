//n과 m
import java.util.*;
import java.io.*;

public class Main {

    static int ans= -1;
    static int[] dx= {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] dy= {1, 2, 2, 1, -1, -2, -2, -1};

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

        int n= Integer.parseInt(br.readLine());

        StringTokenizer st= new StringTokenizer(br.readLine());
        int sx= Integer.parseInt(st.nextToken()) -1;
        int sy= Integer.parseInt(st.nextToken()) -1;
        int ex= Integer.parseInt(st.nextToken()) -1;
        int ey= Integer.parseInt(st.nextToken()) -1;

        bfs(sx, sy, ex, ey, n);

        System.out.print(ans);

    }

    static void bfs(int sx, int sy, int ex, int ey, int n){

        Queue<Node> q= new ArrayDeque<>();
        boolean[][] vis= new boolean[n][n];

        q.add(new Node(sx, sy, 0));
        vis[sx][sy]= true;

        while(!q.isEmpty()){

            Node cur= q.poll();

            if(cur.x == ex && cur.y == ey){
                ans= cur.dis;
                break;
            }

            for(int i=0; i<8; i++){

                int nx= cur.x+ dx[i];
                int ny= cur.y+ dy[i];

                if(nx<0 || ny<0 || nx>=n || ny>=n || vis[nx][ny]) continue;

                vis[nx][ny]= true;
                q.add(new Node(nx, ny, cur.dis+1));

            }
        }
    }
}