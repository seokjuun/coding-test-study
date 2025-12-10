import java.util.*;

class Solution {
    
    static boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        visited = new boolean[n];
        for(int i =0; i<n; i++){
            if(visited[i]) continue;
            
            dfs(i, computers);
            answer++;
        }
        
        
        
        return answer;
    }
    
    static void dfs(int c, int[][] computers){
        visited[c] = true;
        
        for(int i=0; i<computers[c].length; i++){
            if(i==c) continue;
            if(computers[c][i] == 0 || visited[i]) continue;
            
            dfs(i, computers);
        }
    }
    
}