//n과 m
import java.util.*;
import java.io.*;

public class Main {
    static int ans;

    public static void main(String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        int n= Integer.parseInt(st.nextToken());
        int m= Integer.parseInt(st.nextToken());
        int k= Integer.parseInt(st.nextToken());

        int[] score= new int[n]; 
        st= new StringTokenizer(br.readLine());

        for(int i=0; i<n; i++)
            score[i]= Integer.parseInt(st.nextToken());

        int[] horse= new int[k];

        dfs(0, n, m, k, score, horse);

        System.out.print(ans);

    }

    static void dfs(int cur, int n, int m, int k, int[] score, int[] horse){
        
        if(cur == n){

            int cnt = 0;
            for(int h: horse)
                if(h >= m -1) cnt++;

            ans= ans > cnt? ans:cnt;

            return;
        }

        for(int i=0; i<k; i++){
            horse[i] += score[cur];
            dfs(cur+1, n, m, k, score, horse);
            horse[i] -= score[cur];
        }
    }
}