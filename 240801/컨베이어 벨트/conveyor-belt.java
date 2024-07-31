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
        int[] ans= new int[n*2];

        st= new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++)
            belt[i]= Integer.parseInt(st.nextToken());
        
        st= new StringTokenizer(br.readLine());
        for(int i=n; i<2*n; i++)
            belt[i]= Integer.parseInt(st.nextToken());
        
        t%=n;
        for(int i=0; i<2*n; i++)
            ans[(i+t)%(2*n)]= belt[i];

        StringBuilder sb= new StringBuilder();

        for(int i=0; i<n*2; i++){
            if(i== n-1) sb.append(ans[i]).append("\n");
            else sb.append(ans[i]).append(" ");
        }

        System.out.print(sb);
    }
}