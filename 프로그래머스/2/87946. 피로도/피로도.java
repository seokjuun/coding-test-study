import java.util.*;
class Solution {
    static int d;
    static boolean[] visited;
    static int answer;
    
    public int solution(int k, int[][] dungeons) {
        
        d = dungeons.length; // 던전 수
        visited = new boolean[d]; // 던전 방문여부 배열
        answer = 0;
        
        dfs(0, k, dungeons); // 카운트, 현재 피로도  
        return answer;
    }
    
    static void dfs(int cnt, int tired, int[][] dungeons){
        // 
        answer = Math.max(answer, cnt);
     
        for(int i =0; i<d; i++){
            if(!visited[i] && dungeons[i][0] <= tired){ 
                visited[i] = true;
                dfs(cnt+1, tired - dungeons[i][1], dungeons);
                visited[i] = false;
            }
        }
    }
}