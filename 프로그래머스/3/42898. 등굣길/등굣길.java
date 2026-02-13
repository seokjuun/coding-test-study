import java.util.*;

class Solution {
    

    
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        
        int[][] dp = new int[m+1][n+1];
        
        for(int[] puddle : puddles){
            dp[puddle[0]][puddle[1]] = -1;
        }

        dp[1][1]=1;
        for(int i=1; i<m+1; i++){
            for(int j=1; j<n+1; j++){
                if(dp[i][j] == -1) {
                    dp[i][j] = 0;
                    continue;
                }
                 
                if(i==1 && j==1) continue;
                
                
                
                int a= dp[i-1][j];
                int b= dp[i][j-1];
                
                dp[i][j] = (a+b)%1000000007;
            }
        }
        
        
        return dp[m][n];
    }
}