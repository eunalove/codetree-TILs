import java.util.*;
import java.io.*;

public class Main {
    static int ans= Integer.MIN_VALUE;

    public static void main(String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str= br.readLine();

        int[] alpa= new int[6];

        for(int i=0; i<str.length(); i+=2){
            if(str.charAt(i) == 'a') alpa[0]= -1;
            else if(str.charAt(i) == 'b') alpa[1]= -1;
            else if(str.charAt(i) == 'c') alpa[2]= -1;
            else if(str.charAt(i) == 'd') alpa[3]= -1;
            else if(str.charAt(i) == 'e') alpa[4]= -1;
            else if(str.charAt(i) == 'f') alpa[5]= -1;
        }

        dfs(0, str, alpa);

        System.out.print(ans);
    }

    static void dfs(int cur, String str, int[] alpa){
        if(cur == 6){

            int val= 0; char c= str.charAt(0);
            if(c == 'a') val= alpa[0];
            else if(c == 'b') val= alpa[1];
            else if(c == 'c') val= alpa[2];
            else if(c == 'd') val= alpa[3];
            else if(c == 'e') val= alpa[4];
            else if(c == 'f') val= alpa[5];

            for(int i=1; i<str.length(); i+=2){
                char cur_c= str.charAt(i);
                int next=0;
                c= str.charAt(i+1);

                if(c == 'a') next= alpa[0];
                else if(c == 'b') next= alpa[1];
                else if(c == 'c') next= alpa[2];
                else if(c == 'd') next= alpa[3];
                else if(c == 'e') next= alpa[4];
                else if(c == 'f') next= alpa[5];

                switch(cur_c){
                    case '+': val += next; break;
                    case '-': val -= next; break;
                    case '*': val *= next; break;
                }
            }
            ans= ans> val? ans: val;
            return;
        }


        if (alpa[cur] != -1) {
            dfs(cur + 1, str, alpa);
        } else {
            for (int i = 1; i <= 4; i++) {
                alpa[cur] = i;
                dfs(cur + 1, str, alpa);
                alpa[cur] = -1;
            }
        }
    
    }
    
}