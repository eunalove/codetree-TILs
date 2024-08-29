import java.util.*;
import java.io.*;

public class Main {

    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][n];
        ArrayList<Integer>[][] grid = new ArrayList[n][n];

        // Initialize grid
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                grid[i][j] = new ArrayList<>();
                grid[i][j].add(map[i][j]);
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int cur = Integer.parseInt(st.nextToken());
            move(cur, n, map, grid);
        }

        // Output final state
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j].isEmpty()) {
                    sb.append("None\n");
                } else {
                    for (int num : grid[i][j]) {
                        sb.append(num).append(" ");
                    }
                    sb.append("\n");
                }
            }
        }
        System.out.print(sb);
    }

    static void move(int cur, int n, int[][] map, ArrayList<Integer>[][] grid) {
        int x = -1, y = -1;

        // Find the position of 'cur'
        outerLoop:
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j].contains(cur)) {
                    x = i;
                    y = j;
                    break outerLoop;
                }
            }
        }

        int maxVal = -1;
        int maxX = -1, maxY = -1;

        // Find the maximum value in the 8 adjacent cells
for (int i = 0; i < 8; i++) {
    int nx = x + dx[i];
    int ny = y + dy[i];

    // 범위를 벗어나는지 체크
    if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;

    // 인접한 위치의 모든 값을 검사하여 최대 값을 찾기
    for (int value : grid[nx][ny]) {
        if (value > maxVal) {
            maxVal = value;
            maxX = nx;
            maxY = ny;
        }
    }
}

        // Move only the numbers up to 'cur' to the new position
        if (maxX != -1) {
            ArrayList<Integer> temp = new ArrayList<>();
            while (!grid[x][y].isEmpty()) {
                int top = grid[x][y].remove(0);
                temp.add(top);
                if (top == cur) break;
            }

            grid[maxX][maxY].addAll(0, temp);
        }

    }
}