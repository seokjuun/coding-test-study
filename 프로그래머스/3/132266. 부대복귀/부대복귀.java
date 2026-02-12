import java.util.*;

class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        int dest = destination;
        List<Integer>[] list = new ArrayList[n+1];

        for(int i=1; i<n+1; i++){
            list[i] = new ArrayList<>();
        }

        for(int[] road : roads){
            int a = road[0];
            int b = road[1];

            list[a].add(b);
            list[b].add(a);
        }
        
        int[] dist = new int[n+1];
        for(int i=0; i<n+1; i++){
            dist[i] = -1;
        }

        // bfs
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(dest); // 목적지 시작
        dist[dest] = 0;
        
        while(!queue.isEmpty()){
            int poll = queue.poll();
            
            for(int node : list[poll]){
                if(dist[node] == -1){
                    dist[node] = dist[poll] +1;
                    queue.offer(node);
                }
            }
        }
        
        for (int i=0; i <sources.length; i++) {
            answer[i] = dist[sources[i]];
        }
        
        return answer;
    }

}

