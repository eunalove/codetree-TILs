import java.util.*;
import java.io.*;

public class Main {

    // 방향 벡터: U(1), R(2), D(3), L(4)
    static int[] dx = {0, -1, 0, 1, 0}; // U(1), R(2), D(3), L(4)
    static int[] dy = {0, 0, 1, 0, -1};
    static final int COLLIDE = -2; // 충돌을 나타내는 상수
    static final int BLANK = 0; // 빈 공간을 나타내는 상수

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[][] map = new int[n][n];

            int m = Integer.parseInt(st.nextToken());

            while (m-- > 0) {
                st = new StringTokenizer(br.readLine());

                int x = Integer.parseInt(st.nextToken()) - 1;
                int y = Integer.parseInt(st.nextToken()) - 1;

                int dir = -1;
                String str = st.nextToken();

                switch (str) {
                    case "U": dir = 1; break;
                    case "R": dir = 2; break;
                    case "D": dir = 3; break;
                    case "L": dir = 4; break;
                }

                map[x][y] = dir;
            }

            // 2*n번만 시뮬레이션 진행
            for (int i = 0; i < 2 * n; i++) {
                simul(n, map);
            }

            // 결과 계산
            int ans = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j] > 0) ans++;
                }
            }

            sb.append(ans).append("\n");
        }

        System.out.print(sb);
    }

    static void simul(int n, int[][] map) {

        int[][] copy = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (map[i][j] != BLANK) {

                    int dir = map[i][j];

                    int nx = i + dx[dir];
                    int ny = j + dy[dir];

                    if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
                        // 벽에 부딪힌 경우: 반대 방향으로 전환
                        dir = (dir == 2) ? 4 : (dir == 4) ? 2 : (dir == 1) ? 3 : 1;
                        nx = i; ny = j;
                    }

                    // 새로운 위치에 구슬 추가
                    if (copy[nx][ny] == BLANK) {
                        copy[nx][ny] = dir;
                    } else {
                        copy[nx][ny] = COLLIDE; // 충돌 발생
                    }
                }
            }
        }

        // 충돌 처리 및 맵 업데이트
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (copy[i][j] == COLLIDE) {
                    map[i][j] = BLANK; // 충돌된 구슬 제거
                } else {
                    map[i][j] = copy[i][j]; // 새 상태로 업데이트
                }
            }
        }
    }
}