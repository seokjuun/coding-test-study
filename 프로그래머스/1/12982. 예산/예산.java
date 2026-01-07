import java.util.*;

class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        
        Arrays.sort(d);
        int sum =0;
        for(int b : d){
            sum += b;
            if(sum > budget) break;
            answer++;
        }
        
        
        return answer;
    }
}