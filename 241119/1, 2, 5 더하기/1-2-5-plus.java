import java.util.Scanner;

public class Main {
    public static final int MOD = 10007;
    public static final int MAX_M = 3;
    public static final int MAX_N = 1000;
    
    public static int n;
    
    public static int[] dp = new int[MAX_N + 1];
    public static int[] numbers = new int[]{1, 2, 5};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        dp[0] = 1;

        // 점화식에 따라 값을 채워줍니다.
        for(int i = 1; i <= n; i++) {
            for(int j = 0; j < MAX_M; j++) {
                if(i >= numbers[j])
                    dp[i] = (dp[i] + dp[i - numbers[j]]) % MOD;
            }
        }

        System.out.print(dp[n]);
    }
}