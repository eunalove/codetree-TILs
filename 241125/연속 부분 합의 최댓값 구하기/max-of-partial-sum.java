import java.util.Scanner;

public class Main {
    public static final int INT_MIN = Integer.MIN_VALUE;
    public static final int MAX_N = 100000;

    public static int n;

    public static int[] a = new int[MAX_N + 1];

    public static int[] dp = new int[MAX_N + 1];

    public static void initialize() {
        for(int i = 1; i <= n; i++)
            dp[i] = INT_MIN;
        
        dp[1] = a[1];
    }
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        for(int i = 1; i <= n; i++)
            a[i] = sc.nextInt();

        initialize();

        for(int i = 2; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1] + a[i], a[i]);
        }
        
        int ans = INT_MIN;
        for(int i = 1; i <= n; i++)
            ans = Math.max(ans, dp[i]);

        System.out.println(ans);
    }
}