import java.util.*;
import java.io.*;

public class Main {
    static int ans= Integer.MIN_VALUE;

    public static void main(String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str= br.readLine();

        Map<Character, Integer> alpa= new HashMap<>();
        int n= str.length();

        dfs(0, n, str, alpa);

        System.out.print(ans);
    }

    static void dfs(int cur, int n, String str, Map<Character, Integer> alpa){
        if(cur > n){

            int val= alpa.get(str.charAt(0));

            for(int i=1; i<n; i+=2){
                char c= str.charAt(i);
                int next= alpa.get(str.charAt(i+1));

                switch(c){
                    case '+': val += next; break;
                    case '-': val -= next; break;
                    case '*': val *= next;
                }
            }

            ans= ans> val? ans: val;
            return;
        }

        for(int i=1; i<=4; i++){
                alpa.put(str.charAt(cur), i);
                dfs(cur+2, n, str, alpa);
                alpa.put(str.charAt(cur), i);
            }
    }
    
}