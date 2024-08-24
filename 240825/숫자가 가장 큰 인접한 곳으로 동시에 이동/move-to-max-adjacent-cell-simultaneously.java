import java.util.*;
import java.io.*;

public class Main {

    // 상, 하, 좌, 우 방향을 나타내는 배열
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // n: 격자의 크기, m: 구슬의 개수, t: 시간
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        // 격자 정보
        int[][] map = new int[n][n];

        // 격자 정보를 입력받음
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 구슬 위치 정보
        int[][] bead = new int[n][n];

        // 구슬의 시작 위치를 입력받아 초기화
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            bead[x][y] = 1;
        }

        // t초 동안 시뮬레이션 수행
        simulate(t, n, map, bead);

    }

    static void simulate(int t, int n, int[][] map, int[][] bead) {

        while (t-- > 0) {
            // 다음 위치의 구슬 개수를 저장할 임시 배열
            int[][] nextBead = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    // 현재 위치에 구슬이 없으면 무시
                    if (bead[i][j] == 0) continue;

                    int bx = i;
                    int by = j;

                    // 상하좌우 방향으로 가장 큰 값을 찾음
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];

                        if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;

                        // 우선순위에 따라 최적의 위치를 선택
                        if (map[bx][by] < map[nx][ny]) {
                            bx = nx;
                            by = ny;
                        }
                    }

                    // 구슬 이동
                    nextBead[bx][by]++;
                }
            }

            // 구슬 충돌 처리
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (nextBead[i][j] > 1) {
                        nextBead[i][j] = 0; // 충돌한 위치는 구슬이 모두 사라짐
                    }
                }
            }

            // 현재 구슬 위치를 업데이트
            bead = nextBead;
        }

        // 남아있는 구슬 수를 셈
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (bead[i][j] > 0) ans++;
            }
        }

        System.out.print(ans);
    }
}