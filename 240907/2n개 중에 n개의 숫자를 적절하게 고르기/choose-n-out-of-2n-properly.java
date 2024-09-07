import java.util.*;
import java.io.*;

public class Main {
    static int ans= Integer.MAX_VALUE;

    public static void main(String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n= Integer.parseInt(br.readLine());

        int[] arr= new int[n*2];
        int total= 0;

        StringTokenizer st= new StringTokenizer(br.readLine());
        for(int i=0; i<n*2; i++){
            arr[i]= Integer.parseInt(st.nextToken());
            total += arr[i];
        }

        subset(0, 0, 0, n, total, arr);

        System.out.print(ans);

    }

    static void subset(int cur, int idx, int one, int n, int total, int[] arr){
        if(cur == n){
            
            int other= total - one;
            int diff= Math.abs(one - other);

            ans= ans> diff? diff: ans;
            return;
        }

        if(idx >= n*2) return;

        //선택했을 때
        subset(cur+1, idx+1, one+arr[idx], n, total, arr);

        //선택안했을 때
        subset(cur, idx+1, one, n, total, arr);
    }
    
}