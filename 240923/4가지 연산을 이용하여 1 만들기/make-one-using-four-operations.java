import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n= Integer.parseInt(br.readLine());

        PriorityQueue<int[]> pq= new PriorityQueue<>((pq1, pq2)-> {
            return pq1[1]- pq2[1];
            });
        
        int ans= -1;
        pq.add(new int[]{n, 0});

        while(!pq.isEmpty()){
            
            int[] cur= pq.poll();

            if(cur[0] == 1){
                ans= cur[1];
                break;
            }

            if(cur[0] > 0) pq.add(new int[]{cur[0]-1, cur[1]+1});

            pq.add(new int[]{cur[0]+1, cur[1]+1});

            if(cur[0] %2 == 0) pq.add(new int[]{cur[0]/2, cur[1]+1});

            if(cur[0] %3 == 0) pq.add(new int[]{cur[0]/3, cur[1]+1});
        }

        System.out.print(ans);

    }
}