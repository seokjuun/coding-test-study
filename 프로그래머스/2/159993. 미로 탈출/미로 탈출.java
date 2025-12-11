import java.util.*;

class Solution {
    
    static int[] dy = {1,-1,0,0};
    static int[] dx = {0,0,-1,1};
    static int sy, sx, ly, lx;
    
    public int solution(String[] maps) {
        int n = maps.length;
        int m = maps[0].length();
        
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (maps[i].charAt(j) == 'S') {
                    sy = i; 
                    sx = j;
                } else if (maps[i].charAt(j) == 'L') {
                    ly = i; 
                    lx = j;
                }
            }
        }
        int first = bfs(maps, 'L', sy, sx);
        if(first == -1) return -1;
        int second = bfs(maps, 'E', ly, lx);
        if(second == -1) return -1;
        
        return first+second;
    }
    
    static int bfs(String[] maps, char t, int yy, int xx){
        boolean[][] visited = new boolean[maps.length][maps[0].length()];
        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{yy,xx,0});
        visited[yy][xx] = true;
        
        while(!queue.isEmpty()){
            int[] poll = queue.poll();
            int y = poll[0];
            int x = poll[1];
            int c = poll[2];
            
            // System.out.println("y : " + y + " x : " + x +" c : " + c);
            
            for(int i=0; i<4; i++){
                int ny = y + dy[i];
                int nx = x + dx[i];
                
                if(ny<0 || ny>=maps.length || nx<0 || nx>=maps[0].length()) continue;
                if(maps[ny].charAt(nx) == 'X') continue;
                if (visited[ny][nx]) continue;
                
                queue.add(new int[]{ny,nx,c+1});
                visited[ny][nx] = true;
                if(maps[ny].charAt(nx) == t) return c+1;
            } 
        }
        
        return -1;
    }
}