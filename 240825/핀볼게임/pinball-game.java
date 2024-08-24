import java.util.*;
import java.io.*;

public class Main {

    static int[] dx= {-1, 1, 0, 0};
    static int[] dy= {0, 0, -1, 1};

    static int ans= -1;

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

        for(int i=0; i<n; i++)
            simul(i, -1, 3, n, map);

        for(int i=0; i<n; i++)
            simul(i, n, 2, n, map);

        for(int j=0; j<n; j++)
            simul(-1, j, 1, n, map);
        
        for(int j=0; j<n; j++)
            simul(n, j, 0, n, map);

        System.out.print(ans);

    }

    static void simul(int x, int y, int dir, int n, int[][] map){

        int cnt= 0;

        while(true){

            cnt++;

            int nx= x+dx[dir];
            int ny= y+dy[dir];

            if(nx<0 || ny<0 || nx>=n || ny>=n){
                 ans= ans> cnt? ans: cnt;
                 break;
            }

            if(map[nx][ny] == 1){
                if(dir == 0) dir= 3;
                else if(dir == 1) dir= 2;
                else if(dir == 2) dir= 1;
                else dir= 0;
            }

            if(map[nx][ny] == 2){
                if(dir == 0) dir= 2;
                else if(dir == 1) dir= 3;
                else if(dir == 2) dir= 0;
                else dir= 1;
            }
            
            x= nx;
            y= ny;

        }
    }
}