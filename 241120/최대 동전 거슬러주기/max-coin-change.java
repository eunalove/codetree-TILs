import java.util.Scanner;

public class Main {
    public static final int INT_MIN = Integer.MIN_VALUE;
    public static final int MAX_M = 10000;
    public static final int MAX_N = 100;
    
    public static int n, m;
    public static int[] coin = new int[MAX_N + 1];
    
    public static int[] dp = new int[MAX_M + 1];
    
    public static void initialize() {
        for(int i = 0; i <= m; i++)
            dp[i] = INT_MIN;
        
        dp[0] = 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        for(int i = 1; i <= n; i++)
            coin[i] = sc.nextInt();

        initialize();

        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++) {
                if(i >= coin[j]) {
                    if(dp[i - coin[j]] == INT_MIN)
                        continue;
                    
                    dp[i] = Math.max(dp[i], dp[i - coin[j]] + 1);
                }
            }
        }
        int ans = dp[m];

        if(ans == INT_MIN)
            ans = -1;

        System.out.print(ans);
    }
}