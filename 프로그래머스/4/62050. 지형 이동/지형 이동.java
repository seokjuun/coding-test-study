import java.util.*;

class Solution {
    
    static int n;
    static int[][] group;
    static int[] dy = {-1,1,0,0}; 
    static int[] dx = {0,0,-1,1};
    static int[] parent;
    
    static class Node{
        int from;
        int to;
        int cost;
        
        public Node(int from, int to, int cost){
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }
    
    public int solution(int[][] land, int height) {
        int answer = 0;
        
        n = land.length;
        group = new int[n][n];
        
        // 사다리없이 이동가능한 그룹별로 묶기
        int gNum = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(group[i][j]>0) continue;
                gNum++;
                bfs(i,j,gNum, land, height);
            }
        }
        
        // 그룹끼리 간선만들기
        List<Node> list = new ArrayList<>();
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                int cg = group[i][j];//current
                
                for(int k =0; k<4; k++){
                    int ny = i + dy[k];
                    int nx = j + dx[k];
                    if(ny<0 || nx<0 || ny>=n || nx>=n) continue;
                    
                    int ng = group[ny][nx];
                    if(cg == ng) continue;
                    
                    int gap = Math.abs(land[i][j] - land[ny][nx]);
                    list.add(new Node(cg, ng, gap));
                }
            }
        }
        
        // 간선 정렬
        Collections.sort(list, (a,b) -> a.cost - b.cost);
        
        // 크루스칼
        parent = new int[gNum+1]; // 그룹 1부터시작
        for(int i =1; i<parent.length; i++){
            parent[i] = i; 
        }
        
        int line =0;
        for(Node node : list){
            // 유니온 파인드
            if(union(node.from, node.to)){
                answer+= node.cost;
                line++;
                if(line == gNum-1) break;
            }
            
        }
        
        
        
        return answer;
    }
    
    static void bfs(int y, int x, int gn, int[][] land, int height){
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{y,x});
        group[y][x] = gn;
        
        while(!queue.isEmpty()){
            int[] poll = queue.poll();
            
            for(int i=0; i<4; i++){
                int ny = poll[0] + dy[i];
                int nx = poll[1] + dx[i];
                
                if(ny<0 || nx<0 || ny>=n || nx>=n || group[ny][nx]>0) continue;
                if (Math.abs(land[poll[0]][poll[1]] - land[ny][nx]) > height) continue;
                
                group[ny][nx] = gn;
                queue.offer(new int[]{ny,nx});
            }
        }
    }
    
    static int find(int n){
        if(parent[n] == n ) return n;
        
        parent[n] = find(parent[n]);
        return parent[n];
    }
    
    static boolean union(int a, int b){
        int rootA = find(a);
        int rootB = find(b);
        if(rootA != rootB){
            parent[rootB] = rootA;
            return true;
        }
        
        return false;
    }
}