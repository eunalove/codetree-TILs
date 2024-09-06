import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int arr[] = new int[n];
        boolean vis[] = new boolean[n + 1];
        permul(0, n, arr, vis);

        System.out.print(sb);
    }

    static void permul(int cur, int n, int[] arr, boolean[] vis){
        if(cur == n){
            for(int a : arr)
                sb.append(a).append(" ");
            sb.append("\n");
            return;
        }

        for(int i = 1; i <= n; i++){
            if(vis[i]) continue;
            vis[i] = true;
            arr[cur] = i;
            permul(cur + 1, n, arr, vis);
            vis[i] = false;
        }
    }
}