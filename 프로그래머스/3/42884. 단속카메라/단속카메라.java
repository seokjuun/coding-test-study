import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        
        Arrays.sort(routes, (a,b)->Integer.compare(a[1], b[1]));
        
        int camera = -30001;
        int cnt = 0;
        
        for(int[] route : routes){
            int s = route[0];
            int e = route[1];
            
            if(camera < s){
                cnt++;
                camera = e;
            }  
        }

                    
        
        return cnt;
    }
}