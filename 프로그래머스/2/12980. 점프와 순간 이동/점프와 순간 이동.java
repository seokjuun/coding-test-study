import java.util.*;

public class Solution {
    static int ans;
    public int solution(int n) {
        ans = Integer.MAX_VALUE;

        calc(n, 1);

        return ans;
    }
    
    static void calc(int n, int cnt){
        if(n==1){
            ans = Math.min(ans, cnt);
            return;
        }
        
        if(n%2 ==0){
            calc(n/2, cnt);
        } else{
            calc(n-1, cnt+1);
        }
    }
}