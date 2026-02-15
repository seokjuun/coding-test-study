import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        int answer = 1;
        
        int[] target = scores[0];
        
        Arrays.sort(scores, (a,b)->{
            if(a[0] == b[0]) return Integer.compare(a[1], b[1]); 
            return Integer.compare(b[0], a[0]);
        });

        int maxB = 0;
        
        
        for(int[] score : scores){
            if(score[1] < maxB){
                if(score[0] == target[0] && score[1] == target[1]) return -1;
            } else{
                maxB = Math.max(maxB, score[1]);
                if(score[0]+score[1] > target[0]+target[1]){
                    answer++;
                }
            }
        }
        
        return answer;
    }
}