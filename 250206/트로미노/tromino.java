import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n + 2][m + 2];

        // 경계값을 Integer.MIN_VALUE로 초기화
        for(int i = 0; i < n + 2; i++){
            for(int j = 0; j < m + 2; j++){
                map[i][j] = Integer.MIN_VALUE;
            }
        }

        // 실제 값 입력
        for(int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 0; // 결과값을 가장 작은 값으로 초기화

        // 가능한 모든 3칸 조합 확인
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){

                int max = 0;
                

                max = Math.max(max, map[i-1][j] + map[i][j+1] + map[i][j]); // 위 + 오른쪽
                max = Math.max(max, map[i+1][j] + map[i][j+1] + map[i][j]); // 아래 + 오른쪽
                max = Math.max(max, map[i-1][j] + map[i][j-1] + map[i][j]); // 위 + 왼쪽
                max = Math.max(max, map[i+1][j] + map[i][j-1] + map[i][j]); // 아래 + 왼쪽
                max = Math.max(max, map[i+1][j] + map[i-1][j] + map[i][j]); // 위 + 아래
                max = Math.max(max, map[i][j-1] + map[i][j+1] + map[i][j]); // 왼쪽 + 오른쪽

                ans = Math.max(ans, max);
            }
        }

        System.out.print(ans);
    }
}
