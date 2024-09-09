//n과 m
import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<Integer>[] graph; 
    public static void main(String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        int n= Integer.parseInt(st.nextToken());
        int m= Integer.parseInt(st.nextToken());

        graph= new ArrayList[n];

        for(int i=0; i<n; i++)
            graph[i]= new ArrayList<Integer>();

        for(int i=0; i<m; i++){
            st= new StringTokenizer(br.readLine());
            int to= Integer.parseInt(st.nextToken()) -1;
            int from= Integer.parseInt(st.nextToken()) -1;

            graph[to].add(from);
            graph[from].add(to);
        }

        Queue<Integer> q= new ArrayDeque<>();
        boolean[] vis= new boolean[n];

        q.add(0);
        vis[0]= true;

        while(!q.isEmpty()){

            int cur= q.poll();

            for(int tmp: graph[cur]){
                if(vis[tmp]) continue;

                vis[tmp]= true;
                q.add(tmp);
            }
        }

        int ans= 0;
        
        for(int i=0; i<n; i++)
            if(vis[i]) ans++;

        System.out.print(ans-1);

    }
}