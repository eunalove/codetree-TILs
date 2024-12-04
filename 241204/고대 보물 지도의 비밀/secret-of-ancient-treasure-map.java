import java.util.Scanner;

public class Main {
    public static final int MAXN = 100005;
    public static final int INF = -1000000009;
    public static int n, k;
    public static int[] a = new int[MAXN];
    public static int[][] dp = new int[MAXN][15];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        k = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
        }

        int ans = INF;
        for (int i = 1; i <= n; i++) {
            if (a[i] >= 0) {
                for (int j = 0; j <= k; j++) {
                    dp[i][j] = Math.max(dp[i - 1][j] + a[i], dp[i][j]);
                    ans = Math.max(ans, dp[i][j]);
                }
            }
            else {
                for (int j = 1; j <= k; j++) {
                    dp[i][j] = Math.max(dp[i - 1][j - 1] + a[i], dp[i][j]);
                    ans = Math.max(ans, dp[i][j]);
                }
            }
        }

        System.out.println(ans);
    }
}