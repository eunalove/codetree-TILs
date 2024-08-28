//n과 m
import java.util.*;
import java.io.*;

public class Main {

    static StringBuilder sb= new StringBuilder();

    public static void main(String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        int k= Integer.parseInt(st.nextToken());
        int n= Integer.parseInt(st.nextToken());

        int[] ans= new int[n];
        dfs(0, k, n, ans);

        System.out.print(sb);

    }

    static void dfs(int cnt, int k, int n, int[] ans){

        if(cnt == n){
            for(int tmp: ans)
                sb.append(tmp).append(" ");

            sb.append("\n");
            return;
        }

        for(int i=1; i<=k; i++){
            ans[cnt]= i;
            dfs(cnt+1, k, n, ans);
        }
    }
}