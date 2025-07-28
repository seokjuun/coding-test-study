import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        
        // 우선순위 큐 : 최대 힙으로
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for (int work : works){
            queue.offer(work);
        }
        
        // 작업
        while(n>0 && !queue.isEmpty()){
            int max = queue.poll();
            if(max > 0){
                queue.offer(max-1);
            }
            
            n--;
        }
        
        // 피로도
        long answer =0;
        while(!queue.isEmpty()){
            int value = queue.poll();
            answer += (long) value * value;
        }
        
        return answer;
        
        
    }
}