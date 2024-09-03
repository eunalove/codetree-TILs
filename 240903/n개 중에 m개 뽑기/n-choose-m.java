import java.util.*;
import java.io.*;

public class Main {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] ans = new int[m];

        dfs(0, 1, n, m, ans);

        System.out.print(sb);
    }

    static void dfs(int cur, int start, int n, int m, int[] ans) {
        if (cur == m) {
            for (int a : ans) {
                sb.append(a).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i <= n; i++) {
            ans[cur] = i;
            dfs(cur + 1, i + 1, n, m, ans);
        }
    }
}