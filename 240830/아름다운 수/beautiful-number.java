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

            boolean flag= false;

            for(int i=0; i<arr.length; i+=arr[i]){
                if(i > n || i+arr[i] >n){
                    flag= true;
                    break;
                }
                for(int j=i; j<i+arr[i]; j++){
                    if(arr[i] != arr[j]){
                        flag= true;
                        break;
                    }
                }
            }

            if(!flag) ans++;

            return;
        }

        for(int i=1; i<=4; i++){
            arr[cnt]= i;
            dfs(cnt+1, arr, n);
        }
    }
}