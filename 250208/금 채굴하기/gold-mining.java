//n과 m
import java.util.*;
import java.io.*;

public class Main {

    static int[] dx= {-1, 1, 0, 0};
    static int[] dy= {0, 0, -1, 1};

    public static void main(String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        int n= Integer.parseInt(st.nextToken());
        int m= Integer.parseInt(st.nextToken());

        int[][] map= new int[n][n];

        int total= 0;
        for(int i=0; i<n; i++){
            st= new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                map[i][j]= Integer.parseInt(st.nextToken());
                total+= map[i][j];
            }
        }

        int ans= 0;

        //자기자리에 금이 있는지 체크
        if(total > 0) ans= 1;
        
        //전체를 돌면서 마름모를 체크
        for(int i=1; i<n-1; i++){
            for(int j=1; j<n-1; j++){

                int max= 0;

                //상하좌우로 뻗을 수 있는 최대 마름모길이 체크
                //int maxCnt= Math.min(Math.min(Math.min(i, n- i -1), j), n- j- 1);
                
                for(int maxCnt= Math.min(Math.min(Math.min(i, n- i -1), j), n- j- 1); maxCnt>0; maxCnt--){
                    //뻗어서 계산하기
                    for(int k=0; k<4; k++){
                        int nx= i+ maxCnt* dx[k];
                        int ny= j+ maxCnt* dy[k];

                        max+= map[nx][ny];
                    }

                    if(maxCnt > 1){
                        for(int k= i-maxCnt +1; k<= i+maxCnt-1; k++){
                            for(int l= j-maxCnt+1; l<= j+maxCnt-1; l++)
                                max+= map[k][l];
                        }
                    }

                //손해인지 확인
                //아니면 최대 금의 갯수 수정
                if(m*max - maxCnt*maxCnt- (maxCnt+1)*(maxCnt+1) >= 0)
                    ans= ans> max ? ans: max;

                max= 0;
                }
            }
        }
        System.out.print(ans);
    }
}