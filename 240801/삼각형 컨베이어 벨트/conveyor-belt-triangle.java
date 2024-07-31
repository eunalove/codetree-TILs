//n과 m
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        int n= Integer.parseInt(st.nextToken());
        int t= Integer.parseInt(st.nextToken());

        int[] belt= new int[3*n];
        int[] ans= new int[3*n];

        for(int i=0; i<3; i++){
            st= new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++)
                belt[i*n+j]= Integer.parseInt(st.nextToken());
        }
        
        n*=3;
        t%=n;

        for(int i=0; i<n; i++){
            ans[i]= belt[(n- t +i)%n];
        }

        StringBuilder sb= new StringBuilder();

        int idx=1;
        n/=3;
        for(int i=0; i<n*3; i++){
            if(idx%n == 0) sb.append(ans[i]).append("\n");
            else sb.append(ans[i]).append(" ");
            idx++;
        }

        System.out.print(sb);

    }
}