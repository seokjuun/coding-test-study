import java.util.*;

class Solution {
    static int[] dy = {1,-1,0,0};
    static int[] dx = {0,0,-1,1};
    static int n;
    static int[][][] dist;
    
    static class Node {
        int y,x,cost,dir;
        
        public Node(int y, int x, int cost, int dir){
            this.y = y;
            this.x = x;
            this.cost = cost;
            this.dir = dir; // 들어올때 어딜루?
        }
    }
    
    public int solution(int[][] board) {
        int answer = Integer.MAX_VALUE;
        
        // 상태배열 초기화
        n = board.length;
        dist = new int[n][n][4]; 
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                for(int k=0; k<4; k++){
                    dist[i][j][k] = Integer.MAX_VALUE;
                }
            }
        }
        
        // 우선순위 큐
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b)-> a.cost - b.cost);
        
        // 시작세팅  (0:상 1:하 2:좌 3:우)
        if (board[0][1] == 0) { // 우
            dist[0][1][3] = 100;
            pq.add(new Node(0,1,100,3));
        }
        
        if (board[1][0] == 0) { // 하
            dist[1][0][0] = 100;
            pq.add(new Node(1,0,100,0));
        }

        
        while(!pq.isEmpty()){
            Node poll = pq.poll();
            
            if(dist[poll.y][poll.x][poll.dir] != poll.cost) continue;
            
            for(int i=0; i<4; i++){
                int ny = poll.y + dy[i];
                int nx = poll.x + dx[i];
                
                if(ny < 0 || nx < 0 || ny >= n || nx >= n) continue;
                if(board[ny][nx] == 1) continue;
                
                int ncost = poll.cost +100;
                if(poll.dir != i) ncost +=500;
                
                if (ncost < dist[ny][nx][i]) {
                    pq.add(new Node(ny,nx,ncost,i));
                    dist[ny][nx][i] = ncost;
                }
                
            }
        }
        
        for(int i=0; i<4; i++){
            answer = Math.min(answer, dist[n-1][n-1][i]);
        }
        
        return answer;
    }
    
}