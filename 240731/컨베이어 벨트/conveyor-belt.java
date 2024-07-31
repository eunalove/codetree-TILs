//n과 m
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        int n= Integer.parseInt(st.nextToken());
        int t= Integer.parseInt(st.nextToken());

        int[] belt= new int[n*2];

        st= new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++)
            belt[i]= Integer.parseInt(st.nextToken());
        
        st= new StringTokenizer(br.readLine());
        for(int i=n; i<n*2; i++)
            belt[i]= Integer.parseInt(st.nextToken());

        while(t-->0){
            for(int i=1; i<n*2; i++)
                swap(0, i, belt);
        }

        StringBuilder sb= new StringBuilder();

        for(int i=0; i<n*2-1; i++){
            if(i== n-1) sb.append(belt[i]).append("\n");
            else sb.append(belt[i]).append(" ");
        }
            
        sb.append(belt[n*2-1]).append("\n");
        System.out.print(sb);
    }

    static void swap(int a, int b, int[] arr){
        int tmp= arr[a];
        arr[a]= arr[b];
        arr[b]= tmp;
    }
}