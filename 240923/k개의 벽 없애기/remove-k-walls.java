//n과 m
import java.util.*;
import java.io.*;

public class Main {

    static int ans= -1;
    static int n, k, sx, sy, ex, ey;
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

        n= Integer.parseInt(st.nextToken());
        k= Integer.parseInt(st.nextToken());

        int[][] map= new int[n][n];

        ArrayList<int[]> walls= new ArrayList<>();

        for(int i=0; i<n; i++){
            st= new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                map[i][j]= Integer.parseInt(st.nextToken());
                if(map[i][j] == 1) walls.add(new int[]{i, j});
            }
        }

        st= new StringTokenizer(br.readLine());
        sx= Integer.parseInt(st.nextToken()) -1;
        sy= Integer.parseInt(st.nextToken()) -1;

        st= new StringTokenizer(br.readLine());
        ex= Integer.parseInt(st.nextToken()) -1;
        ey= Integer.parseInt(st.nextToken()) -1;

        int[][] select= new int[k][2];
        subSet(0, 0, select, map, walls);

        System.out.print(ans);

    }

    static void subSet(int cur, int idx, int[][] select, int[][] map, ArrayList<int[]> walls){

        if(cur == k){
            bfs(select, map);
            return;
        }

        if(idx == walls.size()) return;

        select[cur][0]= walls.get(idx)[0];
        select[cur][1]= walls.get(idx)[1];
        subSet(cur+1, idx+1, select, map, walls);
        subSet(cur, idx+1, select, map, walls);

    }

    static void bfs(int[][] select, int[][] map){

        int[][] copy= new int[n][n];

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++)
                copy[i][j]= map[i][j];
        }

        for(int i=0; i<k; i++)
            copy[select[i][0]][select[i][1]]= 0;

        Queue<Node> q= new ArrayDeque<>();
        boolean[][] vis= new boolean[n][n];

        q.add(new Node(sx, sy, 0));
        vis[sx][sy]= true;

        while(!q.isEmpty()){

            Node cur= q.poll();

            if(cur.x == ex && cur.y == ey){
                ans= ans> cur.dis? ans: cur.dis;
                return;
            }

            for(int i=0; i<4; i++){

                int nx= cur.x+ dx[i];
                int ny= cur.y+ dy[i];

                if(nx<0 || ny<0 || nx>=n || ny>=n || vis[nx][ny] || copy[nx][ny] == 1) continue;

                vis[nx][ny]= true;
                q.add(new Node(nx, ny, cur.dis+1));

            }
        }
    }
}