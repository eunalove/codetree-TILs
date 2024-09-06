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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int sx = 0; int sy = 0;
        int ex = 0; int ey= 0;
        List<Coin> list= new ArrayList<>();

        for(int i=0; i<n; i++) {
            String str = br.readLine();
            for(int j=0; j<n; j++) {
                char cur = str.charAt(j);
                if(cur == '.') continue;

                if(cur == 'S') {
                    sx = i;
                    sy = j;
                }
                else if(cur == 'E') {
                    ex = i;
                    ey = j;
                }
                else list.add(new Coin(i, j, (int)cur - '0'));
                
            }
        }

        list.sort((l1, l2)->{
            return l1.num - l2.num;
        });

        subset(0, 0, 0, sx, sy, ex, ey, list);
        ans= ans == Integer.MAX_VALUE? -1: ans;
        System.out.println(ans);
    
    }
    public static void subset(int cur, int cnt, int idx, int x, int y, int ex, int ey, List<Coin> list) {

        if(cur == 3) {
            int cal = calculate(x, y, ex, ey);
            ans = Math.min(ans, cnt + cal);
            return;
        }

        if(idx >= list.size()) {
            return;
        }

        Coin c = list.get(idx);
        int ch = calculate(c.x, c.y, x, y);
        // 동전을 선택한 경우
        subset(cur+1, cnt+ch, idx+1, x, y, ex, ey, list);
        // 동전을 선택하지 않은 경우
        subset(cur, cnt, idx+1, x, y, ex, ey, list);
    }

    public static int calculate(int r, int c, int nr, int nc) {

        return Math.abs(r - nr) + Math.abs(c - nc);
    }
}