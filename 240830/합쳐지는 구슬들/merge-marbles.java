//n과 m
import java.util.*;
import java.io.*;

public class Main {

    static class Pair{
        int num;
        int dir;
        int w;

        public Pair(int num, int dir, int w){
            this.num= num;
            this.dir= dir;
            this.w= w;
        }
    }

    static int[] dx= {-1, 0, 1, 0}; //상좌하우
    static int[] dy= {0, -1, 0, 1};

    public static void main(String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        int n= Integer.parseInt(st.nextToken());
        int m= Integer.parseInt(st.nextToken());
        int t= Integer.parseInt(st.nextToken());

        Pair[][] map= new Pair[n][n];

        int cnt= 0;
        for(int i=0; i<m; i++){
            st= new StringTokenizer(br.readLine());
            int x= Integer.parseInt(st.nextToken()) -1;
            int y= Integer.parseInt(st.nextToken()) -1;
            String str_dir= st.nextToken();
            int dir= -1;
            switch(str_dir){
                case "U": dir= 0; break;
                case "L": dir= 1; break;
                case "D": dir= 2; break;
                case "R": dir= 3;
            }

            int w= Integer.parseInt(st.nextToken());
            map[x][y]= new Pair(cnt++, dir, w);
        }

        while(t-->0) simul(n, map);
            
        cnt= 0; int maxW= 0;

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(map[i][j] != null){
                    cnt++;
                    maxW= maxW > map[i][j].w ? maxW: map[i][j].w;
                }
            }
        }

        System.out.print(cnt+" "+maxW);

    }

    static void simul(int n, Pair[][] map){
        
        Pair[][] copy= new Pair[n][n];

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(map[i][j] != null){

                    int num= map[i][j].num;
                    int dir= map[i][j].dir;
                    int w= map[i][j].w;

                    int nx= i+dx[dir];
                    int ny= j+dy[dir];

                    if(nx<0 || ny<0 || nx>=n || ny>=n){ //벽에 부딪힌 경우
                        dir= (dir+2)%4;
                        if(copy[i][j] == null) copy[i][j]= new Pair(num, dir, w);
                        else{
                            dir= num > copy[i][j].num? dir: copy[i][j].dir;
                            num= num > copy[i][j].num? num: copy[i][j].num;
                            copy[i][j] = new Pair(num, dir, w+copy[i][j].w);
                        }
                    }
                    else{
                        if(copy[nx][ny] == null) copy[nx][ny]= new Pair(num, dir, w);
                        else{
                            dir= num > copy[nx][ny].num? dir: copy[nx][ny].dir;
                            num= num > copy[nx][ny].num? num: copy[nx][ny].num;
                            copy[nx][ny] = new Pair(num, dir, w+copy[nx][ny].w);
                        }
                    }
                }
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                map[i][j]= copy[i][j];
            }
        }

    }

}