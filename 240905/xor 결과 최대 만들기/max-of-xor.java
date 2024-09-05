//n과 m
import java.util.*;
import java.io.*;

public class Main {
    static int ans= 0;

    public static void main(String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        int n= Integer.parseInt(st.nextToken());//5
        int m= Integer.parseInt(st.nextToken());//3

        int[] arrN= new int[n];
        st= new StringTokenizer(br.readLine());

        for(int i=0; i<n; i++)
            arrN[i]= Integer.parseInt(st.nextToken());

        dfs(0, 0, 0, n, m, arrN);

        System.out.print(ans);

    }

    static void dfs(int cur, int idx, int cnt, int n, int m, int[] arrN){

        if(idx >= n) return;

        if(cur == m){
            ans= ans> cnt? ans: cnt;
            return;
        }

        dfs(cur, idx+1, cnt, n, m, arrN);
        dfs(cur+1, idx+1, cnt^arrN[idx], n, m, arrN);

    }
}