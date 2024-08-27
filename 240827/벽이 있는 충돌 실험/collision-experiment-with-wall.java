import java.util.*;
import java.io.*;

public class Main {

    static int[] dx = {0, -1, 0, 1, 0}; // U, R, D, L 순으로 이동
    static int[] dy = {0, 0, 1, 0, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int[][] map = new int[n][n];
            int[][] direction = new int[n][n];  // 각 구슬의 방향을 저장하는 배열

            int m = Integer.parseInt(st.nextToken());

            while (m-- > 0) {
                st = new StringTokenizer(br.readLine());

                int x = Integer.parseInt(st.nextToken()) - 1;
                int y = Integer.parseInt(st.nextToken()) - 1;

                int dir = -1;
                String str = st.nextToken();

                switch (str) {
                    case "U" : dir = 1; break;
                    case "R" : dir = 2; break;
                    case "D" : dir = 3; break;
                    case "L" : dir = 4; break;
                }

                map[x][y] = 1;  // 구슬이 있는 위치 표시
                direction[x][y] = dir;  // 구슬의 방향 저장
            }

            int sum = n * n * n;  // 충분히 큰 수로 시뮬레이션 진행
            while (sum-- > 0) simul(n, map, direction);

            int ans = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j] > 0) ans++;
                }
            }

            System.out.println(ans);
        }
    }

    static void simul(int n, int[][] map, int[][] direction) {

        int[][] newMap = new int[n][n];
        int[][] newDirection = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (map[i][j] != 0) {

                    int dir = direction[i][j];

                    int nx = i + dx[dir];
                    int ny = j + dy[dir];

                    if (nx < 0 || ny < 0 || nx >= n || ny >= n) {  // 벽에 부딪힌 경우
                        dir = reverseDirection(dir);
                        nx = i;
                        ny = j;
                    }

                    if (newMap[nx][ny] == 0) {
                        newMap[nx][ny] = 1;
                        newDirection[nx][ny] = dir;
                    } else {
                        newMap[nx][ny] = 0;  // 충돌이 일어나면 구슬을 제거
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = newMap[i][j];
                direction[i][j] = newDirection[i][j];
            }
        }
    }

    static int reverseDirection(int dir) {
        if (dir == 1) return 3;  // U -> D
        if (dir == 3) return 1;  // D -> U
        if (dir == 2) return 4;  // R -> L
        if (dir == 4) return 2;  // L -> R
        return -1;
    }
}