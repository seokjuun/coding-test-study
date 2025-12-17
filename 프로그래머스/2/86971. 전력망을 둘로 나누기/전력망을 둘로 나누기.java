import java.util.*;

class Solution {
    static List<Integer>[] list;
    static int min = Integer.MAX_VALUE;
    
    public int solution(int n, int[][] wires) {
        list = new ArrayList[n+1];
        for(int i =1; i<n+1; i++){
            list[i] = new ArrayList<>();
        }
        
        for(int[] wire : wires){
            int v1 = wire[0];
            int v2 = wire[1];
            
            list[v1].add(v2);
            list[v2].add(v1);
        }
        
        for(int[] wire: wires){
            // 하나씩 끊어보기
            int v1 = wire[0];
            int v2 = wire[1];
            
            min = Math.min(countNode(v1,v2,n), min);
        }
        
        return min;
    }
    
    static int countNode(int v1, int v2, int n){
        int count = 1;
        boolean[] visited = new boolean[n+1];
        
        Deque<Integer> queue = new ArrayDeque<>();
        queue.add(1);
        visited[1] = true;
        
        while(!queue.isEmpty()){
            int poll = queue.poll();
            
            for(int i=0; i<list[poll].size(); i++){
                int get = list[poll].get(i); 
                if((poll == v1 && get == v2) || (poll == v2 && get ==v1)) continue;
                
                if(!visited[get]){
                    queue.add(get);
                    visited[get] = true;
                    count++;
                }
            }
        }
        
        
        return Math.abs(2*count -n);
    }
}