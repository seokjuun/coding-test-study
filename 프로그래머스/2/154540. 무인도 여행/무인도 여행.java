import java.util.*;

class Solution {
    
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};
    static boolean[][] visited;
    static List<Integer> list = new ArrayList<>();
    static int m,n;
    
    public int[] solution(String[] maps) {
        
        
        n = maps.length;
        m = maps[0].length();
        visited = new boolean[n][m];
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                
                if(maps[i].charAt(j) == 'X' || visited[i][j]) continue;
                
                list.add(dfs(maps, i, j));
            }
        }
        
        if(list.isEmpty()) return new int[]{-1};
        
        Collections.sort(list);
        
        
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        
        
            
        
        return answer;
    }
    
    static int dfs(String[] maps, int y, int x){
        visited[y][x] = true;
        int sum = maps[y].charAt(x) - '0';
        
        for(int i=0; i<4; i++){
            int ny = y + dy[i];
            int nx = x + dx[i];
            
            if(ny>=n || ny<0 || nx >= m || nx < 0) continue;
            if(maps[ny].charAt(nx) == 'X' || visited[ny][nx]) continue;
            
            sum += dfs(maps,ny,nx);
        }
        
        return sum;
    }
    
}