import java.util.*;
import java.io.*;

public class Main {
    static int ans=Integer.MAX_VALUE;

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

        int[] arr= new int[n];
        boolean[] vis= new boolean[n];

        permul(0, n, arr, vis, map);

        System.out.print(ans);

    }

    static void permul(int cur, int n, int[] arr, boolean[] vis, int[][] map){
        if(cur == n){

            int tmp= 0;
            for(int i=0; i<n-1; i++){
                if(map[arr[i]][arr[i+1]] == 0) return;
                tmp+= map[arr[i]][arr[i+1]];
            }

            if(map[arr[n-1]][arr[0]] == 0) return;
            tmp+= map[arr[n-1]][arr[0]];

            ans= Math.min(ans, tmp);
            return;
        }

        for(int i=0; i<n; i++){
            if(vis[i]) continue;

            vis[i]= true;
            arr[cur]= i;
            permul(cur+1, n, arr, vis, map);
            vis[i]= false;
        }
    }
}