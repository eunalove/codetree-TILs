//n과 m
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        int n= Integer.parseInt(st.nextToken());
        int t= Integer.parseInt(st.nextToken());

        n*=2;

        int[] belt= new int[n];
        int[] ans= new int[n];

        st= new StringTokenizer(br.readLine());
        for(int i=0; i<n/2; i++)
            belt[i]= Integer.parseInt(st.nextToken());
        
        st= new StringTokenizer(br.readLine());
        for(int i=n/2; i<n; i++)
            belt[i]= Integer.parseInt(st.nextToken());

        t%=n;
        for(int i=0; i<n; i++)
            ans[i]= belt[(n-t+i)%n];

        StringBuilder sb= new StringBuilder();

        for(int i=0; i<n; i++){
            if(i== n/2 -1) sb.append(ans[i]).append("\n");
            else sb.append(ans[i]).append(" ");
        }

        System.out.print(sb);
    }
}