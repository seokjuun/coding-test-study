import java.util.*;

class Solution {
    
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};
    static int n,m;
    static int ry,rx, gy,gx;
    static boolean[][] visited;
    
    public int solution(String[] board) {
        
        n = board.length;
        m = board[0].length();
        visited = new boolean[n][m];
        
        find(board, 'R');
        find(board, 'G');
        
        int answer = bfs(board, ry, rx);
        
        return answer;
    }
    
    static int bfs(String[] board, int y, int x){
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{y,x,0});
        visited[y][x] = true;
        
        while(!queue.isEmpty()){
            int[] poll = queue.poll();
            for(int i=0; i<4; i++){
                
                int[] arr = move(board, poll[0], poll[1], i);
                
                if(visited[arr[0]][arr[1]]) continue;
                visited[arr[0]][arr[1]] = true;
                
                if(arr[0] == gy && arr[1] == gx){
                    return poll[2] + 1;
                }
                
                queue.offer(new int[]{arr[0], arr[1], poll[2]+1});
            }
        }
        return -1;
    }
    
    static int[] move(String[] board, int y, int x, int dir){ // 상하좌우
        int sy = y;
        int sx = x;

        while(true){
            int ny = sy + dy[dir];
            int nx = sx + dx[dir];
            
            if(ny < 0 || nx < 0 || ny >= n || nx >= m || board[ny].charAt(nx) == 'D'){
                return new int[]{sy, sx};
            }
            
            sy = ny;
            sx = nx;
        }
        
    }
    
    
    static void find(String[] board, char c){
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(board[i].charAt(j) == 'R' && c == 'R'){
                    ry = i;
                    rx = j;
                    return;
                } 
                
                if(board[i].charAt(j) == 'G' && c =='G'){
                    gy = i;
                    gx = j;
                    return;
                }
            }
        }
    }
}