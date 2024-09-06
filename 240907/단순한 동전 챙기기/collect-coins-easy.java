import java.io.*;
import java.util.*;

public class Main {

    static class Coin{
        int x, y, num;
        Coin(int x, int y, int num) {
            this.x = x;
            this.y = y;
            this.num = num;
        }
    }

    static int ans = Integer.MAX_VALUE;
    static List<Coin> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int sx = 0, sy = 0;
        int ex= 0; int ey= 0;

        for(int i=0; i<n; i++) {
            String str = br.readLine();
            for(int j=0; j<n; j++) {
                char cur = str.charAt(j);
                if(cur == '.') continue;

                if(cur == 'S') {
                    sx= i;
                    sy= j;
                }
                else if(cur == 'E') {
                    ex= i;
                    ey= j;
                }
                else list.add(new Coin(i, j, (int)cur - '0'));
                
            }
        }

        list.sort((l1, l2)-> {
            return l1.num = l2.num;
        });

        subset(sx, sy, 0, 0, 0, ex, ey);
        if(ans == Integer.MAX_VALUE)
            System.out.println(-1);
        else
            System.out.println(ans);
    }

    public static void subset(int x, int y, int cur, int cnt, int idx, int ex, int ey) {

        if(cur == 3) {
            int cal = calculate(ex, ey, x, y);
            ans = Math.min(ans, cnt + cal);
            return;
        }

        if(idx >= list.size()) {
            return;
        }

        Coin c = list.get(idx);
        int ch = calculate(c.x, c.y, x, y);
        // 동전을 선택한 경우
        subset(c.x, c.y, cur+1, cnt+ch, idx+1, ex, ey);
        // 동전을 선택하지 않은 경우
        subset(x, y, cur, cnt, idx+1, ex, ey);
    }

    public static int calculate(int nr, int nc, int r, int c) {

        return Math.abs(r - nr) + Math.abs(c - nc);
    }
}