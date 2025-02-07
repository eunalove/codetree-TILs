import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[3 * n + 1][3 * n + 1];

        int total = 0;
        for (int i = n; i < 2 * n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = n; j < 2 * n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                total += map[i][j];
            }
        }

        int ans = 0;
        if (total > 0) ans = 1;

        for (int i = n; i < 2 * n; i++) {
            for (int j = n; j < 2 * n; j++) {
                for (int maxCnt = 1; maxCnt <= n; maxCnt++) {
                    int gold = 0;

                    // 마름모 내부의 금 개수 계산
                    for (int x = i - maxCnt; x <= i + maxCnt; x++) {
                        for (int y = j - maxCnt; y <= j + maxCnt; y++) {
                            if (x >= 0 && x < 3 * n && y >= 0 && y < 3 * n
                                    && Math.abs(x - i) + Math.abs(y - j) <= maxCnt) {
                                gold += map[x][y];
                            }
                        }
                    }

                    int cost = maxCnt * maxCnt + (maxCnt + 1) * (maxCnt + 1);

                    if (m * gold >= cost) {
                        ans = Math.max(ans, gold);
                    }
                }
            }
        }

        System.out.print(ans);
    }
}
