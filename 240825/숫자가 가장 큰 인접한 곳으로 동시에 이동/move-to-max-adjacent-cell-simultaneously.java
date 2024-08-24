//n과 m
import java.util.*;
import java.io.*;

public class Main {

    static int[] dx= {-1, 1, 0, 0};
    static int[] dy= {0, 0, -1, 1};

    public static void main(String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        int n= Integer.parseInt(st.nextToken());
        int m= Integer.parseInt(st.nextToken());
        int t= Integer.parseInt(st.nextToken());

        int[][] map= new int[n][n];

        for(int i=0; i<n; i++){
            st= new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                map[i][j]= Integer.parseInt(st.nextToken());
            }
        }

        int[][] bead= new int[n][n];

        for(int i=0; i<m; i++){
            st= new StringTokenizer(br.readLine());
            int x= Integer.parseInt(st.nextToken()) -1;
            int y= Integer.parseInt(st.nextToken()) -1;
            bead[x][y]= 1;
        }

        simul(t, n, map, bead);

    }

    static void simul(int t, int n, int[][] map, int[][] bead){

        while(t-->0){

            int[][] nextBead= new int[n][n];

            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if(bead[i][j] == 0) continue;

                    int bx= -1; int by= -1;

                    for(int k=0; k<4; k++){
                        int nx= i+dx[k];
                        int ny= j+dy[k];

                        if(nx<0 || ny<0 || nx>=n || ny>=n) continue;

                        if(bx == -1){
                            bx= nx;
                            by= ny;
                        }else if(map[bx][by] < map[nx][ny]){
                            bx= nx;
                            by= ny;
                        }

                    }

                    nextBead[bx][by]++;

                }
            }         

            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++)
                    if(nextBead[i][j] >1) nextBead[i][j] =0;
                
            }

            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++)
                    bead[i][j]= nextBead[i][j];
            }

        }

        int ans= 0;

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++)
                if(bead[i][j] >0) ans++;
        }

        System.out.print(ans);
    }
}