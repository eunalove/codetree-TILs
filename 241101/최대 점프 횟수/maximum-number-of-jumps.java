import java.util.Scanner;

public class Main {
    public static final int INT_MIN = Integer.MIN_VALUE;
    public static final int MAX_N = 1000;
    
    // 변수 선언
    public static int n;
    public static int[] arr = new int[MAX_N];
    
    public static int[] dp = new int[MAX_N];
    
    public static void initialize() {
        for(int i = 0; i < n; i++)
            dp[i] = INT_MIN;
        dp[0] = 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 입력: 
        n = sc.nextInt();
        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        initialize();

        for(int i = 1; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(dp[j] == INT_MIN)
                    continue;
                
                if(j + arr[j] >= i)
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }
        int ans = INT_MIN;
        for(int i = 0; i < n; i++)
            ans = Math.max(ans, dp[i]);
        
        System.out.print(ans);
    }
}