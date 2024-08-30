import java.util.*;
import java.io.*;

public class Main {

    static int ans;

    public static void main(String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n= Integer.parseInt(br.readLine());
        int[] arr= new int[n];

        if(n==1) ans= 1;
        else dfs(0, arr, n);

        System.out.print(ans);
    }

    static void dfs(int cnt, int[] arr, int n){
        if(cnt == n){

            int same= 1;
            boolean flag= false;
            for(int i=0; i<arr.length -1; i++){
                if(arr[i] == arr[i+1]) same++;
                else{
                    if(same%arr[i] != 0){
                        flag= true;
                        break;
                    }
                    same= 1;
                }
            }

            if(same < arr[arr.length -1] || same%arr[arr.length -1] != 0) flag= true;

            if(!flag) ans++;

            return;
        }

        for(int i=1; i<=4; i++){
            arr[cnt]= i;
            dfs(cnt+1, arr, n);
        }
    }
}