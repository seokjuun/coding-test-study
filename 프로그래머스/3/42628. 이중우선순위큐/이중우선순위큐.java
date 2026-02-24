import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {};
        
        
        PriorityQueue<Integer> minPq = new PriorityQueue<>((a,b)-> Integer.compare(a,b));
        PriorityQueue<Integer> maxPq = new PriorityQueue<>((a,b)-> Integer.compare(b,a));
        
        
        for(String oper : operations){
            StringTokenizer st = new StringTokenizer(oper);
            String cmd = st.nextToken();
            int value = Integer.parseInt(st.nextToken());
            
            if(cmd.equals("I")){
                minPq.offer(value);
                maxPq.offer(value);
            } else {
                if(minPq.isEmpty()) continue;
                
                if(value == -1){ // 최소삭제
                    int min = minPq.poll();
                    maxPq.remove(min);
                } else {
                    int max = maxPq.poll();
                    minPq.remove(max);
                }
            }
        }
        
        if(minPq.isEmpty()){
            return new int[]{0,0};
        }
        
        return new int[]{maxPq.peek(), minPq.peek()};
    }
}