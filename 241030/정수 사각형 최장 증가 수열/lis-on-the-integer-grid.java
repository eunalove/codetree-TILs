import java.util.*;
import java.io.*;

class Cell{
    int x, y, num;

    public Cell(int x, int y, int num){
        this.x= x;
        this.y= y;
        this.num= num;
    }
}

public class Main {
    
    static int[] dx= {-1, 1, 0, 0};
    static int[] dy= {0, 0, -1, 1};

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

        List<Cell> cells= new ArrayList<>();

        for(int i=0; i<n; i++)
            for(int j=0; j<n; j++)
                cells.add(new Cell(i, j, map[i][j]));
        
        Collections.sort(cells, (c1, c2)->{
            return c1.num- c2.num;
        });

        int[][] dp= new int[n][n];

        for(Cell cell: cells){
            int x= cell.x;
            int y= cell.y;
            int num= cell.num;

            for(int k=0; k<4; k++){
                int nx= x+ dx[k];
                int ny= y+ dy[k];

                if(nx<0 || ny<0 || nx>=n || ny>=n) continue;

                if(map[x][y] < map[nx][ny])
                    dp[nx][ny]= Math.max(dp[nx][ny], dp[x][y]+1);
                }
        }


        int ans= 0;

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++)
                ans= ans> dp[i][j] ? ans: dp[i][j];
        }

        System.out.print(ans+1);

    }
}