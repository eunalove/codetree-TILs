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

        int[] arr= new int[n];
        dfs(0, k, n, arr);

        System.out.print(sb);

    }

    static void dfs(int cur, int k, int n, int[] arr){
        if(cur ==n){

            boolean flag= false;
            if(n >=3){
            for(int i=0; i<=n-3; i+=3){
                if(arr[i] == arr[i+1] && arr[i] == arr[i+2]){
                    flag= true;
                    break;
                    }
                }
            }

            if(!flag){
                for(int a: arr)
                    sb.append(a).append(" ");

                sb.append("\n");
            }
            return;
        }

        for(int i=1; i<=k; i++){
            arr[cur]= i;
            dfs(cur+1, k, n, arr);
        }
    }
}