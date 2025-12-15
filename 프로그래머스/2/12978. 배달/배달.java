import java.util.*;

class Solution {
    
    static class Node {
        int num;
        int cost;
        
        public Node(int num, int cost){
            this.num = num;
            this.cost = cost;
        }
    }
    
    public int solution(int N, int[][] road, int K) {
        int answer = 0;

        // 가중치가 있는 그래프의 최단 경로 -> 다익스트라
        // 1번마을에서 K >= 최단경로인 노드의 개수
        List<Node>[] list = new ArrayList[N+1];
        for(int i =1; i<=N; i++){
            list[i] = new ArrayList<>();
        }
        
        for(int[] arr: road){ // a,b,cost
            int a = arr[0];
            int b = arr[1];
            int c = arr[2];
            
            list[a].add(new Node(b,c));
            list[b].add(new Node(a,c));
        }
        
        
        int[] dist = new int[N+1];
        for(int i =1; i<=N; i++){
            dist[i] = Integer.MAX_VALUE;
        }
        
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b)-> a.cost - b.cost);
        pq.add(new Node(1,0));
        dist[1] = 0;
        
        while(!pq.isEmpty()){
            Node poll = pq.poll();
            
            if(poll.cost > dist[poll.num]) continue;
            
            for(Node next : list[poll.num]){
                if(dist[next.num] > poll.cost + next.cost){
                    dist[next.num] = poll.cost + next.cost;
                    pq.add(new Node(next.num, dist[next.num]));
                }
                
            }
        }
        
        for(int d : dist){
            if(d <= K){
                answer++;
            }
        }

        return answer-1;
    }
}