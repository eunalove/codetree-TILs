import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       
        int n = sc.nextInt();

        int[] dp= new int[1001];

        dp[1]= 2;
        dp[2]= 7;

        for(int i=3; i<=n; i++)
            dp[i]= (dp[i-1]*2 + dp[i-2]*3 + 2*(i-2))%1000000007;

        System.out.print(dp[n]);

    }
}