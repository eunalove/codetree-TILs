import java.util.Scanner;

public class Main {
    public static final int MAX_M = 10000;
    public static final int MAX_N = 100;
    
    public static int n, m;
    public static int[] arr = new int[MAX_N + 1];
    boolean[MAX_N + 1][MAX_M + 1];
    
    public static void initialize() {
        dp[0][0] = true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        for(int i = 1; i <= n; i++)
            arr[i] = sc.nextInt();

        initialize();

        for(int i = 1; i <= n; i++){
            for(int j = 0; j <= m; j++) {
                if(j >= arr[i] && dp[i - 1][j - arr[i]])
                    dp[i][j] = true;
                
                if(dp[i - 1][j])
                    dp[i][j] = true;
            }
        }

        if(dp[n][m])
            System.out.print("Yes");
        else
            System.out.print("No");
    }
}