//n과 m
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        int n= Integer.parseInt(st.nextToken());
        int m= Integer.parseInt(st.nextToken());

        int[][] map= new int[n][n];

        for(int i=0; i<n; i++){
            st= new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                map[i][j]= Integer.parseInt(st.nextToken());
            }
        }

        int ans= 0;

        for(int i=0; i<n; i++){
            int seq= 1;
            int longst= 1;
            for(int j=0; j<n-1; j++){
                if(map[i][j] == map[i][j+1]) seq++;
                else{
                    longst= seq > longst? seq: longst;
                    seq= 1;
                }
            }

        longst= seq > longst? seq: longst;
        if(longst >= m) ans++;
        }

        for(int j=0; j<n; j++){
            int seq= 1;
            int longst= 1;
            for(int i=0; i<n-1; i++){
                if(map[i][j] == map[i+1][j]) seq++;
                else{ 
                    longst= seq > longst? seq: longst;
                    seq= 1;
                }
            }

        longst= seq > longst? seq: longst;
        if(longst >= m) ans++;
        }

        System.out.print(ans);

    }
}