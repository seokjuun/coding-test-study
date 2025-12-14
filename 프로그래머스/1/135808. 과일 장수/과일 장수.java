import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        
        Arrays.sort(score);
        
        int box = score.length / m;
        int cur = 0;
        int idx = score.length - m; // 처음위치
        
        while(cur < box){
            answer += score[idx]*m;
            cur++;
            idx -= m;
        }
        
        
        return answer;
    }
}