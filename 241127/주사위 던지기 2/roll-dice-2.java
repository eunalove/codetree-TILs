//n과 m
import java.util.*;
import java.io.*;

public class Main {

    static StringBuilder sb= new StringBuilder();

    public static void main(String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        int n= Integer.parseInt(st.nextToken());
        int m= Integer.parseInt(st.nextToken());

        int[] arr= new int[n];

        //중복순열
        permul(0, 0, n, m, arr);

        System.out.print(sb);

    }

    static void permul(int cur, int sum, int n, int m, int[] arr){

        if(sum > m) return;

        if(cur ==n){
            if(sum == m){
                for(int element: arr)
                    sb.append(element).append(" ");

                sb.append("\n");
            }

            return;
        }

        for(int i=1; i<=6; i++){
            arr[cur]= i;
            permul(cur+1, sum+i, n, m, arr);
        }

    }
}