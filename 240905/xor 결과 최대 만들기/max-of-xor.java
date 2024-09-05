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

        int[] arrM= new int[m];

        dfs(0, n, m, arrN, arrM);

        System.out.print(ans);

    }

    static void dfs(int cur, int n, int m, int[] arrN, int[] arrM){
        if(cur == m){
            int result= make_xor(arrM, m);
            ans= ans> result? ans: result;
            return;
        }

        for(int i=0; i<n; i++){
            arrM[cur]= arrN[i];
            dfs(cur+1, n, m, arrN, arrM);
        }
    }

    static int make_xor(int[] arrM, int m){

        int result= arrM[0];
        for(int i=1; i<m; i++)
            result ^= arrM[i];

        return result;
    }
}