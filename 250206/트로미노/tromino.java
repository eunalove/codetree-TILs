//n과 m
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        int n= Integer.parseInt(st.nextToken());
        int m= Integer.parseInt(st.nextToken());

        int[][] map= new int[n+2][m+2];

        for(int i=0; i<n+2; i++){
            for(int j=0; j<m+2; j++){
                map[i][j]= Integer.MIN_VALUE;
            }
        }

        for(int i=1; i<=n; i++){
            st= new StringTokenizer(br.readLine());
            for(int j=1; j<=m; j++){
                map[i][j]= Integer.parseInt(st.nextToken());
            }
        }

        int ans= 0;

        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){

                int max= 0;
                max= map[i-1][j]+ map[i][j+1] +map[i][j] > max? map[i-1][j]+ map[i][j+1]+map[i][j] : max;
                max= map[i+1][j]+ map[i][j+1] +map[i][j]> max? map[i+1][j]+ map[i][j+1]+map[i][j] : max;
                max= map[i-1][j]+ map[i][j-1] +map[i][j]> max? map[i-1][j]+ map[i][j-1]+map[i][j] : max;
                max= map[i-1][j]+ map[i][j-1] +map[i][j]> max? map[i-1][j]+ map[i][j-1]+map[i][j] : max;
                max= map[i+1][j]+ map[i-1][j] +map[i][j]> max? map[i+1][j]+ map[i-1][j]+map[i][j] : max;
                max= map[i][j-1]+ map[i][j+1] +map[i][j]> max? map[i][j-1]+ map[i][j+1]+map[i][j] : max;

                ans= ans> max? ans: max;

            }
        }

        System.out.print(ans);

    }
}