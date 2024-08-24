import java.util.*;
import java.io.*;

public class Main {

    static int[] dx = {-1, 1, 0, 0}; // 상, 하, 좌, 우 방향
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][n];

        // 격자 정보를 입력받음
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] bead = new int[n][n];

        // 구슬의 시작 위치를 입력받아 초기화
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            bead[x][y] = 1;
        }

        // 시뮬레이션 수행
        simulate(t, n, map, bead);
    }

    static void simulate(int t, int n, int[][] map, int[][] bead) {

        while (t-- > 0) {
            int[][] nextBead = new int[n][n]; // 다음 상태를 저장할 배열

            // 각 구슬에 대해 이동을 계산
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (bead[i][j] == 0) continue; // 구슬이 없는 위치는 무시

                    int bx = i;
                    int by = j;
                    int maxVal = map[i][j];

                    // 상하좌우 탐색
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];

                        // 범위를 벗어나는 경우 무시
                        if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;

                        // 더 큰 값을 찾은 경우 갱신
                        if (map[nx][ny] > maxVal) {
                            bx = nx;
                            by = ny;
                            maxVal = map[nx][ny];
                        }
                    }

                    // 구슬 이동
                    nextBead[bx][by]++;
                }
            }

            // 충돌한 구슬 처리
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (nextBead[i][j] > 1) {
                        nextBead[i][j] = 0; // 충돌한 구슬은 모두 사라짐
                    }
                }
            }

            // 다음 상태로 업데이트
            bead = nextBead;
        }

        // 남아있는 구슬의 수 계산
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (bead[i][j] > 0) ans++;
            }
        }

        System.out.print(ans);
    }
}