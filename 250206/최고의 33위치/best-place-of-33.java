import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n= Integer.parseInt(br.readLine());

        StringTokenizer st;
        int[][] map= new int[n][n];

        for(int i=0; i<n; i++){
            st= new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                map[i][j]= Integer.parseInt(st.nextToken());
            }
        }

        int ans= 0;

        for(int i=0; i<=n-3; i++){
            for(int j=0; j<=n-3; j++){
                int tmp= 0;
                for(int k=i; k<i+3; k++){
                    for(int l=j; l<j+3; l++)
                        tmp+= map[k][l];
                    
                }

                ans= ans > tmp ? ans: tmp;
            }

        }

        System.out.print(ans);
    }
}