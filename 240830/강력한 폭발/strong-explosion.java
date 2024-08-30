import java.util.*;
import java.io.*;

public class Main {

    static int[] dx= {-2, -1, 0, 1, 2,  -1, 1, 0, 0, 0,  -1, -1, 0, 1, 1};
    static int[] dy= {0, 0, 0, 0, 0,    0, 0, 0, -1, 1  , -1, 1, 0, -1, 1};
    static int ans;
    
    public static void main(String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n= Integer.parseInt(br.readLine());

        StringTokenizer st;
        int[][] map= new int[n][n];

        ArrayList<int[]> bombs= new ArrayList<>();

        for(int i=0; i<n; i++){
            st= new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                map[i][j]= Integer.parseInt(st.nextToken());
                if(map[i][j] == 1) bombs.add(new int[]{i,j});
            }
        }

        int[] arr= new int[bombs.size()];

        dfs(0, bombs.size(), n, arr, bombs);

        System.out.print(ans);

    }

    static void dfs(int cnt, int len, int n, int[]arr, ArrayList<int[]> bombs){

        if(cnt == len){

            int[][] copy= new int[n][n];

            for(int i=0; i<len; i++){
                int[] target= bombs.get(i);

                for(int j=arr[i]*5; j<arr[i]*5+5; j++){

                    int nx= dx[j]+ target[0];
                    int ny= dy[j]+ target[1];

                    if(nx<0 || ny<0 || nx>=n || ny>=n) continue;

                    copy[nx][ny]= 1;
                }
            }

            int tmp= 0;

            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++)
                    if(copy[i][j] == 1) tmp++;
            }

            ans= ans> tmp? ans: tmp;

            return;

        }

        for(int i=0; i<3; i++){
            arr[cnt]= i;
            dfs(cnt+1, len, n, arr, bombs);
        }
    }
}