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
        int maxX = x, maxY = y;

        // Find the maximum value in the 8 adjacent cells
        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;

            if (map[nx][ny] > maxVal) {
                maxVal = map[nx][ny];
                maxX = nx;
                maxY = ny;
            }
        }

        // Move only the numbers up to 'cur' to the new position
        if (maxX != x || maxY != y) {
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