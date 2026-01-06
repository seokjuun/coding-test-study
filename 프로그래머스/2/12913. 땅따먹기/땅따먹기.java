import java.util.*;

class Solution {
    int solution(int[][] land) {
        int answer = 0;

        int n = land.length;
        
        int[][] dp = new int[n][4];
        
        for(int i=0; i<4; i++){
            dp[0][i] = land[0][i];
        }
        
        for(int i=1; i<n; i++){ 
            for(int j=0; j<4; j++){
                
                if(j == 0){
                    dp[i][j] = Math.max(Math.max(dp[i-1][1], dp[i-1][2]), dp[i-1][3]) + land[i][j];
                } else if(j == 1){
                    dp[i][j] = Math.max(Math.max(dp[i-1][0], dp[i-1][2]), dp[i-1][3]) + land[i][j];
                } else if(j == 2){
                    dp[i][j] = Math.max(Math.max(dp[i-1][0], dp[i-1][1]), dp[i-1][3]) + land[i][j];
                } else if(j == 3){
                    dp[i][j] = Math.max(Math.max(dp[i-1][0], dp[i-1][1]), dp[i-1][2]) + land[i][j];
                }
                
            }
        }
        
        for(int num : dp[n-1]){
            answer = Math.max(answer, num);
        }
        
        return answer;
    }
}