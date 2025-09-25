import java.util.*;

class Solution {
    static List<Integer>[] listArr;  
    
    public int solution(int n, int[][] wires) {
        listArr = new ArrayList[n+1]; // 송전탑 개수만큼의 크기를 가지는 리스트 배열 (1부터)
        
        for(int i = 1; i<=n; i++){ // 리스트 초기화 (1부터 n까지)
            listArr[i] = new ArrayList<>();
        }
        // 전선 연결
        for(int[] wire : wires){
            int a = wire[0];
            int b = wire[1];
            
            listArr[a].add(b);
            listArr[b].add(a);
        }
        
        // 전선 개수는 n-1개 일거고 n-1개의 전선을 모두 달아 최소값 구한 뒤 리턴?
        int min = 100;
        for(int[] wire : wires){
            int num = check(wire[0], wire[1], listArr, n);
            min = Math.min(min, num);
        }
        
        return min;
    }
    // 한쪽 정점에 대해서만 다른쪽 정점 나오면 거르고 개수 센다면 한번만 확인 하면됨 
    static int check(int a, int b, List<Integer>[] listArr, int n){
        boolean[] visited = new boolean[n+1];
        
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(a);
        visited[a] = true;
        int cnt = 1;
        
        while(!queue.isEmpty()){
            int poll = queue.poll();
            
            for(Integer num : listArr[poll]){
                if(num == b) continue;
                if(!visited[num]){
                    queue.offer(num);
                    visited[num] = true;
                    cnt++;
                }
            }
        }
        
        return Math.abs(2*cnt - n);
    }
    
    
}