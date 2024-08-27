//n과 m
import java.util.*;
import java.io.*;

public class Main {

    static int[] dx= {0, -1, 0, 1, 0};
    static int[] dy= {0, 0, 1, 0, -1};

    public static void main(String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t= Integer.parseInt(br.readLine());

        StringBuilder sb= new StringBuilder();

        while(t-->0){

        StringTokenizer st= new StringTokenizer(br.readLine());

        int n= Integer.parseInt(st.nextToken());
        int[][] map= new int[n][n];
        
        int m= Integer.parseInt(st.nextToken());

            while(m-->0){
                st= new StringTokenizer(br.readLine());

                int x= Integer.parseInt(st.nextToken()) -1;
                int y= Integer.parseInt(st.nextToken()) -1;

                int dir= -1;
                String str= st.nextToken();
                
                switch(str){
                    case "U" : dir= 1; break;
                    case "R" : dir= 2; break;
                    case "D" : dir= 3; break;
                    case "L" : dir= 4;
                }

                map[x][y]= dir;
            }

            int sum= n*n;
            while(sum --> 0) simul(n, map);
            
            
            int ans= 0;

            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++)
                    if(map[i][j]> 0) ans++;
            }

            sb.append(ans).append("\n");
        }

        System.out.print(sb);

    }

    static void simul(int n, int[][] map){
        
        int[][] copy= new int[n][n];

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){

                if(map[i][j] != 0){

                    int dir= map[i][j];
                    
                    int nx= i+dx[dir];
                    int ny= j+dy[dir];

                    if(nx <0 || ny<0 || nx>=n || ny>=n) {
                        if(dir ==2) dir= 4;
                        else dir= (dir+2)%4;

                        if(copy[i][j] == 0) copy[i][j]= dir;
                        else copy[i][j]= 0;

                        continue;
                    }
                        
                    if(copy[nx][ny] == 0) copy[nx][ny]= dir;
                    else copy[nx][ny]= 0;

                }
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++)
                map[i][j]= copy[i][j];
        }
    }
}