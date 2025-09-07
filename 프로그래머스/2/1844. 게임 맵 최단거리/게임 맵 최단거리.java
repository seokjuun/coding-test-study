import java.util.*;


class Solution {

    static int[] dy = {1,-1,0,0};
    static int[] dx = {0,0,-1,1};
    static int[][] visited;
    
    static class Node {
    int y,x;
    public Node(int y, int x){
        this.y = y;
        this.x = x;
        }
    }
    
    public int solution(int[][] maps) {
        visited = new int[maps.length][maps[0].length];
        
        return bfs(0,0, maps);
    }
    
    static int bfs(int y, int x, int[][] maps){
        Deque<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(y,x));
        visited[y][x] = 1;

        while(!queue.isEmpty()){
            Node poll = queue.poll();
            if(poll.y == maps.length-1 && poll.x == maps[0].length-1){
                return visited[poll.y][poll.x];
            }

            for(int i = 0; i<4; i++){
                int cy = poll.y + dy[i];
                int cx = poll.x + dx[i];

                if(cy < 0 || cx < 0 || cy >= maps.length || cx >= maps[0].length ) continue;
                if(maps[cy][cx] == 0 || visited[cy][cx] > 0) continue;
                queue.offer(new Node(cy,cx));
                visited[cy][cx] = visited[poll.y][poll.x] +1;
            }
        }

        return -1;
    }
}















