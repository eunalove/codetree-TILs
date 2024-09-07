//n과 m
import java.util.*;
import java.io.*;

public class Main {
    static int ans= Integer.MAX_VALUE;

    public static void main(String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        int n= Integer.parseInt(st.nextToken());
        int m= Integer.parseInt(st.nextToken());

        int[][] map= new int[n][2];
        int[][] choose= new int[m][2];

        for(int i=0; i<n; i++){
            st= new StringTokenizer(br.readLine());
            map[i][0]= Integer.parseInt(st.nextToken());
            map[i][1]= Integer.parseInt(st.nextToken());
        }

        subset(0, 0, n, m, choose, map);

        System.out.print(ans);
    }

    static void subset(int cur, int idx, int n, int m, int[][] choose, int[][] map){
        if(cur == m){
            int max =0;

            for(int i=0; i<m; i++){
                for(int j=i+1; j<m; j++)
                    max= Math.max(max, distance(i,j, choose));
            }

            ans= Math.min(ans, max);

            return;
        }

        if(idx >= n) return;

        choose[cur][0]= map[idx][0];
        choose[cur][1]= map[idx][1];
        
        subset(cur+1, idx+1, n, m, choose, map);
        subset(cur, idx+1, n, m, choose, map);
        
    }

    static int distance(int i, int j, int[][] choose){
        int dis= (choose[i][0] - choose[j][0])*(choose[i][0] - choose[j][0]) + (choose[i][1] - choose[j][1])*(choose[i][1] - choose[j][1]);
        return dis;
    }
}