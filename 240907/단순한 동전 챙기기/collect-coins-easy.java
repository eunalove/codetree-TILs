import java.util.*;

public class Main {
    static int N;
    static char[][] grid;
    static int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // 상하좌우
    static boolean[][] visited;
    static int startX, startY, endX, endY;
    static int answer = Integer.MAX_VALUE;
    static List<int[]> coins = new ArrayList<>(); // 동전 위치를 저장할 리스트

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        grid = new char[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String row = sc.next();
            for (int j = 0; j < N; j++) {
                grid[i][j] = row.charAt(j);
                if (grid[i][j] == 'S') {
                    startX = i;
                    startY = j;
                } else if (grid[i][j] == 'E') {
                    endX = i;
                    endY = j;
                } else if (Character.isDigit(grid[i][j])) {
                    coins.add(new int[]{i, j, grid[i][j] - '0'}); // 동전 위치와 번호 저장
                }
            }
        }

        // 동전의 숫자를 기준으로 정렬
        coins.sort(Comparator.comparingInt(a -> a[2]));

        // DFS로 탐색 시작 (현재 위치는 시작점, 현재 동전 번호는 0)
        dfs(startX, startY, 0, 0, 0);

        // 정답 출력 (도착할 수 없다면 -1 출력)
        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }

    // DFS 함수: x, y는 현재 위치, collected는 수집한 동전 개수, lastCoin은 마지막으로 수집한 동전 번호, moveCount는 현재까지 이동한 횟수
    public static void dfs(int x, int y, int collected, int lastCoin, int moveCount) {
        // 도착지에 도착했고, 3개 이상의 동전을 수집한 경우
        if (x == endX && y == endY && collected >= 3) {
            answer = Math.min(answer, moveCount);
            return;
        }

        // 4방향으로 탐색
        for (int[] dir : directions) {
            int nx = x + dir[0];
            int ny = y + dir[1];

            // 격자 범위를 벗어나지 않고, 아직 방문하지 않은 곳이라면
            if (nx >= 0 && ny >= 0 && nx < N && ny < N && !visited[nx][ny]) {
                visited[nx][ny] = true;

                if (Character.isDigit(grid[nx][ny])) {
                    int coinNumber = grid[nx][ny] - '0';
                    // 동전을 번호 순서대로 수집할 수 있다면
                    if (coinNumber > lastCoin) {
                        dfs(nx, ny, collected + 1, coinNumber, moveCount + 1);
                    }
                }

                // 동전 수집 없이 그냥 지나가는 경우
                dfs(nx, ny, collected, lastCoin, moveCount + 1);

                // 백트래킹
                visited[nx][ny] = false;
            }
        }
    }
}