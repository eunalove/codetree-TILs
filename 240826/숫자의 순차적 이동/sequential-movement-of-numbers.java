//n과 m
import java.util.*;
import java.io.*;

public class Main {

    static int[] dx= {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy= {0, 1, 1, 1, 0, -1, -1, -1};

    public static void main(String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        int n= Integer.parseInt(st.nextToken());
        int m= Integer.parseInt(st.nextToken());

        int[][] map= new int[n][n];

        for(int i=0; i<n; i++){
            st= new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                map[i][j]= Integer.parseInt(st.nextToken());
            }
        }

        while(m --> 0){
            for(int i=1; i<= n*n; i++){
                int[] find= search(i, n, map);
                simul(find, n, map);
            }
        }

        StringBuilder sb= new StringBuilder();

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++)
                sb.append(map[i][j]).append(" ");

            sb.append("\n");
        }

        System.out.print(sb);

    }

    static int[] search(int target, int n, int[][]  map){

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++)
                if(map[i][j] == target) return new int[]{i, j};
        }

        return new int[]{-1, -1};
    }

    static void simul(int[] start, int n, int[][] map){

        int max= -1;
        int max_x= -1; int max_y= -1;

        for(int i=0; i<8; i++){

            int nx= start[0] + dx[i];
            int ny= start[1] + dy[i];

            if(nx<0 || ny<0 || nx>=n || ny>=n) continue;

            if(max < map[nx][ny]){
                max= map[nx][ny];
                max_x= nx;
                max_y= ny;
            }
        }

        int tmp= map[start[0]][start[1]];
        map[start[0]][start[1]]= map[max_x][max_y];
        map[max_x][max_y]= tmp;
    }
}